package selenium_basics;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.internal.net.http.common.Utils;

public class New_Login {
	ChromeDriver driver;
	@BeforeMethod
		public void Open() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.thetestingworld.com/testings/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}
	@Test
	public void Application() throws IOException {
		driver.findElement(By.className("field")).sendKeys("Lavanya");
		
		//MOUSE & KEYBOARD ACTIONS
		/*Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).build().perform();
		action.sendKeys(Keys.TAB).perform();*/
		
		driver.findElement(By.name("fld_email")).sendKeys("lavi@gmail.com");
		WebElement c = driver.findElement(By.xpath("//input[@type='password']"));
		c.sendKeys("Lavi@1997");
		c.sendKeys(Keys.CONTROL,"A"); 
		c.sendKeys(Keys.CONTROL,"c");
		WebElement v = driver.findElement(By.xpath("//input[@name='fld_cpassword']"));
		v.sendKeys(Keys.CONTROL,"v");
		driver.findElement(By.id("datepicker")).sendKeys("30/09/2021");
		driver.findElement(By.cssSelector("input[name='phone']")).sendKeys("7092434566");
		driver.findElement(By.cssSelector("input[name='address']")).sendKeys("Hyderabad");
		driver.findElement(By.xpath("//input[@name='add_type']")).click();
		Select dropsex = new Select(driver.findElement(By.name("sex")));
		dropsex.selectByValue("2");
		Select dropcountry = new Select(driver.findElement(By.id("countryId")));
		dropcountry.selectByVisibleText("India");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.name("state")),"Telangana"));
		Select dropstate = new Select(driver.findElement(By.cssSelector("select[class='states']")));
		dropstate.selectByVisibleText("Telangana");
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait1.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("cityId")), "Hyderabad"));
		Select dropcity = new Select(driver.findElement(By.id("cityId")));
		dropcity.selectByVisibleText("Hyderabad");
		driver.findElement(By.xpath("//input[@name='zip']")).sendKeys("500055");
		driver.findElement(By.linkText("Read Detail")).click();
		driver.findElement(By.className("close")).click();
		driver.findElement(By.name("terms")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println("Registration Successful");
		String at = driver.getTitle();
		String et = "Login & Sign Up Forms";
		if(at.equalsIgnoreCase(et)) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
		driver.findElement(By.xpath("//label[@for='tab2']")).click();
		driver.findElement(By.cssSelector("input[name='_txtUserName']")).sendKeys("Lavanya");
		driver.findElement(By.cssSelector("input[name='_txtPassword']")).sendKeys("Lavi@1997");
		driver.findElement(By.cssSelector("input[value='Login']")).click();		
		System.out.println("Login Successful");
		
		//SCREENSHOT
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File f = screenshot.getScreenshotAs(OutputType.FILE);
		File f1 = new File("./Screenshot/screenshot2.png");
		FileUtils.copyFile(f,f1);
	}
	@AfterMethod
	public void close() {
		driver.findElement(By.xpath("//a[@href='logout.php']")).click();
		System.out.println("Logout Successful");
	}
}
