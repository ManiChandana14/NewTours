package ValidatingAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.GetTitle;

public class ValidateTitle_NewTours {

	public static void main(String[] args) {
		
		String url="http://newtours.demoaut.com/";
		String Username="tutorial";
		String Password="tutorial";
		
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get(url);
		//<input type="text" name="userName" size="10">
		//<input type="password" name="password" size="10">
		//<input type="image" name="login" value="Login" src="/images/btn_signin.gif?osCsid=b2b3da3f5bd7dc2629cff5eeb468a96c" width="58" height="17" alt="Sign-In" border="0">
		WebElement userName = driver.findElement(By.name("userName"));
		userName.sendKeys(Username);
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys(Password);
		WebElement signInButton = driver.findElement(By.name("login"));
		signInButton.click();
		
		String actual_NewToursHomePageTitle = driver.getTitle();
		System.out.println("The title of the New Tours Home Page after successful login is: "+actual_NewToursHomePageTitle);
		
		if(actual_NewToursHomePageTitle.contains("Find"))
		{
			System.out.println("The title of the New Tours Home Page after successful login has the required string 'Find'");
		}
		else
		{
			System.out.println("The title of the New Tours Home Page after successful login doesn't have the required string 'Find'");
		}
		
		driver.quit();
	}

}
