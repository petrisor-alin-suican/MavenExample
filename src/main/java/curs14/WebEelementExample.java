package curs14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class WebEelementExample {
	
	WebDriver driver;
	
	@BeforeClass                   
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\suicpet\\eclipse-workspace\\MavenExample\\src\\main\\java\\webdriver\\chromedriver\\windows\\chromedriver.exe");
		//selenium 3     varianta1
		//System.setProperty("webdriver.chrome.driver", "...path catre chromedriver.exe");
		//driver = new ChromeDriver();
		
		//selenium 3 varianta2
		//driver = WebDriverManager.chromedriver.create();
		
		//selenium 4
		driver = new ChromeDriver();
		driver.manage().window().maximize();   //maximizeaza fereastra browserului
		
	}
		
		@Test
		public void webelementExample() {
			
			driver.get("https://keybooks.ro/");

		    //cu albastru  tag html
			//cu rosu  atribut
			//dupa egal sunt valorile atributelor
			
			driver.findElement(By.id("menu_user"));
		
	}
	
		@AfterClass
		public void teardown() {
			
			driver.quit();  // inchide tot browserul cu toate taburile
			//driver.close(); //inchide tabul curent
		}
	

}
