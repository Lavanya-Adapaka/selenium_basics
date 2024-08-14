package selenium_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
class compare1 {
	//@Test
	public static boolean verify(WebDriver driver, String expectedurl) {
		boolean result = false;
		if(driver.getCurrentUrl().equalsIgnoreCase(expectedurl)) {
			result = true;
		}
		return result;	
	}
}
public class Assertion_compare {
	ChromeDriver driver;
	@BeforeMethod
	public void browserstart() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
	}
	//@Test
	public void compare() {
		//HardAssert
//		boolean result = Assertions_Verify.verify(driver, "https://www.amazon./");
//	    Assert.assertTrue(result,"Expected and Actual URL are mismatch");
//		driver.findElement(By.xpath("//a[contains(text(),'Amazon miniTV')]")).click();
		//SoftAssert
		SoftAssert soft = new SoftAssert();
		boolean result = compare1.verify(driver, "https://www.amazon./");
		soft.assertTrue(result,"Expected and Actual URL are mismatch");
		driver.findElement(By.xpath("//a[contains(text(),'Amazon miniTV')]")).click();
		soft.assertAll();
	}
	//@Test
	public void assertion_verify() {
		String result1 = driver.findElement(By.xpath("//a[contains(text(),'Mobiles')]")).getText();
		Assert.assertEquals(result1, "Mobiles");
		System.out.println("passed");
		String result2 = driver.findElement(By.xpath("//a[contains(text(),'Sell')]")).getText();
		Assert.assertEquals(result2, "Sel");
		System.out.println("passed");
	}
	@Test
	public void assertion_verify2() {
		SoftAssert soft1 = new SoftAssert();
		String result1 = driver.findElement(By.xpath("//a[contains(text(),'Mobiles')]")).getText();
		soft1.assertSame(result1,"Mobiles");
		System.out.println("passed");
		String result2 = driver.findElement(By.xpath("//a[contains(text(),'Sell')]")).getText();
		soft1.assertSame(result2,"Sell");
		System.out.println("passed");
		soft1.assertAll();
	}

}
