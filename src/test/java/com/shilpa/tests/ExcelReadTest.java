package com.shilpa.tests;

import org.testng.annotations.Test;
import com.shilpa.utils.DataProviderUtils;

public class ExcelReadTest {

    @Test(dataProvider = "loginData",
          dataProviderClass = DataProviderUtils.class)
    public void readExcel(String username,
                          String password) {

        System.out.println(
                "Username = " + username +
                " Password = " + password);
    }
}