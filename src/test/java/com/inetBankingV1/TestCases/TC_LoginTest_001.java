package com.inetBankingV1.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingV1.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void loginTest() throws IOException{
		
		
		
		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(Username);
		logger.info("Entered Username");
		
		lp.setPassword(Password);
		logger.info("Entered Password");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		}
		else {
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login Test Failed");
		}
		
		
	}

}
