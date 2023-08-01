package curs17;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utils.BaseTest;

public class ExplictWait extends BaseTest{

	@Test
	public void explictWaitExample() {
		
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		
		driver.findElement(By.cssSelector("div[id='start']>button")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElementLocated
				(By.cssSelector("div[id='finish']>h4"), "Hello World!"));
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.cssSelector("div[id='finish']>h4")));
		
		WebElement finish = driver.findElement(By.cssSelector("div[id='finish']>h4"));
		assertEquals(finish.getText(), "Hello World!");
				
		
		/**
		 * 
		 * public void click(WebElement element){
		 * 	
		 * 		try{
		 * 		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeCLickable(element)
		 * 		element.click();		
		 * 
		 * 		}catch(NoSuchElementException e){
		 * 		 .....
		 * 		}
		 * 	
		 * }
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
		
	}
	
	
}