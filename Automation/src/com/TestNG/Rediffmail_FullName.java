package com.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Rediffmail_FullName {
	
	WebDriver driver = null;
	String url="https://register.rediff.com/register/register.php?FormName=user_details";
	
	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void FullName()
	{
		
		//<input type="text" onblur="fieldTrack(this);" name="name93ec78d9" value="" style="width:185px;" maxlength="61">
		WebElement fullName = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[3]/td[3]/input"));
		fullName.sendKeys("Live Tech");
	}
	
	/*@AfterTest
	public void tearDown()
	{
		driver.quit();
	}*/

}
