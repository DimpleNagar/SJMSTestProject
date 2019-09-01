package selenium.functtions;

import com.aventstack.extentreports.testng.listener.ExtentIReporterSuiteClassListenerAdapter;
import com.aventstack.extentreports.testng.listener.ExtentIReporterSuiteListenerAdapter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;

public class MyActions {

	WebDriver driver;
	@BeforeTest
	public void setup() throws Exception {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}


//	 @Test
	public void performDoubleClick() {

		driver.get("file:///C:/Users/Prempc/Downloads/double.html");
		// driver.get("file:///C:/Users/Prempc/Downloads/double.html");
		WebElement eleP = driver.findElement(By.xpath(".//p[@ondblclick = 'myFunction()']"));

		/// there is no dbl click method in Element class
		// we have to use Actions class for this case

		Actions act = new Actions(driver);
		act.doubleClick(eleP).build().perform();

	}

//	 @Test
	public void performDragDrop() {

		driver.get("file:///C:/Users/Prempc/Downloads/dragdrop.html");
		// driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");

		Actions act = new Actions(driver);
		// WebElement eleToDropHere = driver.findElement(By.id("mydropzone"));
		WebElement eleToDropHere = driver.findElement(By.id("div1"));

		// for (int i = 1; i <= 4; i++) {
		// WebElement eleToBeDrag =
		// driver.findElement(By.xpath("//*[@id=\"todrag\"]/span[text()='Draggable
		// " + i +"']"));
		WebElement eleToBeDrag = driver.findElement(By.id("drag1"));
		act.dragAndDrop(eleToBeDrag, eleToDropHere).build().perform();
		wait(3);

		// }

	}

	@Test
	public void selectSubMenu() {

		driver.navigate().to("https://www.seleniumeasy.com/test/table-pagination-demo.html");

		WebElement eleMainMenu = driver
				.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li/a[contains(text(),'Input Forms')]"));

		eleMainMenu.click();

		Actions act = new Actions(driver);

		WebElement eleSubMenu = driver
				.findElement(By.xpath("//ul[@class='dropdown-menu']/li/a[contains(text(),'Checkbox Demo')]"));

		act.moveToElement(eleSubMenu).click().build().perform();

	}

//	 @Test
	public void performRightClickAndMoveSlider() {

		driver.navigate().to("https://www.seleniumeasy.com/test/drag-drop-range-sliders-demo.html");
		Actions act = new Actions(driver);
		WebElement eleRange = driver.findElement(By.xpath("//*[@id=\"slider1\"]/div/input"));
		act.clickAndHold(eleRange).moveByOffset(60, 0).release().build().perform();

	}

//	@Test(description = "How to select a text using ctrl+ a , copy text from one input to other ")
	public void selectAll() {

		driver.navigate().to("https://sso.rajasthan.gov.in/signin");

		// enter user name
		WebElement eleUsername = driver.findElement(By.id("cpBody_txt_Data1"));
		eleUsername.sendKeys("adsds");

		// now select the text

		eleUsername.sendKeys(Keys.chord(Keys.CONTROL, "a"));

		eleUsername.sendKeys(Keys.chord(Keys.CONTROL, "c"));

		// now found another input element
		WebElement elPassword = driver.findElement(By.id("cpBody_txt_Data2"));

		elPassword.sendKeys(Keys.chord(Keys.CONTROL, "v"));

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



	/*
	 * public static void main(String[] args) throws Exception {
	 * 
	 * SeleniumBasicFunstions s = new SeleniumBasicFunstions();
	 * 
	 * s.setup();
	 * 
	 * s.select_checkbox();
	 * 
	 * }
	 */

}
