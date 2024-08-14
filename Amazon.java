package selenium_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	@Test
	public void Amazon1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("nav-link-accountList")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("nav-flyout-ya-newCust")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("lavanya@gmail.com");
		driver.findElement(By.xpath("//span[@id='continue']")).click();
		//driver.close();
	}

}
