package selenium_basics;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Assertions_Verify {
	@Test
	public static boolean verify(WebDriver driver, String expectedurl) {
		boolean result = false;
		if(driver.getCurrentUrl().equalsIgnoreCase(expectedurl)) {
			result = true;
		}
		return result;	
	}
}
