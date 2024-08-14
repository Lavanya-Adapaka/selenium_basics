package selenium_basics;

import java.io.File;
//import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keyboard_Mouse_Operations {
	ChromeDriver driver;
	@BeforeMethod
	public void browserstart() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		//driver.navigate().to("https://www.facebook.com/");	
	}
	//@Test
	public void action_class() {
		Actions action = new Actions(driver); //Actions class for keyboard & Mouse Operations
		driver.findElement(By.id("email")).sendKeys("lavanya@gmail.com");
		action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).build().perform();
		action.sendKeys(Keys.TAB).perform();
		//action.click(driver.findElement(By.name("login"))).perform(); // mouse click
		action.contextClick(driver.findElement(By.name("login"))).perform(); // mouse right click
		//action.moveToElement(driver.findElement(By.name("login"))); //mouse hover
	}
	@Test //Mouse & Keyboard Operations
	public void action_class1() throws Exception {
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).click(driver.findElement(By.xpath("//a[contains(text(),'Amazon miniTV')]"))).keyUp(Keys.CONTROL).build().perform();
    //Screenshot
		TakesScreenshot screenshot = (TakesScreenshot) driver;
	    File f = screenshot.getScreenshotAs(OutputType.FILE);
	    File ft = new File("./Screenshot/screenshot.png");
	    FileUtils.copyFile(f, ft);   
	} 
}
