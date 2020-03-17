package excelOperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadWrite_MultipleTestData {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file = new FileInputStream(".//src//excel_Data//NewTours - Login.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet("New Tours");
		
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		String url="http://newtours.demoaut.com/";		
		driver.get(url);
		
		int rowCount = sheet.getLastRowNum();
		for(int i=1; i<rowCount;i++)
		{
			Row row = sheet.getRow(i);

						
		
				Cell Username = row.getCell(0);
				Cell Password = row.getCell(1);
				
				
				
				WebElement userName = driver.findElement(By.name("userName"));
				userName.sendKeys(Username.getStringCellValue());
				WebElement password = driver.findElement(By.name("password"));
				password.sendKeys(Password.getStringCellValue());
				WebElement signInButton = driver.findElement(By.name("login"));
				signInButton.click();
		
				try
				{		
					WebElement signOut = driver.findElement(By.linkText("SIGN-OFF"));
					String signOutText = signOut.getText();
		
					signOutText.equalsIgnoreCase("Sign-off");
					System.out.println("Logged into New Tours application successfully");
					Cell outPutCell = row.createCell(2);
					outPutCell.setCellValue("Pass");
					FileOutputStream file1 = new FileOutputStream(".//src//excel_Data//NewTours - Login.xlsx");
					workBook.write(file1);
					signOut.click();
				}
				catch(Exception e)
				{
					System.out.println("Failed logging into New Tours application");
					Cell outPutCell = row.createCell(2);
					outPutCell.setCellValue("Fail");
					FileOutputStream file1 = new FileOutputStream(".//src//excel_Data//NewTours - Login.xlsx");
					workBook.write(file1);
				}

			}
		}
		
		
	}