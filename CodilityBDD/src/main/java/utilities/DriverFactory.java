package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author shridhara.jayaram
 *
 */
public class DriverFactory {

	public WebDriver driver;

	/**Function to get initialize driver and return.
	 * 
	 * @return driver
	 */
	public WebDriver getDriver() {
		try {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();

		} catch (Exception e) {
			System.out.println("Unable to open browser... " + e.getMessage());
		} finally {
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		}

		return driver;
	}

}
