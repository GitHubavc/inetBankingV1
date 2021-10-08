package com.inetBankingV1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver){
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement Username;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement Password;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement submit;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement lnkLogout;
	
	
	public void setUserName(String uname)
	{
		Username.sendKeys(uname);
	}
	
	
	public void setPassword(String pwd)
	{
		Password.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		submit.click();
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
	
	
	

}
