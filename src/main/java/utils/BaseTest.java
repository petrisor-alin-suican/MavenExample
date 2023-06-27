package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

	public WebDriver driver;
	
	@BeforeClass                   
	public void setup() {
		
	
		driver = new ChromeDriver();
		driver.manage().window().maximize();   
		driver.get("https://keybooks.ro/");
}
	
	@AfterClass
	public void teardown() throws InterruptedException {
		
		Thread.sleep(4000); //bad practice
		driver.quit();  
	}
}
