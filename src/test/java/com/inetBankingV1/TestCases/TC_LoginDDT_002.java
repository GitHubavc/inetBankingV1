package com.inetBankingV1.TestCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBankingV1.Utilities.XLUtils;
import com.inetBankingV1.pageObjects.LoginPage;

public class TC_LoginDDT_002 extends BaseClass{
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("user name provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login Failed");
		}else {
			
			Assert.assertTrue(true);
			logger.info("login Passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept(); //close the logout alert
			driver.switchTo().defaultContent();
			
		}
			
		
		
		
		
	}
	
	public boolean isAlertPresent() //user define method to verify alert is present or not
	{
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e) 
		{
			return false;
		}
	}
	
	
	
	@DataProvider(name="LoginData")
	String [][]  getData() throws IOException
	{
		String path = System.getProperty("user.dir") + "/src/test/java/com/inetBankingV1/TestData/LoginData.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
				
			}
		}
		
	return logindata;
	
	}

}
