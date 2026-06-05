package com.shilpa.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public ExcelUtils(String excelPath, String sheetName) throws IOException {

        FileInputStream fis = new FileInputStream(excelPath);

        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
    }

    public int getRowCount() {

        return sheet.getPhysicalNumberOfRows();
    }

    public int getColCount() {

        Row row = sheet.getRow(0);
        return row.getPhysicalNumberOfCells();
    }

    public String getCellData(int rowNum, int colNum) {

        Cell cell = sheet.getRow(rowNum).getCell(colNum);

        return cell.toString();
    }

    public void closeWorkbook() throws IOException {

        workbook.close();
    }
}
