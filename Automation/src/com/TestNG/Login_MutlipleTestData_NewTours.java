package com.TestNG;

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
import org.testng.annotations.Test;

public class Login_MutlipleTestData_NewTours extends BaseTest_NewTours {
	
	@Test
	public void logIn() throws IOException
	{
		FileInputStream file = new FileInputStream("./src/excelData/NewTours - Login.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet("Login");
		
		int rowCount = sheet.getLastRowNum();
		
		for(int i=1; i<=rowCount; i++)
		{
			Row row = sheet.getRow(i);
			
			WebElement userName = driver.findElement(By.name("userName"));
			userName.clear();
			userName.sendKeys(row.getCell(0).getStringCellValue());
			
			WebElement password = driver.findElement(By.name("password"));
			password.clear();
			password.sendKeys(row.getCell(1).getStringCellValue());
			
			WebElement signIn = driver.findElement(By.name("login"));
			signIn.click();
			
			try
			{
			
			String expected_ProfileText = "Profile";
			
			WebElement profile = driver.findElement(By.linkText("PROFILE"));
			String actual_WebPageText = profile.getText();
			
			if(actual_WebPageText.equalsIgnoreCase(expected_ProfileText))
			{
				row.createCell(2).setCellValue("Login successful - PASS");
			
				FileOutputStream file1 = new FileOutputStream("./src/excelData/NewTours_LoginTestResults.xlsx");
				workBook.write(file1);
			
				driver.navigate().back();
			}
			
			}
			
			catch(Exception e)
			{
				File invalidLogin_Screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(invalidLogin_Screenshot, new File("./Screenshots/NewTours_InvalidLogin/"+i+".png"));
				
				row.createCell(2).setCellValue("Login failed - FAIL");
				
				FileOutputStream file1 = new FileOutputStream("./src/excel_Results/NewTours_LoginTestResults.xlsx");
				workBook.write(file1);
				
				driver.navigate().back();
				
				
			}
			
		}
	}

}