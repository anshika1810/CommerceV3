package com.nopCommerceV3.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class AddNewCustPage {
	
	WebDriver ldriver;
	
	
	public AddNewCustPage (WebDriver rdriver){
		
		ldriver= rdriver;
		
		PageFactory.initElements(rdriver,this);
	}
	
	By LnkCustomer = By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a/p");
	By LnkCustDrp = By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a/p");
	
	By BtnAddNew = By.xpath("/html/body/div[3]/div[1]/form[1]/div/div/a");
	
	By txtEmail = By.xpath("//*[@id=\"Email\"]");
	By txtPwd = By.xpath("//*[@id=\"Password\"]");
	
	By txtFirstName = By.xpath("//*[@id=\"FirstName\"]");
	 By txtLastName = By.xpath("//*[@id=\"LastName\"]");
	 
	 By btnMale= By.xpath("//*[@id=\"Gender_Male\"]");
	 By btnFemale = By.xpath("//*[@id=\"Gender_Female\"]");
	  By txtCompanyName = By.xpath("//*[@id=\"Company\"]");
	  
	  By chckBoxTax = By.xpath("//*[@id=\"IsTaxExempt\"]");
	  
	  By btnDeleteDefaultRole = By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]");
	   By DrpRoleList = By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div");
	   
	   By DrpVendor = By.xpath("//*[@id=\"VendorId\"]");
	   
	   By TxtAdminComment = By.xpath("//*[@id=\"AdminComment\"]");
	    By btnSave = By.xpath("/html/body/div[3]/div[1]/form/div[1]/div/button[1]");
	     
	    By AltCustomersave =  By.xpath("//div[@class='alert alert-success alert-dismissable']");
	    
	    By txtDOB= By.xpath("//*[@id=\"DateOfBirth\"]");
	    
	    By btnDefaultRegisteredRole = By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[1]");
	    
	    By lstitemAdministrators=By.xpath("//li[contains(text(),'Administrators')]");
		By lstitemRegistered=By.xpath("//li[contains(text(),'Registered')]");
		By lstitemGuests=By.xpath("//li[contains(text(),'Guests')]");
		By lstitemVendors=By.xpath("//li[contains(text(),'Vendors')]");
		
	    
	    
	    
	    public void ClickonCust1 () {
	    	
	  ldriver.findElement(LnkCustomer).click();	    
	    
	    }
	    
	    public void ClickonCust2() {
	    	
	    	ldriver.findElement(LnkCustDrp).click();
	    }
	    
	    public void AddNewCustBtn() {
	    	
	    	ldriver.findElement(BtnAddNew).click();
	    }
	    
	    public void AddEmail(String  Email) {
	    	
	    	ldriver.findElement(txtEmail).sendKeys(Email);
	    }
	    
	    public void AddPwd (String pwd) {
	    	
	    	ldriver.findElement(txtPwd).sendKeys(pwd);
	    }
	    
	    public void SetFirstName (String firstname) {
	    	
	    	ldriver.findElement(txtFirstName).sendKeys(firstname);
	    }
	    
	    public void SetLastName (String lastname) {
	    	ldriver.findElement(txtLastName).sendKeys(lastname);
	    }
	    
	    
	    public void SelectGender(String gender) {
	    	
	    	if (gender == "Male") {
	    		
	    		ldriver.findElement(btnMale).click();
	    		
	    	}
	    		
	    		else if  (gender =="Female")
	    		{
	    			
	    			ldriver.findElement(btnFemale).click();
	    		}
	    		
	    		else {
	    			
	    			System.out.println("Gender not specified");
	    		
	    	}
	    }
	  
	    public void SelectDate (int i, int j, int k) {    	
	    	
	    	
	    	ldriver.findElement(txtDOB).sendKeys(i+"/"+j+"/"+k);	    	
	    	
	    }
	    
	    public void SetCompName(String CompanyName) {
	    	
	    	ldriver.findElement(txtCompanyName).sendKeys(CompanyName);
	    }
	    
	     public void Checktaxexempt() {
	    	 
	    	 ldriver.findElement(chckBoxTax).click();
	     }
	     
	     
	 public void SetRoles(String role) {
		 
		 WebElement listitem;
		 
		 if(ldriver.findElement(btnDefaultRegisteredRole).isDisplayed()) {
			 
			 ldriver.findElement(btnDeleteDefaultRole).click();			 
			 
		 }			 
		 
		 switch(role){
			 
		 case "Administrators":
				listitem=ldriver.findElement(lstitemAdministrators); break;
		case "Guests":
				listitem=ldriver.findElement(lstitemGuests); break;
		case "Registered":
			listitem=ldriver.findElement(lstitemRegistered); break;
		case "Vendors":
			listitem=ldriver.findElement(lstitemVendors); break;
		default:
			listitem=ldriver.findElement(lstitemGuests);
		 }
		 
		 JavascriptExecutor js = (JavascriptExecutor) ldriver;
		 js.executeScript("arguments[0].click();", listitem);
		 
	 }
	 
	 
	 
		public void clicksave() {
			ldriver.findElement(btnSave).click();
		}
		 
		 
		 public String Validatecustcreate() {
			 
			 String  value;
			 
		if  (ldriver.findElement(AltCustomersave).getText().equalsIgnoreCase("The new customer has been added successfully"))
		
{
			
			value = "true";
		
		}
		
		else 
		{
			
		value ="false";
			
		}
		
		return value;
		 }

		
		 
		 
	 }
	     
	    
	    
	   
	  
	


