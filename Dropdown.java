
package selenium_basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {
	@Test
	public void Drop() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://www.thetestingworld.com/testings/");
		driver.findElement(By.xpath("//label[@for='tab1']")).click();
		driver.findElement(By.cssSelector(".field")).sendKeys("Lavanya");
		driver.findElement(By.name("fld_email")).sendKeys("Lavanya@gmail.com");
		driver.findElement(By.name("fld_password")).sendKeys("Lavi@1997");
		driver.findElement(By.name("fld_cpassword")).sendKeys("Lavi@1997");
		driver.findElement(By.cssSelector("#datepicker")).sendKeys("09/01/1997");//ID
		driver.findElement(By.name("phone")).sendKeys("7093535099");
		driver.findElement(By.name("address")).sendKeys("Hyderabad");
		driver.findElement(By.name("add_type")).click();
		Select dropsex = new Select(driver.findElement(By.name("sex")));
		dropsex.selectByValue("2");
		Select dropcountry = new Select(driver.findElement(By.name("country")));
		dropcountry.selectByVisibleText("India");
		//Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.name("state")), "Telangana"));
		Select dropstate = new Select(driver.findElement(By.name("state")));
	    dropstate.selectByVisibleText("Telangana");
	    WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait2.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.name("city")), "Hyderabad"));
	    Select dropcity = new Select(driver.findElement(By.name("city")));
	    dropcity.selectByVisibleText("Hyderabad");
	    driver.findElement(By.name("zip")).sendKeys("500055");
	    driver.findElement(By.linkText("Read Detail")).click();
	    driver.findElement(By.className("close")).click();
	    driver.findElement(By.name("terms")).click();
	    driver.findElement(By.xpath("//input[@value='Sign up']")).click();
	    System.out.println("Registration Successfull");
	    String at = driver.getTitle();
	    String et = "Login & Sign Up Forms";
	    if(at.equalsIgnoreCase(et))
	    {
	    	System.out.println("Success");
	    }
	    else
	    {
	    	System.out.println("Fail");
	    }
	    driver.findElement(By.xpath("//label[@for='tab2']")).click();
	    driver.findElement(By.name("_txtUserName")).sendKeys("Lavanya");
	    driver.findElement(By.name("_txtPassword")).sendKeys("Lavi@1997");
	    driver.findElement(By.xpath("//input[@value='Login']")).click();
	    System.out.println("Login Successfull");
	    driver.findElement(By.xpath("//a[@href='logout.php']")).click();
	    System.out.println("Logout Successfully");
	}
}
