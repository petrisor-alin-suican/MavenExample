package curs13;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.*;

public class TestDependencies {
	
	@Test
	public void method1() {
		assertTrue(false);
		System.out.println("Method 1");
	}
	
	@Test(dependsOnMethods = "method1")
	public void method2() {
		System.out.println("Method 2");
	}
	
	@Test(dependsOnMethods = "method2", alwaysRun = true)
	public void method3() {
		System.out.println("Method 3");
	}

}
