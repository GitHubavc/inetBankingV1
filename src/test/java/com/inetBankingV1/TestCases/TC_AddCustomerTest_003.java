package com.inetBankingV1.TestCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetBankingV1.pageObjects.AddCustomerPage;
import com.inetBankingV1.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException 
	{
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(Username);
		logger.info("User name is provided");
		lp.setPassword(Password);
		logger.info("Password is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		logger.info("providing customer details....");
		
		
		addcust.custName("Amit");
		addcust.custgender("male");
		addcust.custdob("10","15","1985");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987890091");
		String email = randomstring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		logger.info("Validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
		  Assert.assertTrue(true);	
		  logger.info("Test case is passed");
		}
		else
		{
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
			logger.info("Test case is failed");
			
		}
		
	}

	
}
