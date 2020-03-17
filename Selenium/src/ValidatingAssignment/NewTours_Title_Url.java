package ValidatingAssignment;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTours_Title_Url {

   public static void main(String[] args) throws InterruptedException {

       String url="http://newtours.demoaut.com/";

       System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
       WebDriver driver=new ChromeDriver();

       driver.get(url);

       List<WebElement>homePageLinks_NewTours = driver.findElements(By.tagName("a"));

       int homePageLinksCount_NewTours = homePageLinks_NewTours.size();
       System.out.println("The total number of links in New Tours home page are: "+homePageLinksCount_NewTours);

       for(int i=0; i<homePageLinksCount_NewTours; i++)
       {
        String linkName = homePageLinks_NewTours.get(i).getText();
        String expected_urlAddress = homePageLinks_NewTours.get(i).getAttribute("href");
        homePageLinks_NewTours.get(i).click();
        System.out.println(i+"-"+linkName);
        System.out.println("The title of the "+linkName+" page is: "+driver.getTitle());
        String actualwebpageurl_link = driver.getCurrentUrl();
        System.out.println("The Url address of the "+linkName+" page is: "+actualwebpageurl_link);
        if(actualwebpageurl_link.equals(expected_urlAddress))
        {
         System.out.println("Successfully navigated - PASS");
        }
        else
        {
         System.out.println("Failed to navigate - FAIL");
        }
        System.out.println();

        driver.navigate().back();
        homePageLinks_NewTours = driver.findElements(By.tagName("a"));
       }
       driver.quit();
   }
}