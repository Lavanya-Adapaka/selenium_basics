package selenium_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice1 {
@Test
public void Demo() throws InterruptedException{
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver_win32");
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();	
	    driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("Lavanya@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("pass")).sendKeys("Lavi@1997");
		Thread.sleep(2000);
		driver.findElement(By.name("login")).click();
		//System.out.println(driver.getTitle());
		String at = driver.getTitle();
		String et = "Facebook";
		if(at.equalsIgnoreCase(et)) 
		{
			System.out.println("Test Successfull");
		}
		else 
		{
			System.out.println("Test Failed");
		}
		driver.close();
    }		
}


