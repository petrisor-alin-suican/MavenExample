package curs16;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class CssSelectors extends BaseTest{

	//@Test
	public void cssSelectorExample() {
			
		WebElement selectedOption =  driver.findElement(By.cssSelector("li[class*='sc_tabs_title'][aria-selected='true']"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('style', 'background:green; border:10px solid red')", selectedOption);
		
		//NOT
		List<WebElement> menuEntries = driver.findElements(By.cssSelector("li[class*='sc_tabs_title']:not([aria-selected='true'])"));
		
		for(WebElement element : menuEntries) {
			jse.executeScript("arguments[0].setAttribute('style', 'background:orange; border:5px solid red')", element);

		}
		
	}
	
	@Test
	public void cssSelectorExample2() {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		//first-of-type
		WebElement homeMenuItem = driver.findElement
				(By.cssSelector("div[class='menu_main_wrap']>nav[class='menu_main_nav_area']>ul>li:first-of-type"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:green; border:10px solid red')", homeMenuItem);

		//first-of-type
		WebElement newReleases = driver.findElement
				(By.cssSelector("div[id*='sc_tabs']>ul[class*='sc_tabs_titles']>li:first-of-type"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:green; border:10px solid red')", newReleases);		
		//nth-of-type
		WebElement comingSoon = driver.findElement
				(By.cssSelector("div[id*='sc_tabs']>ul[class*='sc_tabs_titles']>li:nth-of-type(2)"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:green; border:10px solid red')", comingSoon);
		//nth-of-type
		WebElement bestSellers = driver.findElement
				(By.cssSelector("div[id*='sc_tabs']>ul[class*='sc_tabs_titles']>li:nth-of-type(3)"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:green; border:10px solid red')", bestSellers);
		//last-of-type
		WebElement awardWinners = driver.findElement
				(By.cssSelector("div[id*='sc_tabs']>ul[class*='sc_tabs_titles']>li:last-of-type"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:green; border:10px solid red')", awardWinners);
		
		
		
	}
	
	
}