package curs12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumTest {
	
	
	
	@Test
	public void openBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\suicpet\\eclipse-workspace\\MavenExample\\src\\main\\java\\webdriver\\chromedriver\\windows\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://landing.bookster.ro/");
		
		System.out.println(driver.getTitle());
		
		driver.quit();
	}

}
