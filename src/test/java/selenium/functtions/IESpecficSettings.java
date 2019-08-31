package selenium.functtions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;


public class IESpecficSettings {

	WebDriver driver;

	@BeforeTest
	public void setup() throws Exception {

		// set settings beofre creating IE driver object

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		
		WebDriverManager.iedriver().setup();  // it will download the iedriver.exe 
		
		driver = new InternetExplorerDriver(cap); // now  ie related settings handled automatically so u don't need to use these settings
		

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
