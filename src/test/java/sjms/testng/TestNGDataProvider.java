package sjms.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGDataProvider {

	
	WebDriver driver;
	
	
	@Parameters({"browser"})
	@BeforeTest
	public void setup(String browserName) throws Exception {
		
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
	
	@Test(dataProvider = "logindata")
	public void testLogin(String userName, String password)
	{
		//user name  id -> cpBody_txt_Data1
		// password  id->cpBody_txt_Data2
		// captcha id -> cpBody_ssoCaptcha_txtCaptcha
		// login button name -> ctl00$cpBody$btn_LDAPLogin		
		
		//Enter user name
		WebElement eleUsername = driver.findElement(By.id("cpBody_txt_Data1"));
		eleUsername.clear();
		eleUsername.sendKeys(userName);
		
		// 
		WebElement elePassword = driver.findElement(By.id("cpBody_txt_Data2"));
		elePassword.sendKeys(password);
		// give wait to enter captcha manually
		 wait(20);
		
		// find log in button
		WebElement eleLoginBtn = driver.findElement(By.name("ctl00$cpBody$btn_LDAPLogin"));
		eleLoginBtn.click();
		
		//bootstrap-dialog-message
		// get actual error message
		WebElement eleErrorMsg = driver.findElement(By.className("bootstrap-dialog-message"));
		String act_error = eleErrorMsg.getText().trim();
		
		// Verify error message with expected message
		String exp_error_msg = "Invalid Digital Identity (SSOID/ Username) or Password.";
		
		Assert.assertEquals(act_error, exp_error_msg);
		
		//btn-primary 
		WebElement elePopupOKBtn = driver.findElement(By.className("btn-primary"));
		elePopupOKBtn.click();
		
		wait(30);
		
	}
	
    public void wait(int seconds)
    {
    	
    	try {
		     Thread.sleep(seconds*1000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
    }
	@DataProvider(name="logindata")
	public Object[][] getData()
	{
		// generally we do read data from excel and then create a 2 d array then return array 
		
		// but here i am taking hard coded example to explain data provider concept
		
		String [][] data2 = new String[2][2];
		data2[0][0] = "invalid_username"; 
		data2[0][1] = "invalidpassword";
		data2[1][0] = "sadsaf";
		data2[1][1] = "valid password";
		return data2;
		
	}
	
	@AfterTest
	public void cleanup()
	{
		driver.quit();
	}
	
}
