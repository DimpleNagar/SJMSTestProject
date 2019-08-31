package selenium.functtions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GeneralCapabilites {

	WebDriver driver;

	@BeforeTest
	public void setup() throws Exception {

		// set settings beofre creating IE driver object

		DesiredCapabilities cap = new DesiredCapabilities();
		// Setup browser based and other capabilities
		
		cap.setCapability(CapabilityType.BROWSER_NAME,"chrome");
		cap.setCapability(CapabilityType.BROWSER_VERSION,"75.999");
		
		cap.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT,true);
		
		cap.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT,true);
		
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);// to handle  ssl cert issue
		
		cap.setCapability(CapabilityType.TAKES_SCREENSHOT,true);  // selenium grid 
		
		cap.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR,true);
		
		cap.setCapability(CapabilityType.SUPPORTS_ALERTS,true);
		
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,true);
		cap.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR,true);
		
		WebDriverManager.chromedriver().setup();  // it will download the iedriver.exe 
		
		driver = new ChromeDriver(); // now  ie related settings handled automatically so u don't need to use these settings
		

	}

	public void wait(int seconds) {

		try {
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void cleanup() {
		wait(5);
		driver.quit();
	}

}
