package com.nopCommerceV3.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopCommerceV3.pageObjects.AddNewCustPage;
import com.nopCommerceV3.pageObjects.LoginPage;

public class AddNewCustomer extends BaseClass {
	
	

	@Test
	public void AddnewCust() throws InterruptedException, IOException {
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseURL);
			
	
	LoginPage lp = new LoginPage(driver);
	
	lp.setUserName(username);
	logger.info("User provided"); //logger msg
	
	lp.setPassword(password);
	logger.info("Password provided");//logger msg
	
	lp.clickLogin();
	logger.info("Login in Clicked");//logger msg
	
	
	AddNewCustPage ap = new AddNewCustPage(driver);
	
	ap.ClickonCust1();
	ap.ClickonCust2();
	
	ap.AddNewCustBtn();
	
	
	String email = randomestring() + "@gmail.com";
	ap.AddEmail(email);
	
	ap.AddPwd("Ans123");
	
	ap.SetFirstName("Anshika");
	ap.SetLastName("Sri");
	
	ap.SelectGender("Female");
	
	ap.SelectDate(10, 18, 1994);
	 ap.SetCompName("TCS");
	 
	 
	 ap.Checktaxexempt();
	 
	 ap.SetRoles("Administrators");
	 ap.SetRoles("Registered");
	 
	 ap.clicksave();
	 logger.info("Customer is saved");
	 
	
	  logger.info("Result received");
	  
	  String msg = driver.findElement(By.tagName("body")).getText();
		
		
		if(msg.contains("The new customer has been added successfully"))
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
		}
		else
		{
			CaptureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
				
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	

}
