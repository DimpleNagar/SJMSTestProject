package javatest;

public class ExceptionExample {

	
	public static void main(String[] args) {
		
		
		int i = 10;
		
		try {
			System.out.println(i/0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("dsaf");
		
	}
}
