package com.shilpa.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.shilpa.driverfactory.DriverFactory;
import com.shilpa.pages.LoginPage;
import com.shilpa.utils.ConfigReader;
import org.testng.annotations.Test;
import com.shilpa.base.BaseTest;
import com.shilpa.driverfactory.DriverFactory;
import com.shilpa.listeners.TestListener;
import com.shilpa.pages.LoginPage;
import com.shilpa.utils.ConfigReader;
import com.shilpa.utils.DataProviderUtils;
import com.shilpa.utils.ScreenshotUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {
	
	private static final Logger log =
	        LogManager.getLogger(LoginTest.class);

	@Test(dataProvider = "loginData",
		      dataProviderClass = DataProviderUtils.class)
		public void sauceDemoLogin(String username,
		                           String password) throws Exception {

		    DriverFactory.getDriver()
		            .get(ConfigReader.getProperty("url"));

		    LoginPage loginPage =
		            new LoginPage(DriverFactory.getDriver());

		    loginPage.login(username, password);
		    
		    String currentUrl =
		            DriverFactory.getDriver().getCurrentUrl();

		    if(username.equals("locked_out_user")) {

		        Assert.assertFalse(
		                currentUrl.contains("inventory"),
		                "Locked user should not login");

		    } else {

		        Assert.assertTrue(
		                currentUrl.contains("inventory"),
		                "Login Failed");
		    }

		    ScreenshotUtils.takeScreenshot(
		            DriverFactory.getDriver(),
		            username);

		    System.out.println(
		            "Login attempted for : " + username);

		    Thread.sleep(2000);
		}
	}