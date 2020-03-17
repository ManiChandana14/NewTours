package ValidatingAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class invalidLogin_OrangeHRM {

	public static void main(String[] args) {
		String url="http://opensource-demo.orangehrmlive.com/";
		String Username="Admin";
		String Password="admin";
		
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get(url);

		WebElement userName = driver.findElement(By.id("txtUsername"));
		userName.sendKeys(Username);
		WebElement password = driver.findElement(By.id("txtPassword"));
		password.sendKeys(Password);
		WebElement logInButton = driver.findElement(By.id("btnLogin"));
		logInButton.click();
//<span id="spanMessage">Invalid credentials</span>		
		WebElement invalidCredentialsElement = driver.findElement(By.id("spanMessage"));
		String invalidCredentialsText = invalidCredentialsElement.getText();
		
		if(invalidCredentialsText.contains("Invalid"))
		{
			System.out.println("Orange HRM application Login failed due to invalid credentials");
		}
		else
		{
			System.out.println("Logged into Orange HRM application successfully");
		}
		//driver.quit();

	}

}