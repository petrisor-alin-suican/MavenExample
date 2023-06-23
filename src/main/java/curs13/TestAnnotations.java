package curs13;

import org.testng.annotations.*;
 @Test
public class TestAnnotations {
	
	//@Test
	public void test1() {
		System.out.println("Test 1");
		
	}
	
	//@Test
	public void test2() {
		System.out.println("Test 2");
		
	}
	
	//@Test
	public void test3() {                               // metoda private pica daca facem adnotarea la nivel de clasa    99% din cazuri @Test sta la nivelul metodei
		System.out.println("Test 3");
		
	}
	

}
