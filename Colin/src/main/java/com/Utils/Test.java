package com.Utils;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        try {
            Workbook workbook = WorkbookFactory.create(new FileInputStream(new File("C:\\Users\\colinzhou\\Desktop\\取消分配导入模板.xlsx")));
            org.apache.poi.ss.usermodel.Cell cell = null;

            for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
                org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(sheetIndex);

                for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                    Row row = sheet.getRow(rowIndex);
                    if (row == null) {
                        continue;
                    }

                    System.out.println(rowIndex);
                    for (int columnIndex = 0; columnIndex < row.getLastCellNum(); columnIndex++) {
                        String value = "";

                        cell = row.getCell(columnIndex);
                        if (cell != null) {
                            switch (cell.getCellType()) {
                                case 1:
                                    value = cell.getStringCellValue();
                                    break;
                                case 0:
                                    value = new BigDecimal(Double.toString(cell.getNumericCellValue())).intValue()+"";
                                    break;
                                default:
                                    break;
                            }
                        }
                        System.out.println(value);
                        if (cell == null || value.trim().length() == 0) {
                            System.out.println((rowIndex+1) + "----" +(columnIndex+1));
                        }
                    }
                }
            }
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
