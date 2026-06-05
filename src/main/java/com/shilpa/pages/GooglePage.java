package com.shilpa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GooglePage {

    WebDriver driver;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    By searchBox = By.name("q");

    public void search(String text) {
        driver.findElement(searchBox).sendKeys(text);
    }
}