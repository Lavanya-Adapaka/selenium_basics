package selenium_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class All_Operations {
	ChromeDriver driver;
	@BeforeMethod
	public void browser_start() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.thetestingworld.com/testings/");
		//driver.get("https://www.thetestingworld.com/testings/");
	}
	@Test
	public void testing() {
		Actions action = new Actions(driver);
		driver.findElement(By.xpath("//label[@for='tab1']")).click();
		driver.findElement(By.className("field")).sendKeys("Lavanya");
		driver.findElement(By.name("fld_email")).sendKeys("lavanya@gmail.com");
		action.keyUp(Keys.CONTROL).sendKeys("A").keyDown(Keys.BACK_SPACE).build().perform();
		driver.findElement(By.name("fld_email")).sendKeys("lavanya@gmail.com");
		driver.findElement(By.xpath("//input[starts-with(@name,'fld_password')]")).sendKeys("Lavu@1111");
		driver.findElement(By.xpath("//input[@className='field' or @name='fld_cpassword']")).sendKeys("Lavu@1111");
		driver.findElement(By.id("datepicker")).sendKeys("09/01/1997");
		action.contextClick(driver.findElement(By.id("datepicker"))).perform();
		WebElement phone = driver.findElement(By.name("phone"));
		phone.sendKeys("9012345678");
		driver.findElement(By.cssSelector("input[name = 'address']")).sendKeys("Hyderabad");
		action.keyDown(Keys.TAB).perform();
		driver.findElement(By.name("add_type")).click();
		
		
	}
	//@AfterMethod
	public void browser_close() {
		driver.close();
	}

}
