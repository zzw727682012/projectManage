package com.poi;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Stream;

/**
 * @author : liuc
 * @date : 2019/3/18 11:33
 * @description : excel工作表工具类
 */
public class ExcelUtils {

    @SuppressWarnings(value = "uncheck")
    public static void importExcel(InputStream inputStream) {
        try {
            Workbook workbook = WorkbookFactory.create(inputStream);
            Cell cell = null;
            Map<String, FfOrderImportExcelEntity> entityMap = new HashMap<>();
            for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
                Sheet sheet = workbook.getSheetAt(sheetIndex);

                for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                    Row row = sheet.getRow(rowIndex);
                    if (row == null) {
                        continue;
                    }
                    FfOrderImportExcelEntity entity = new FfOrderImportExcelEntity();
                    Field[] fields = entity.getClass().getDeclaredFields();
                    boolean valid = true;
                    for (int columnIndex = 0; columnIndex <= row.getLastCellNum(); columnIndex++) {
                        String value = "";
                        cell = row.getCell(columnIndex);
                        if (cell != null) {
                            switch (cell.getCellTypeEnum()){
                                case STRING:
                                    value = cell.getStringCellValue();
                                    break;
                                case NUMERIC:
                                    value = String.valueOf(new Double(cell.getNumericCellValue()).longValue());
                                    break;
                                    default:
                                        break;
                            }

                            fields[columnIndex].setAccessible(true);
                            fields[columnIndex].set(entity, value);
                        }

                        if (isIndex(columnIndex) && (cell == null || value.trim().length() == 0)) {
                            System.out.println("row " + (rowIndex+1) + " column " + (columnIndex+1) + " is null");
                            valid = false;
                            break;
                        }
                    }
                    if (valid){
                        if (entityMap.containsKey(entity.getOrderId())) {
                            FfOrderImportExcelEntity oldEntity = entityMap.get(entity.getOrderId());
                            for (Field f : fields) {
                                f.setAccessible(true);
                                if (f.get(entity) == null && f.get(oldEntity) != null) {
                                    f.set(entity, f.get(oldEntity));
                                }
                            }
                        }
                        entityMap.put(entity.getOrderId(), entity);
                    }

                    System.out.println(entity.toString());

                }
            }
            System.out.println(entityMap.size());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static boolean isIndex(int index) {
        return index == 1 || index == 11 || index == 12 || index == 18;
    }

    /**
     * 将对象集合写入excel表格
     * 读取对象的 @ExcelDesc 注解,将注解有ExcelDesc的属性写入excel表格
     * 返回excel文件的字节数组
     *
     * @param objs 对象集合
     * @return byte[] 返回文件字节数组
     * @throws Exception
     */
    public static byte[] fileBytes(List objs) throws Exception {
        Workbook workbook = new XSSFWorkbook();
        fillSheet(workbook, "sheet1", objs);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            workbook.write(os);
            return os.toByteArray();
        } finally {
            os.close();
        }
    }

    /**
     * 集合中的集合对象会被当做一个sheet页
     *
     * @param lists 集合的集合
     * @return
     * @throws Exception
     */
    public static byte[] multiSheetBytes(List<List> lists) throws Exception {
        Workbook workbook = new XSSFWorkbook();
        int m = 1;
        for (List list : lists) {
            fillSheet(workbook, "sheet" + (m++), list);
        }
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            workbook.write(os);
            return os.toByteArray();
        } finally {
            os.close();
        }
    }

    private static void fillSheet(Workbook workbook, String sheetName, List objs) throws Exception {
        String sheetNameSwitch = sheetName;

        Object first = objs.get(0);
        Class clz = first.getClass();
        Field[] fields = clz.getDeclaredFields();
        if (null != first) {
            Field sheetField = Stream.of(fields).filter(f -> f.isAnnotationPresent(SheetDesc.class)).findFirst().orElse(null);
            if (sheetField != null) {
                sheetField.setAccessible(true);
                sheetNameSwitch = sheetField.get(first).toString();
            }
        }
        Sheet sheet = workbook.createSheet(sheetNameSwitch == null ? sheetName : sheetNameSwitch);
        CellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        Row row = sheet.createRow(0);
        Cell titleCell = null;

        int m = 0;
        Map<Integer, String> map = new HashMap<>();
        Map<Integer, FormatEnum> formatMap = new HashMap<>();
        for (Field f : fields) {
            if (f.isAnnotationPresent(ExcelDesc.class)) {
                //获取method
                ExcelDesc ed = f.getAnnotationsByType(ExcelDesc.class)[0];
                titleCell = row.createCell(m);
                titleCell.setCellValue(ed.name());
                titleCell.setCellStyle(style);
                map.put(m, f.getName());
                formatMap.put(m, ed.format());
                m++;
            }
        }
        if (!map.isEmpty()) {
            Set<Map.Entry<Integer, String>> set = map.entrySet();
            int i = 1;
            for (Object o : objs) {
                row = sheet.createRow(i);
                for (Map.Entry<Integer, String> e : set) {
                    Field field = o.getClass().getDeclaredField(e.getValue());
                    field.setAccessible(true);
                    FormatEnum fe = formatMap.get(e.getKey());
                    Cell cell = row.createCell(e.getKey());
                    if (fe == FormatEnum.STRING) {
                        cell.setCellType(CellType.STRING);
                        if (field.get(o) != null) {
                            cell.setCellValue(field.get(o).toString());
                        }
                    } else if (fe == FormatEnum.DOUBLE) {
                        cell.setCellType(CellType.NUMERIC);
                        if (field.get(o) != null) {
                            cell.setCellValue(Double.valueOf(field.get(o).toString()));
                        }
                    } else {
                        cell.setCellType(CellType.FORMULA);
                    }
                }
                i++;
            }
        }
    }

}
