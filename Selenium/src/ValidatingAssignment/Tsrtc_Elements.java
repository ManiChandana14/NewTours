package ValidatingAssignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tsrtc_Elements {

	public static void main(String[] args) {
		
		String url="http://tsrtconline.in/";
		
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get(url);
		
		List<WebElement> menuTabElements = driver.findElements(By.className("menu"));
		
		for(int k=0; k<9; k++)
		{
			if(menuTabElements.get(k).isDisplayed())
			{
				String tabName = menuTabElements.get(k).getText();
				System.out.println(tabName);
			}
		}

		driver.quit();
	}

}
