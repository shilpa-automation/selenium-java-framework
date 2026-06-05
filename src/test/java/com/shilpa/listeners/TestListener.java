package com.shilpa.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.shilpa.reports.ExtentManager;
import com.shilpa.driverfactory.DriverFactory;
import com.shilpa.utils.ScreenshotUtils;

public class TestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getExtent();
    private static ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        String screenshotPath =
                ScreenshotUtils.takeScreenshot(
                        DriverFactory.getDriver(),
                        result.getName());

        try {
            test.addScreenCaptureFromPath(
                    "../" + screenshotPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}