package selenium_basics;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Adactin {
	ChromeDriver driver;
	@BeforeMethod
	public void start() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
//	driver.navigate().to("http://www.adactin.com/HotelApp/index.php");
	
	}
//	@Test
//	public void Adactin_register() {
//		WebElement register = driver.findElement(By.linkText("New User Register Here"));
//		register.click();
//		driver.findElement(By.name("username")).sendKeys("Lavanya11111");
//		driver.findElement(By.name("password")).sendKeys("123456");
//		driver.findElement(By.id("re_password")).sendKeys("123456");
//		driver.findElement(By.id("full_name")).sendKeys("Lavanya");
//		driver.findElement(By.id("email_add")).sendKeys("lavanyadapakalavi@gmail.com");
//		driver.findElement(By.id("captcha-form")).sendKeys("groping");
//		driver.findElement(By.id("tnc_box")).click();
//		driver.findElement(By.xpath("//input[@type='submit']")).click();
//	}
	@Test
	public void Adactin_login() throws Exception{
		driver.navigate().to("http://www.adactin.com/HotelApp/index.php");
		driver.findElement(By.id("username")).sendKeys("Lavanya11112");
		driver.findElement(By.name("password")).sendKeys("123456");
		String s2 = driver.findElement(By.id("password")).getAttribute("value");
		System.out.println(s2);
		driver.findElement(By.cssSelector("input[type='Submit']")).click();
		String s = driver.getCurrentUrl();
		if(s.equals("http://www.adactin.com/HotelApp/index.php")) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
		Select droploc = new Select(driver.findElement(By.id("location")));
		droploc.selectByVisibleText("Brisbane");
		Select drophotel = new Select(driver.findElement(By.id("hotels")));
		drophotel.selectByIndex(2);
		Select droproom = new Select(driver.findElement(By.id("room_type")));
		droproom.selectByVisibleText("Double");
		Select dropnum = new Select(driver.findElement(By.id("room_nos")));
		dropnum.selectByValue("5");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.id("radiobutton_0")).click();
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("first_name")).sendKeys("Lavanya");
		//Keyboard & Mouse
		Actions action = new Actions(driver);
		action.keyUp(Keys.CONTROL).sendKeys("A").keyDown(Keys.BACK_SPACE).build().perform();
		driver.findElement(By.id("first_name")).sendKeys("Lavanya");
		driver.findElement(By.id("last_name")).sendKeys("Adapaka");
		driver.findElement(By.id("address")).sendKeys("Hyderabad");
		driver.findElement(By.id("cc_num")).sendKeys("3412123412341234");
		Select dropcard = new Select(driver.findElement(By.id("cc_type")));
		dropcard.selectByIndex(3);
		Select dropmonth = new Select(driver.findElement(By.id("cc_exp_month")));
		dropmonth.selectByIndex(4);
		Select dropyear = new Select(driver.findElement(By.id("cc_exp_year")));
		dropyear.selectByIndex(10);
		driver.findElement(By.id("cc_cvv")).sendKeys("345");
		driver.findElement(By.id("book_now")).click();
		driver.findElement(By.linkText("Booked Itinerary")).click();
	
		//Checkbox
		List<WebElement> w = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for(int i=1;i<w.size();i++) {
			if(w.get(i).getAttribute("value").equals("1262362")|| w.get(i).getAttribute("value").equals("1262358")) {
				w.get(i).click();
			}
		}
		WebElement select = driver.findElement(By.xpath("//input[@name='order_id_text']"));
		select.sendKeys("LA29RA5918");
		driver.findElement(By.id("search_hotel_id")).click();
		//Screenshot
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
   		File destination = new File("./Screenshot/Adicton.png");
		FileUtils.copyFile(source,destination);
		
		driver.findElement(By.id("logout")).click();
		driver.findElement(By.linkText("Click here to login again")).click();
	}
		@AfterMethod 
	public void Tear_down() {
		driver.quit();
	}
}
