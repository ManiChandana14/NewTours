package excelOperations;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Write_NewToursCountryList {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		String url="http://newtours.demoaut.com/";		
		driver.get(url);
		
		WebElement register = driver.findElement(By.linkText("REGISTER"));
		register.click();
		
		WebElement country = driver.findElement(By.name("country"));
		List<WebElement>countries = country.findElements(By.tagName("option"));
		
		FileInputStream file = new FileInputStream(".//src//excel_Data//NewTours - Login.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet("New Tours Country List");
		
		for(int i=0; i<countries.size(); i++)
		{
			String countryName = countries.get(i).getText();
			Row row = sheet.createRow(i);
			Cell cell = row.createCell(0);
			cell.setCellValue(countryName);
			FileOutputStream file1 = new FileOutputStream(".//src//excel_Data//NewTours - Login.xlsx");
			workBook.write(file1);
		}
		
		driver.quit();
	}

}
