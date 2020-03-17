package ValidatingAssignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidatingLogin_HomePage_OrangeHRM {

	public static void main(String[] args) {
		
		String url="http://opensource-demo.orangehrmlive.com/";
		String Username="Admin";
		String Password="admin123";
		
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get(url);
		//<div id="logInPanelHeading">LOGIN Panel</div>
		
		WebElement logInPanelElement = driver.findElement(By.id("logInPanelHeading"));
		String logInPanelText = logInPanelElement.getText();
		System.out.println("The Login Panel Element text is: "+logInPanelText);
		
		
		if(logInPanelText.equals("LOGIN Panel"))
		{
			WebElement userName = driver.findElement(By.id("txtUsername"));
			userName.sendKeys(Username);
			WebElement password = driver.findElement(By.id("txtPassword"));
			password.sendKeys(Password);
			WebElement logInButton = driver.findElement(By.id("btnLogin"));
			logInButton.click();
		}
		else
		{
			System.out.println("Login Panel not found");
		}
		
		//<a href="#" id="welcome" class="panelTrigger">Welcome Admin</a>
		//<a href="/index.php/admin/viewAdminModule" id="menu_admin_viewAdminModule" class="firstLevelMenu"><b>Admin</b></a>
		//<b>Admin</b>
		
		WebElement AdminElement = driver.findElement(By.id("welcome"));
		String AdminText = AdminElement.getText();
		
		if(AdminText.contains("Admin"))
		{
			System.out.println("Logged into Orange HRM application as Admin");
		}
		else
		{
			System.out.println("Orange HRM application Login failed");
		}
		
		List<WebElement>links = driver.findElements(By.tagName("a"));
		int linksCount = links.size();
		System.out.println("The total number of links on the Orange HRM Home Page are: "+linksCount);
		
		
		AdminElement.click();
	
		//<a href="/index.php/auth/logout">Logout</a>
		//WebElement logOut = driver.findElement(By.linkText("Logout"));
		//logOut.click();
		
		driver.quit();
	
	}

}
