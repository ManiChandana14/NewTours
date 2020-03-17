package ValidatingAssignment;

import org.openqa.selenium.chrome.ChromeDriver;

public class validatingTitle_Bing {

	public static void main(String[] args) {

		String url="http://bing.com";
		
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		
		driver.get(url);
		String actual_BingHomePageTitle = driver.getTitle();
		String expected_BingHomePageTitle = "Bing";
		
		if(actual_BingHomePageTitle.equals(expected_BingHomePageTitle))
		{
		System.out.println("The actual title of the Bing Home Page is same as the expected title");
		}
		else
		{
			System.out.println("The actual title of the Bing Home Page is not same as the expected title");
		}
		driver.quit();
		
	}

}
