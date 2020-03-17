package ValidatingAssignment;

import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ValidateEmpDetails_OrangeHRM {

	public static void main(String[] args) {
		
		String url="http://127.0.0.1/orangehrm-4.2/symfony/web/index.php/auth/login";
		String Username="Mounika";
		String Password="Gundu@1992";
		
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get(url);
		
		WebElement logInPanelElement = driver.findElement(By.id("logInPanelHeading"));
		String logInPanelText = logInPanelElement.getText();
		
		
		if(logInPanelText.equals("LOGIN Panel"))
		{
			System.out.println("Login Panel found");
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

		WebElement adminElement = driver.findElement(By.id("welcome"));
		String adminText = adminElement.getText();
		
		if(adminText.contains("Admin"))
		{
			System.out.println("Logged into Orange HRM application as Admin");
		}
		else
		{
			System.out.println("Orange HRM application Login failed");
		}
		
		WebElement pimElement = driver.findElement(By.xpath("//*[@id='menu_pim_viewPimModule']"));
		Actions act = new Actions(driver);
		act.moveToElement(pimElement).perform();
		
		WebElement addEmp = driver.findElement(By.xpath("//*[@id=\'menu_pim_addEmployee\']"));
		addEmp.click();
		
		WebElement addEmpText = driver.findElement(By.xpath("//*[@id='addEmployeeTbl']"));
		String webPageText = addEmpText.getText();
		
		if(webPageText.equalsIgnoreCase("Add Employee"))
		{
			System.out.println("Successfully navigated to Add Employee page - 'Add Employee' form found");
		}
		else
		{
			System.out.println("Failed to navigate to Add Employee page");
		}
		
		WebElement empId = driver.findElement(By.id("employeeId"));
		String empIdText = empId.getText();
		System.out.println("The system generated Employee ID is: "+empIdText);
		
		WebElement firstName = driver.findElement(By.id("firstName"));
		firstName.sendKeys("Mani");
		
		WebElement lastName = driver.findElement(By.id("lastName"));
		lastName.sendKeys("Chandana");
		
		WebElement save = driver.findElement(By.id("btnSave"));
		save.click();
	}

}
