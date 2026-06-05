package com.shilpa.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.shilpa.utils.ConfigReader;

public class DriverFactory {
	private static WebDriver driver;

	public static WebDriver initDriver() {

	    String browser = ConfigReader.getProperty("browser");

	    if(browser.equalsIgnoreCase("chrome")) {
	        driver = new ChromeDriver();
	    }

	    driver.manage().window().maximize();

	    return driver;
	}
    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {

        if(driver != null) {
            driver.quit();
        }
    }
}
