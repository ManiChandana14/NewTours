package com.NewToursApplication_TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.BaseTest.BaseTest;
import com.NewToursApplication_WebPages.NewTours_LogInPage;

public class NewTours_LogInPageTest extends BaseTest {
	
	NewTours_LogInPage newToursLogInPage = null;
	
	@Test(priority=1)
	public void signOn()
	{
		newToursLogInPage = PageFactory.initElements(driver,NewTours_LogInPage.class );
		
		newToursLogInPage.SignOn();
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().back();
	}
	
	
	@Test(priority=2)
	public void Register()
	{
		newToursLogInPage = PageFactory.initElements(driver,NewTours_LogInPage.class );
		
		newToursLogInPage.Register();
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	}
	
	@Test(priority=3)
	public void LogIn() throws IOException
	{
		newToursLogInPage = PageFactory.initElements(driver,NewTours_LogInPage.class );
		
		FileInputStream file = new FileInputStream("./src/com/ApplicationTestData/NewTours_LogInTestData.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet("Sheet1");
		
		int rowCount=sheet.getLastRowNum();
		
		for(int i=1;i<=rowCount;i++)
		{
		
			Row row=sheet.getRow(i);
			
		newToursLogInPage.logIn(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue());
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		try
		{
		
		String expected_ProfileText = "Profile";
		
		WebElement profile = driver.findElement(By.linkText("PROFILE"));
		String actual_WebPageText = profile.getText();
		
		if(actual_WebPageText.equalsIgnoreCase(expected_ProfileText))
		{
			row.createCell(2).setCellValue("Login successful - PASS");
		
			FileOutputStream file1 = new FileOutputStream("./src/com/ApplicationTestResults/NewTours_LogInTestResults.xlsx");
			workBook.write(file1);
		
			driver.navigate().back();
		}
		
		}
		
		catch(Exception e)
		{
			File invalidLogin_Screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(invalidLogin_Screenshot, new File("./Screenshots/NewTours_InvalidLogin/"+i+".png"));
			
			row.createCell(2).setCellValue("Login failed - FAIL");
			
			FileOutputStream file1 = new FileOutputStream("./src/com/ApplicationTestResults/NewTours_LogInTestResults.xlsx");
			workBook.write(file1);
			
			driver.navigate().back();
			
		}
	
		}
		
	}
	
	@Test(priority=4)
	public void Support()
	{
		newToursLogInPage = PageFactory.initElements(driver,NewTours_LogInPage.class );
		
		newToursLogInPage.Support();
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	}
	
	@Test(priority=5)
	public void Contact()
	{
		newToursLogInPage = PageFactory.initElements(driver,NewTours_LogInPage.class );
		
		newToursLogInPage.Contact();
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	}
}
