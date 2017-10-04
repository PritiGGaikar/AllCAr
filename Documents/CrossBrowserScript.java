package parallelTest;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserScript {

	WebDriver driver;

	/**
	 * This function will execute before each Test tag in testng.xml
	 * @param browser
	 * @throws Exception
	 */
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception{
		
		/*if(browser.equalsIgnoreCase("firefox")){
		
			System.setProperty("webdriver.firefox.marionette", ".\\geckodriver.exe");
			driver = new FirefoxDriver();
		}*/
		
		 if(browser.equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Priti\\workspace\\chromedriver\\chromedriver.exe");
			
			driver = new ChromeDriver();
		}
		
		 else if(browser.equalsIgnoreCase("IE")){
			    System.setProperty("webdriver.ie.driver", "C:\\Users\\Priti\\workspace\\IEDriverServer_x64_3.3.0\\IEDriverServer.exe");

			     driver = new InternetExplorerDriver();
			     
			   }
		else{
			
			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testParameterWithXML() throws InterruptedException{
		driver.get("http://114.79.180.66/JIBE/Account/Login.aspx?");
		driver.findElement(By.id("ctl00_MainContent_LoginUser_UserName")).sendKeys("priti");
		 driver.findElement(By.id("ctl00_MainContent_LoginUser_Password")).sendKeys("jibe@123");
		 driver.findElement(By.id("ctl00_MainContent_LoginUser_LoginButton")).click();
		 driver.quit();
		 Thread.sleep(3000);
	}
}