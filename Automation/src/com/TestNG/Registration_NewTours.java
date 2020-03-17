package com.TestNG;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Registration_NewTours extends BaseTest_NewTours {
	
	@Test(priority=1)
	public void Register()
	{
		WebElement register = driver.findElement(By.linkText("REGISTER"));
		register.click();
	}
	
	@Test(priority=2)
	public void NewRegistration() throws IOException
	{
		FileInputStream file = new FileInputStream("./src/excelData/NewTours - Login.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet("New Registration");
		
		int rowCount = sheet.getLastRowNum();
		
		for(int i=1; i<=rowCount; i++)
		{
			Row row = sheet.getRow(i);
			
			WebElement firstName = driver.findElement(By.name("firstName"));
			firstName.clear();
			firstName.sendKeys(row.getCell(1).getStringCellValue());
			
			WebElement lastName = driver.findElement(By.name("lastName"));
			lastName.clear();
			lastName.sendKeys(row.getCell(1).getStringCellValue());
			
			double x = row.getCell(2).getNumericCellValue();
			long y = (long)x;
			String phoneNumber = Long.toString(y);
			WebElement phone = driver.findElement(By.name("phone"));
			phone.clear();
			phone.sendKeys(phoneNumber);
			
			WebElement emailId = driver.findElement(By.id("userName"));
			emailId.clear();
			emailId.sendKeys(row.getCell(3).getStringCellValue());
			
			WebElement address1 = driver.findElement(By.name("address1"));
			address1.clear();
			address1.sendKeys(row.getCell(4).getStringCellValue());
			
			WebElement city = driver.findElement(By.name("city"));
			city.clear();
			city.sendKeys(row.getCell(5).getStringCellValue());
			
			WebElement state = driver.findElement(By.name("state"));
			state.clear();
			state.sendKeys(row.getCell(6).getStringCellValue());
			
			double p = row.getCell(7).getNumericCellValue();
			long q = (long)p;
			String postalCode = Long.toString(q);
			WebElement postalCodeWeb = driver.findElement(By.name("postalCode"));
			postalCodeWeb.clear();
			postalCodeWeb.sendKeys(postalCode);
			
			WebElement country = driver.findElement(By.name("country"));
			country.sendKeys(row.getCell(8).getStringCellValue());
			
			WebElement userName = driver.findElement(By.id("email"));
			userName.clear();
			userName.sendKeys(row.getCell(9).getStringCellValue());
			
			WebElement password = driver.findElement(By.name("password"));
			password.clear();
			password.sendKeys(row.getCell(10).getStringCellValue());
			
			WebElement confirmPassword = driver.findElement(By.name("confirmPassword"));
			confirmPassword.clear();
			confirmPassword.sendKeys(row.getCell(11).getStringCellValue());
			
			//password and confirm password validation needs to be one here
			
			WebElement register = driver.findElement(By.name("register"));
			register.click();
			
			String expected_UserName = row.getCell(9).getStringCellValue();
			WebElement registeredElement = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b"));
					
			String actual_RegisteredElementText = registeredElement.getText();
			
			if(actual_RegisteredElementText.contains(expected_UserName))
			{
				System.out.println("Username is same as the submitted name - PASS");
				row.createCell(12).setCellValue("Username is same as the submitted name - PASS");
			}
			else
			{
				System.out.println("Username is not same as the submitted name - FAIL");
				row.createCell(12).setCellValue("Username is not same as the submitted name - FAIL");
			}
			FileOutputStream file1 = new FileOutputStream("./src/excelData/NewTours - Login.xlsx");
			workBook.write(file1);
			driver.navigate().back();
		}
	}
}