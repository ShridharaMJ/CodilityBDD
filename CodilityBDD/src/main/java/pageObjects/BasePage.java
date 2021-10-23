package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public WebDriver driver;
	public WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 20);

	}

	public WebElement getElement(By by) {
		return wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
	}

	public List<WebElement> getElements(By by) {
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
	}

	/**
	 * Function to click on element by waiting extranal wait...
	 * 
	 * @param element
	 */
	public void waitAndClick(By element) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		System.out.println("Successfully clicked in element " + element.toString());
	}

	/**
	 * Function to wait and enter value into text box
	 * 
	 * @param element
	 * @param data
	 */
	public void waitAndEnter(By element, String data) {
		wait.until(ExpectedConditions.visibilityOf(getElement(element))).sendKeys(data);
		System.out.println("Successfully clicked in element " + element.toString());
	}

}
