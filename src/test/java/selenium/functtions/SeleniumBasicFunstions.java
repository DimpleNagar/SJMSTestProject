package selenium.functtions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumBasicFunstions {

	WebDriver driver;

	@BeforeTest
	public void setup() throws Exception {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/");
		driver.manage().window().maximize();
	}
	public String Url()
	{
		return "file:///C:/Users/Prempc/Downloads/double.html";
	}
	//	@Test
	public void select_checkbox() {

		// go to url : https://www.seleniumeasy.com/test/basic-checkbox-demo.html
		driver.navigate().to("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
		// how to select box
		// Step 1 : find check box element using findElement method
		// Step 2 : Do click operation as usual
		List<WebElement> elementName = driver.findElements(By.tagName("label"));
		for (int i = 0; i < elementName.size(); i++) {
			if (elementName.get(i).getText().trim().equalsIgnoreCase("Option 1")) {
				elementName.get(i).click();
				WebElement lbl = elementName.get(i);// label
				WebElement chkbox = lbl.findElement(By.tagName("input"));

				// eleCheckBox.click();// click on check box element
				// now verify whether check box selected or not
				if (chkbox.isSelected()) {
					System.out.println("Select ---> TRUE");
				} else {

					System.out.println("Select ---> FALSE");
				}
			}
		}
		wait(5);


	}

	// how to select drop down boxes
	//	@Test
	public void dropdownBox() {

		driver.navigate().to("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");

		WebElement eledrop =  driver.findElement(By.id("select-demo"));
		// to perform action on select boxes use select classes as below
		// Step 1-> find the element 
		// Step 2 -> create Select class object and pass the element in Select class Constructor
		Select select = new Select(eledrop);

		select.selectByVisibleText("Friday");
		//		select.selectByValue("Monday");

		// get selected value

		WebElement eleoption = select.getFirstSelectedOption();
		String option = eleoption.getText();
		if(option.equals("Friday")) {
			System.out.println(option + " is selected successfully..........");
		} 

	}

	@Test
	public void selectrediobutton() {
		//

		driver.navigate().to("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
		selectGender("Male");

	}

	public void selectGender(String genderVal)
	{

		String radioBtn_xpath = ".//input[@name=\"optradio\" and @value=\"gender\"]";
		radioBtn_xpath = radioBtn_xpath.replace("gender", genderVal);

		System.out.println(radioBtn_xpath);

		WebElement eleredio = driver.findElement(By.xpath(radioBtn_xpath));
		eleredio.click();
		if(eleredio.isSelected()) {
			System.out.println("Selected");
		}
		else
		{
			System.out.println( "Not selected");
		}

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





	/*	public static void main(String[] args) throws Exception {

		SeleniumBasicFunstions s = new SeleniumBasicFunstions();

		s.setup();

		s.select_checkbox();

	}*/

}
