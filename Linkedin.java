package selenium_basics;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Linkedin {
	ChromeDriver driver;
	@BeforeMethod
	public void startbrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.linkedin.com/home");
	}
	@Test
	public void keys_mouse_asserts() throws Exception {
		Actions action = new Actions(driver);
		driver.findElement(By.id("session_key")).sendKeys("lavanyaadapakalavi@gmail.com");
		action.keyDown(Keys.TAB).perform();
		driver.findElement(By.name("session_password")).sendKeys("Lavu@1997");
		action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).build().perform();
		driver.findElement(By.name("session_password")).sendKeys("Lavi@1997");
		action.contextClick(driver.findElement(By.xpath("//a[contains(text(),'Forgot password?')]"))).perform();
		action.click(driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"))).perform();
		//Screenshot
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File ft = new File("./Screenshot/screenshot1.png"); 
		FileUtils.copyFile(screenshot, ft);	
	}
}

