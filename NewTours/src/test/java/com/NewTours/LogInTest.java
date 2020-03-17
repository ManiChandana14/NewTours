package com.NewTours;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LogInTest 
{
	
	Logger logger = Logger.getLogger(LogInTest.class);
	
	WebDriver driver = null;
	String url="http://newtours.demoaut.com/";
	
	@BeforeTest
	public void setUp()
	{
		PropertyConfigurator.configure("log4j.properties");
		
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		
		// System.out.println(" Launched Chrome Browser Successfully ");
		
		logger.info(" Launched Chrome Browser Successfully ");
		
		driver.get(url);
		
	//	System.out.println(" Successfully navigated to NewTours Application ");
		
		logger.info(" Successfully navigated to NewTours Application ");
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
		
		//System.out.println(" Application closed Successfully ");
		
		logger.info(" Application closed Successfully ");
	}
	
	
	@Test
	public void logInTest()
	{
		WebElement userName = driver.findElement(By.name("userName"));
		userName.sendKeys("tutorial");
		
		//System.out.println(" Entered UserName Successfully ");
		
		logger.info("Entered UserName Successfully");
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("tutorial");
		
	//	System.out.println(" Entered Password Successfully ");
		
		logger.info(" Entered Password Successfully ");
		
		WebElement logInButton = driver.findElement(By.name("login"));
		logInButton.click();
		
		//System.out.println(" Clicked on LogIn Button ");
		
		logger.info(" Clicked on LogIn Button ");
		
		String expected_Title="Find";
	//	System.out.println("Expected title "+expected_Title);
		
		logger.info("Expected title "+expected_Title);
		
		String actual_title=driver.getTitle();
	//	System.out.println("Actual title "+actual_title);
		
		logger.info("Actual title "+actual_title);
		
		if(actual_title.contains(expected_Title))
		{
			//System.out.println(" LogIn Successfull - PASS");
			
			logger.info(" LogIn Successfull - PASS");
		}
		else
		{
			//System.out.println(" LogIn Fail - FAIL");
			
			logger.info(" LogIn Fail - FAIL");
		}
		
		
	}
	
	
	
	

}
