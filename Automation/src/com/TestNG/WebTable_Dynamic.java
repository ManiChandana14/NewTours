package com.TestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class WebTable_Dynamic extends BaseTest_TimeAndDate {
	
	@Test
	public void WebTable()
	{
		WebElement table = driver.findElement(By.xpath("/html/body/div[1]/div[6]/section[1]/div/section/div[1]"));
		List<WebElement>rows = table.findElements(By.tagName("tr"));
		
		for(int i=0; i<rows.size(); i++)
		{
			List<WebElement>cols = rows.get(i).findElements(By.tagName("td"));
			
			for(int j=0; j<cols.size(); j++)
			{
				String table_Data = cols.get(j).getText();
				System.out.print(table_Data+" ");
			}
			
			System.out.println();
		}
	}

}