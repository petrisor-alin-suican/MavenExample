package curs13;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class AssertionExample {
	
	//assert e o verificare sa stabilim daca un expected result = actual result
	
	String actualTitle = "test";
	String expectedTitle = "masina";
	
	@Test
	public void checkEquality() {
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Test Passed");
		}else {
			System.out.println("Test failed");
		}
	}
	
	
	@Test
	public void checkStringEquality() {
		assertEquals(actualTitle, expectedTitle);
	}
	
	

}
