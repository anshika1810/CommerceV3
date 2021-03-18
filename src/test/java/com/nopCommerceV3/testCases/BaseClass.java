package com.nopCommerceV3.testCases;


import java.io.File;
import java.io.IOException;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;

import com.nopCommerceV3.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUseremail();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	
	public static Logger logger; //Added logger
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String a) {
		
	
		logger = Logger.getLogger("eCommerce"); //Added logger
		PropertyConfigurator.configure("Log4j.properties");//Added logger
	
	
	if (a.equals("Chrome")){	
	
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		driver=new ChromeDriver();}
		
		else if (a.equals("IE")){	
			
			System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
			driver=new ChromeDriver();}
		
			
			else if (a.equals("Firefox")){	
				
				System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
				driver=new ChromeDriver();
	}
	
	}
	
	
	public static void CaptureScreen( WebDriver driver, String tname) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File (System.getProperty("user.dir")+ "/Screenshots/"+ tname+ ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
		
		
		protected static String randomestring() {
			  String generatedString = RandomStringUtils.randomAlphabetic(5);
			return generatedString;
		}
		
		
		
		
	
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
}
