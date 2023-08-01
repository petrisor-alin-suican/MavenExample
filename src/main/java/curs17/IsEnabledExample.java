package curs17;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class IsEnabledExample extends BaseTest{
	
	@Test
	public void isEnabledTest() {
		
		driver.findElement(By.cssSelector("li[class='menu_user_login']")).click();
		
		WebElement usernameField =  driver.findElement(By.cssSelector("input[id='log']"));
		
		System.out.println(usernameField.isEnabled());
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].setAttribute('disabled', 'true')", usernameField);
			
		System.out.println(usernameField.isEnabled());

		
	}
	
	

}