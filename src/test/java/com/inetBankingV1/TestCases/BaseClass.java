package com.inetBankingV1.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBankingV1.Utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplicationURL();
	public String Username = readconfig.getUserName();
	public String Password = readconfig.getPassword();
	public static WebDriver driver;

	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {

		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");

		if (br.equals("edge")) {
			System.setProperty("webdriver.edge.driver", readconfig.getedgepath());
			driver = new EdgeDriver();
		} else if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getchromepath());
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseURL);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/ScreenShots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		
	}
	public String randomstring()
	{
		String generatedstring= RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return(generatedString2);
	}
	
	

}
