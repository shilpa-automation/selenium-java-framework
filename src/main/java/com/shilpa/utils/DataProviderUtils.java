package com.shilpa.utils;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws Exception {

        ExcelUtils excel =
                new ExcelUtils(
                        "src/test/resources/testdata/LoginData.xlsx",
                        "Login");

        int rows = excel.getRowCount();
        int cols = excel.getColCount();

        Object[][] data = new Object[rows - 1][cols];

        for (int i = 1; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                data[i - 1][j] =
                        excel.getCellData(i, j);
            }
        }

        excel.closeWorkbook();

        return data;
    }
}