package com;

import com.producer.goodsreceipt.FullSyncStockCheckQueryItem;
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
    public static List<FullSyncStockCheckQueryItem> importExcel(InputStream inputStream) {
        try {
            Workbook workbook = WorkbookFactory.create(inputStream);
            Cell cell = null;
            List<FullSyncStockCheckQueryItem> entitys = new LinkedList<FullSyncStockCheckQueryItem>();
            for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
                Sheet sheet = workbook.getSheetAt(sheetIndex);

                for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                    Row row = sheet.getRow(rowIndex);
                    if (row == null) {
                        continue;
                    }
                    FullSyncStockCheckQueryItem entity = new FullSyncStockCheckQueryItem();
                    Field[] fields = entity.getClass().getDeclaredFields();
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

                    }
                    entitys.add(entity);
                }
            }
            return entitys;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
