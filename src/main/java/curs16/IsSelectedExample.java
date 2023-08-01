package curs16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class IsSelectedExample extends BaseTest{

	
	@Test
	public void isSelectedTest() throws InterruptedException {
		
		driver.findElement(By.cssSelector("li[class='menu_user_login']>a[href*='popup_login']")).click();
		
		WebElement username = driver.findElement(By.cssSelector("div[class='form_left'] input[id='log']"));
		
		System.out.println(username.isSelected());	
		username.click();
		System.out.println("After click :" + username.isSelected());
		
		System.out.println("-------------------------------------------");
		Thread.sleep(4000);
		WebElement rememberMe =  driver.findElement(By.cssSelector("input[id='rememberme']"));
		
		System.out.println("Before click :" + rememberMe.isSelected());
		rememberMe.click();
		System.out.println("After click :" + rememberMe.isSelected());

		
		
		
	}
	
	
}