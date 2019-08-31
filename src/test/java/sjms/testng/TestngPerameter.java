package sjms.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestngPerameter {

	@Parameters({"browser"})
	@Test
	public void openSSOLoginPage(String browserName) throws Exception{

		    WebDriver driver;
			if (browserName.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			else if(browserName.equals("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			else
			{
				throw new Exception("BrowserName is not correct, correct values are: chrome,firefox");
			}
			
			driver.get("https://sso.rajasthan.gov.in/signin");
			driver.manage().window().maximize();
			
	

	}

}
