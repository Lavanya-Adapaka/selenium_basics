package selenium_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Email {
	ChromeDriver driver;
	@BeforeMethod
	public void Start() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://mail.google.com/mail/u/0/?tab=rm&ogbl#inbox");
	}
	@Test
	public void Mail() {
		driver.findElement(By.id("identifierId")).sendKeys("lavanyaadapakalavi@gmail.com");
		//driver.findElement(By.className("T-I T-I-KE L3")).click();
	}
//	public void close() {
//		driver.quit();
//	}

}
