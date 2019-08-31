package sjms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ssojava {

	   	         
	        // For SSO Login on Atrocity
	       public static void main(String[] args) {
	            // In this code you have to input only captcha and click on login after fillup the password once you click on login button you have no need to fill password again if required.
	    	   
	    	   WebDriverManager.chromedriver().setup();
	    	   
	            WebDriver fire = new ChromeDriver();
	            fire.get("https://sso.rajasthan.gov.in/signin");
	            fire.findElement(By.id("cpBody_txt_Data1")).sendKeys("atrocity.test");
	            fire.findElement(By.id("cpBody_txt_Data2")).sendKeys("Test@1234");
	            // Wait for Enter Captcha and click on Login
	            try {
					Thread.sleep(10000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            // After click on login this code will check the url and if the current url is of after login page then it will send it to next step in if condition
	            String CurrentURL = fire.getCurrentUrl();
	            System.out.println(CurrentURL);
	            // Code for check the screen which show you are already loggedin and this code will automaticaly identify the screen and fill the password again and click for login
	            if (CurrentURL.equals("https://sso.rajasthan.gov.in/signin")) {
	                if ((fire.getPageSource().contains("cpBody_lblLastSession") == true)) {
	                    fire.findElement(By.id("cpBody_lblLastSession")).click();
	                    fire.findElement(By.id("cpBody_txt_Data2")).sendKeys("Test@1234");
	                    fire.findElement(By.id("cpBody_btn_LDAPLogin")).click();
	                }
	                else {
	                	
	                	fire.findElement(By.id("cpBody_btn_LDAPLogin")).click();
	                }
	                
	            }
	            
	            CurrentURL = fire.getCurrentUrl();
	            System.out.println(CurrentURL);
	            // This line will check that you have loggedin or not
	            if ((CurrentURL.equals("https://sso.rajasthan.gov.in/sso"))) {
	                // System.Threading.Thread.Sleep(10000);
	                // Code for open Atrocity on existing Dashboard
	                // fire.FindElementById("cpBody_dlActiveApps_LinkButton1_0").click();
	                // System.Threading.Thread.Sleep(10000);
	                // After login we will redirect to following URL
	                fire.get("https://sjms.rajasthan.gov.in/atrocities/LoginAuth.aspx?UserTypeID=2&LoginID=ATROCITY.TEST");
	                try {
						Thread.sleep(30000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                // Here we will find the menu url and click on menu
	                // In following code the ctl00_LeftMenuBar is main div of menu bar.
	                // Inside div all menus are in UL LI format then we will get ul by tag name.In the ul tags all menus are in li so inside ul tag we will find li tags and click on 
	                // elements at (index) for expand the menu list of selected li index.
	                // Now in the expanded menu list of selected li we will find the desired menu and click on that.
	                fire.findElement(By.id("ctl00_LeftMenuBar")).findElement(By.tagName("ul")).findElements(By.tagName("li")).get(0).click();
	                // In following code after expand the desired menu we will find the div tag inside expanded menu and in div tag all menu in expanded tag are also in ul li format
	                //  so we will again repeat the process as in previous step find ul then li and then in li we will click on index of li inside the ul tag 
	                fire.findElement(By.id("ctl00_LeftMenuBar")).findElement(By.tagName("ul")).findElements(By.tagName("li")).get(0).findElement(By.tagName("div")).findElement(By.tagName("ul")).findElements(By.tagName("li")).get(0).click();
	                // fire.FindElementById("ctl00_LeftMenuBar").FindElement(By.tagName("ul")).findElements(By.tagName("li")).ElementAt(1).findElements(By.tagName("td")).ElementAt(3).click();
	                // data - appname
	            }
	            
	        
	    
	}
}
