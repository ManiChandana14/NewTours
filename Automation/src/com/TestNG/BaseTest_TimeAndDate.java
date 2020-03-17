package com.TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest_TimeAndDate {
	
	WebDriver driver = null;
	String url = "https://www.timeanddate.com/worldclock/";
	
	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}