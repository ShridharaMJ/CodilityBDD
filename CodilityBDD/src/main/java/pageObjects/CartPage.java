package pageObjects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

	private String productxpath = "//td[@class='product-name']";

	public CartPage(WebDriver driver) {
		super(driver);
	}

	public List<String> getProducts() {
		return getElements(By.xpath(productxpath)).stream().map(element -> element.getText())
				.collect(Collectors.toList());
	}

}