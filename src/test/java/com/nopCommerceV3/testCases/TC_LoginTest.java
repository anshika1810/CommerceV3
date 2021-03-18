package com.nopCommerceV3.testCases;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopCommerceV3.pageObjects.LoginPage;




public class TC_LoginTest extends BaseClass {

	@Test
	public void loginTest() throws InterruptedException, IOException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseURL);
			
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("User provided"); //logger msg
		
		lp.setPassword(password);
		logger.info("Password provided");//logger msg
		
		lp.clickLogin();
		logger.info("Login in Clicked");//logger msg
		
		if (driver.getTitle().equals("Dashboard / nopCommerce administration")) {
			Thread.sleep(5000);
			lp.clickLogout();
			Assert.assertTrue(true);
			logger.info("Login Passed");//logger msg
			
		} else {
			Assert.assertTrue(false);
			logger.info("Login Failed");//logger msg
			 CaptureScreen( driver, "TC_LoginTest");
		}

	}

	
}
