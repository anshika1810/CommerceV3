package com.nopCommerceV3.testCases;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopCommerceV3.pageObjects.LoginPage;
import com.nopCommerceV3.utilities.XLUtils;

public class TC_LoginDataTest extends BaseClass {
	
	@Test(dataProvider = "LoginData")
	public void logintest(String uname , String pwd) throws IOException, InterruptedException {
		
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(uname);
		
	
		lp.setPassword(pwd);;	
		
			
	lp. clickLogin();		
		
		
Thread.sleep(5000);
	
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
     @DataProvider(name= "LoginData")
	public String[][] getData() throws IOException{
    	 
    	
    	 String path= System.getProperty("user.dir")+ "/src/test/java/com/nopCommerceV3/TestData/LoginData.xlsx";
    	 
    	 int rownum = XLUtils.getRowCount(path, "Sheet1");
    	 int cellnum = XLUtils.getCellCount(path, "Sheet1", 1);
    	 
    	 String LoginData[][]= new String[rownum][cellnum];
    	 
    	 for  (int r =1; r<=rownum;r++) {    // we are not starting from 0 because that is the header portion
    		 
    		 for(int c=0; c<cellnum; c++) {
    			 
    			 LoginData[r-1][c]= XLUtils.getCellData(path, "Sheet1", r, c);
    			 
    	
    
    		 }
    	 }
    	 
    	
    	  
    	  
    	  
    	  
    	 
		
    	 
    	 return LoginData;
		
	}
}
