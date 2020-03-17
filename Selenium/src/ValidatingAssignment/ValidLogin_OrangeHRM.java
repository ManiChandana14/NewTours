package ValidatingAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidLogin_OrangeHRM {

	public static void main(String[] args) {
		
		String url="http://opensource-demo.orangehrmlive.com/";
		String Username="Admin";
		String Password="admin123";
		
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get(url);
		/*String expected_OrangeHRMLogInPageTitle = "OrangeHRM";
		System.out.println("The expected title of the OrangeHRM Login Page is: "+expected_OrangeHRMLogInPageTitle);
		String actual_OrangeHRMWebPageTitle = driver.getTitle();
		System.out.println("The actual title of the OrangeHRM Web Page is: "+actual_OrangeHRMWebPageTitle);
		
		if(actual_OrangeHRMWebPageTitle.equals(expected_OrangeHRMLogInPageTitle))
		{
		System.out.println("Successfully navigated to OrangeHRM LogIn Page");
		}
		else
		{
			System.out.println("Failed to navigate to OrangeHRM LogIn Page");
		}*/
		
		WebElement userName = driver.findElement(By.id("txtUsername"));
		userName.sendKeys(Username);
		WebElement password = driver.findElement(By.id("txtPassword"));
		password.sendKeys(Password);
		WebElement logInButton = driver.findElement(By.id("btnLogin"));
		logInButton.click();
		
		WebElement welcomeAdminElement = driver.findElement(By.id("welcome"));
		String welcomeAdminText = welcomeAdminElement.getText();
		
		if(welcomeAdminText.contains("Welcome"))
		{
			System.out.println("Logged into Orange HRM application successfully");
		}
		else
		{
			System.out.println("Orange HRM application Login failed");
		}
		//driver.quit();

	}

}