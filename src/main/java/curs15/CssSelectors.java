package curs15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import utils.BaseTest;

public class CssSelectors extends BaseTest {
	
	//css navigheaza doar in jos  //navigheaza doar intre < > // nu stie ce in afara < >
	//xpath citeste ce nu se afla intre <>
	//xpath merge in toate directiile
	
	//@Test
	public void cssSelectors() {
		
		//#menu_user  --> gaseste orice element care are atributul ID(#) egal cu menu_user
		//ul#menu_user --> gaseste orice element de tip UL care are ID(#) egal cu menu_user
		//ul[id='menu_user']
		
		WebElement loginMenu = driver.findElement(By.cssSelector("#menu_user"));
		//loginMenu.click();
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[1].setAttribute('style', 'border:10px solid red')", loginMenu);
		
		// .--> referinta catre class
		//div.logo_slogan
		WebElement logo = driver.findElement(By.cssSelector(".logo_slogan"));
		jse.executeScript("arguments[1].setAttribute('style', 'border:10px solid red')", logo);
		
		
		
	}
	
	@Ignore // sau //@Test
	public void cssSelector2() {
		
		driver.findElement(By.cssSelector("li[class='menu_user_login']")).click();
		
		//AND
	    driver.findElement(By.cssSelector("input[id='log'][name='log'][placeholder='Login or Email']")).sendKeys("text");
	    
	    //or
	    driver.findElement(By.cssSelector("input[type='password],[name='pwd']")).sendKeys("text");
	    
	    //direct child
	    driver.findElement(By.cssSelector("div[class='popup_form_field remember_field']>input")).click();
	    
	    //nephew
	    driver.findElement(By.cssSelector("form[class='popup_form login_form'] input[class='submit_button']")).click();
	    
	   
	}
	
	
	@Test
	public void cssSelectors3() {
		
		//contains sau *
		
		WebElement bookTitle = driver.findElement(By.cssSelector("h3[class*='sc_title_reg']"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[1].setAttribute('style', 'border:10px solid red')", bookTitle);
		
	
	   // ~ --> contains word  nu gaseste popup_  dar gaseste popup_form  cauta pana la spatiu
		WebElement bookAuthor = driver.findElement(By.cssSelector("p[style~='center;'"));
		jse.executeScript("arguments[1].setAttribute('style', 'border:10px solid red')", bookAuthor);
	
	
	
	  // ^ --> incepe cu
	   WebElement book = driver.findElement(By.cssSelector("a[href^='life-']"));
	   jse.executeScript("arguments[0].setAttribute('style', 'border:10px solid red')", book);

	   // $ --> ends with
	   
	   WebElement endBook = driver.findElement(By.cssSelector("a[href$='silence']"));
	   jse.executeScript("arguments[0].setAttribute('style', 'border:10px solid red')", endBook);
	}   
}
