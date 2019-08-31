
package sjms.testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeAfterAnnotationTest {

	

	

	@BeforeSuite
	public void seup() {
		System.out.println("BeforeSuite:---seup");
	}
	
	@BeforeTest
	public void beforeAllTest() {
		System.out.println("Before all test.");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before each method.................");
	}
	
	@Test
	public void test1() {
		System.out.println("test case 1");
	}

	@Test
	public void test2() {
		System.out.println("test case 2");
	}
	
	@AfterMethod
	public void afterMethod() {

		System.out.println("after method...");

	}
	
	@AfterTest
	public void afterTest() {

		System.out.println("after All test..");

	}
	
	@AfterSuite
	public void cleanup() {

		System.out.println("cleanup");

	}

}