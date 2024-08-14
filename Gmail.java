package selenium_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Gmail {
	ChromeDriver driver;
	@BeforeMethod
	public void startbrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://accounts.google.com/");
	}
	@Test(priority =1)
	public void gmail1() {
		
	}
	@Test
	public void gmail2() throws InterruptedException {
		driver.findElement(By.name("identifier")).sendKeys("lavanyaadapakalavi@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("identifierNext")).click();
		Thread.sleep(1000);
		String at = driver.getTitle();
		String et = "Sign in - Google Accounts";
		if(at.equalsIgnoreCase(et))
		{
			System.out.println("Passed");
		}
		else
		{
			System.out.println("Fail");
		}
	}
//	@AfterMethod
//	public void closebrowser() {
//		driver.close();
//	}

}
