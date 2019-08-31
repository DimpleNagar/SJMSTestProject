package sjms.testng;

import org.testng.annotations.Test;

public class TestNGGroups {

	
	@Test(groups= {"low","regression"})
	public void test1() {
		System.out.println("test case 1 : low");
	}

	@Test(groups= {"high"})
	public void test2() {
		System.out.println("test case 2: high");
	}
}
