package curs12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumTest {
	
	@Test
	public void openBrowser() {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://keybooks.ro/");
	}

}
