package testNG;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTours_Links {
	
	WebDriver driver = null;
	String url="http://newtours.demoaut.com/";
	
	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void titleCount() throws IOException
	{
		 List<WebElement>homePageLinks_NewTours = driver.findElements(By.tagName("a"));

	       int homePageLinksCount_NewTours = homePageLinks_NewTours.size();
	       System.out.println("The total number of links in New Tours home page are: "+homePageLinksCount_NewTours);

	       for(int i=0; i<homePageLinksCount_NewTours; i++)
	       {
	        String linkName = homePageLinks_NewTours.get(i).getText();
	        String expected_urlAddress = homePageLinks_NewTours.get(i).getAttribute("href");
	        homePageLinks_NewTours.get(i).click();
	        System.out.println(i+"-"+linkName);
	        
	        String actualwebpageurl_link = driver.getCurrentUrl();
	        System.out.println("The Url address of the "+linkName+" page is: "+actualwebpageurl_link);
	        
	        if(actualwebpageurl_link.equals(expected_urlAddress))
	        {
	         System.out.println("Successfully navigated - PASS");
	         
	         File linkScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	         //FileUtils.copyFile(linkScreenshot, new File(".testNG/Screenshots/URL1.png"));
	        }
	        else
	        {
	         System.out.println("Failed to navigate - FAIL");
	        }
	        System.out.println();

	        driver.navigate().back();
	        homePageLinks_NewTours = driver.findElements(By.tagName("a"));
	       }
	}

	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
