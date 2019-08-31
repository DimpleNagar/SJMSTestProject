package selenium.functtions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;

import java.text.BreakIterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Newatrocity  {
	WebDriver driver;
	@BeforeTest

	public void setup() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();




		//driver.get("http://atrocity.mahendrasoftwares.com/Login.aspx"); 
		driver.get("http://10.68.93.68/sjms_atrocities/Login.aspx");
		//VIrendra obj=new VIrendra();
		//driver.get(obj.Url());
		driver.manage().window().maximize();

		WebElement eleUser1 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ctl01_UserType_DropDownList"));
		eleUser1.sendKeys("Police Officer");
		WebElement eleUser = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ctl01_txtLoginName"));
		eleUser.clear();
		eleUser.sendKeys("PS.27541005");

		WebElement elePassword = driver.findElement(By.name("ctl00$ContentPlaceHolder1$ctl01$txtLoginPassword"));

		elePassword.sendKeys("admin@123");

		WebElement eleLogin = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ctl01_btnLogin"));
		eleLogin.click();

		WebElement elecontinue = driver.findElement(By.id("btnNext"));
		elecontinue.click();

		driver.findElement(By.id("ctl00_LeftMenuBar")).findElement(By.tagName("ul")).findElements(By.tagName("li")).get(0).findElement(By.tagName("div")).findElement(By.tagName("ul")).findElements(By.tagName("li")).get(7).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

		driver.switchTo().frame("ctl00_WebpageContentPane");

		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		WebElement eleaddbutton = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnAddFIR"));
		eleaddbutton.click();
		//put FIr num

		WebElement elefirdetail = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFIRNumber"));
		elefirdetail.sendKeys("4546");

		WebElement elecal = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFIRDate"));
		elecal.click();

		driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarDateFrom_daysBody")).findElements(By.tagName("tr")).get(2).findElements(By.tagName("td")).get(2).click();

		WebElement eleattachment = driver. findElement(By.id("ctl00_ContentPlaceHolder1_FileUploadFIRAtt"));
		eleattachment.sendKeys("C:\\Users\\Virender\\Desktop\\HDFCBankStatement.pdf");

		WebElement eleact = driver .findElement(By.id("ctl00_ContentPlaceHolder1_txtIPCSectionSubSection"));
		eleact.sendKeys("act");

		WebElement eleinformer = driver .findElement(By.id("ctl00_ContentPlaceHolder1_txInformerName"));
		eleinformer.sendKeys("Ram");

		WebElement elerelation = driver .findElement(By.id("ctl00_ContentPlaceHolder1_ddlRelation"));
		elerelation.sendKeys("Brother");

		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSave")).click();
		try {
			Thread.sleep(10 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();


		try {
			Thread.sleep(30 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//for click on more option 
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		List <WebElement> elemoreopytion = driver.findElement(By.id("fixTable1")).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
		System.out.println(elemoreopytion.size());

		for(int i=0; i<elemoreopytion.size();i=i+1)
		{
			List <WebElement> elemoreopytioncol =elemoreopytion.get(i).findElements(By.tagName("td"));

			if (elemoreopytioncol.size()>=9)
			{
				System.out.println(elemoreopytioncol.get(3).getText().trim());
				if(elemoreopytioncol.get(3).getText().trim().equals("4546"))
				{
					//elemoreopytioncol.get(8).findElement(By.tagName("a")).click();
					elemoreopytioncol.get(9).findElements(By.tagName("a")).get(0).click();
					break;
				}
			}

		}
		// click on add new victim
		//driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnAddVictim")).click();


		try {
			Thread.sleep(30 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		WebElement elevictimname = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtVictimName"));
		elevictimname.sendKeys("Tra");
		//add father name 


		WebElement eleVfathername = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFaHusName"));
		eleVfathername.sendKeys("karan");
		//addCaste Category

		WebElement elecast = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCasteCategory"));
		elecast.sendKeys("SC");

		try {
			Thread.sleep(10 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//add name


		WebElement elecastname = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCasteName"));
		//elecastname.sendKeys("Badi");
		// creat object of dropdown list
		Select ddl =new Select(elecastname);
		//select value in dropdown list by value 
		ddl.selectByValue("3");

		//add Caste of Accused
		WebElement eleaccused = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CasteAccused"));
		eleaccused.sendKeys("genral");
		//add victim address
		WebElement elevaddress = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtVictimAddress"));
		elevaddress.sendKeys("jaipur");

		//add gender
		WebElement elegender = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlVictimGender"));
		elegender.sendKeys("male");

		//add bank detail
		WebElement elebank = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtBeneficiaryName"));
		elebank.sendKeys("Ram");
		//add Relation with Victim
		WebElement elrelation  = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlRelation"));
		elrelation.sendKeys("Son");

		//add bank accountnumber
		WebElement elbank  = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtBankAccountNumber"));
		elbank.sendKeys("2222222222");
		//add confirimbank accountnumber
		WebElement elbankconfirim  = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtConBankAccountNumber"));
		elbankconfirim.sendKeys("2222222222");
		//add ifsc code 
		WebElement eleifsc  = driver.findElement(By.id("ctl00_ContentPlaceHolder1_Bank_IFSC"));
		eleifsc.sendKeys("HDFC0002838");
		WebElement elemobilenumber1  = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtMobileNo"));
		elemobilenumber1.click();
		try {
			Thread.sleep(20 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		//add mobile number
		WebElement elemobilenumber  = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtMobileNo"));
		elemobilenumber.click();
		elemobilenumber.sendKeys("7777777777");


		// select acted
		WebElement elescstact = driver.findElement(By.id("ctl00_ContentPlaceHolder1_CheckBoxSection_1"));
		elescstact.click();

		//click on save button 

		WebElement elesavebutton = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSave"));
		elesavebutton.click();
		driver.switchTo().alert().accept();

		WebElement elebackbutton = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnBack"));
		elebackbutton.click();





	}



}
