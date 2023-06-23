package curs13;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNgAssertionTypes {
	
	//1.hard assert
	//2.soft assert
	
	//@Test
	public void softAssertExample() {
		System.out.println("Soft assert incepe aici!");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals("123", "abc");
		System.out.println("Soft assert continua aici!");
		sa.assertTrue(false);
		System.out.println("Soft assert se inchide aici!");
		sa.assertAll();
	}
	
	
	
	
	@Test
	public void hardAssertExample() {
		System.out.println("Hard assert incepe aici!");
		assertEquals("123", "abc");
		System.out.println("Hard assert continua aici!");
		assertTrue(false);
		System.out.println("Hard assert se inchide aici!");
		
		
		
	}

}
