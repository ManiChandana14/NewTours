package ValidatingAssignment;

import org.openqa.selenium.chrome.ChromeDriver;

public class validatingUrl_Facebook {

	public static void main(String[] args) {

		String url="http://facebook.com";
		
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		
		driver.get(url);
		String actual_FacebookUrlAddress = driver.getCurrentUrl();
		System.out.println("The actual URL address of the Facebook Login Page is: "+actual_FacebookUrlAddress);
		String expected_FacebookUrlAddress = "facebook.com";
		
		if(actual_FacebookUrlAddress.contains(expected_FacebookUrlAddress))
		{
		System.out.println("The actual URL address of the Facebook Login Page is similar to the expected URL address");
		}
		else
		{
			System.out.println("The actual URL address of the Facebook Login Page is not similar to the expected URL address");
		}
		driver.quit();
	}

}
