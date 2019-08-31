package javatest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Citizen 
{



		WebDriver driver;
		@BeforeTest
	public void setup()throws Exception{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver ();
		driver.get("https://sso.rajasthan.gov.in/signin");
			driver.manage().window().maximize();
			
				
		
		
		
		}	


}


