package selenium_basics;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sample_practice {
	ChromeDriver driver;
	@BeforeMethod
	public void browser_start() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.javatpoint.com/selenium-ide-login-test");
	}
	//@Test
	//public void test_and_quiz() {
		//driver.findElement(By.
	}


