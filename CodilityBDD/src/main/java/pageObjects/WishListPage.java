package pageObjects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishListPage extends BasePage {

	private String productsNames = "//td[@class='product-name']";
	private String unitPrices = "//td[@class='product-price']";
	private String itemToAddXpath = "//td[@class='product-name']//a[contains(text(),'{name}')]//parent::td//following-sibling::td[@class='product-add-to-cart']/a";
	private String CartHeader = "//div[contains(@class,'heading-row')]//a[@title='Cart']";
	
	public WishListPage(WebDriver driver) {
		super(driver);
	}

	public List<String> getProducts() {
		return getElements(By.xpath(productsNames)).stream().map(element -> element.getText())
				.collect(Collectors.toList());

	}

	public List<String> getUnitPrice() {
		return getElements(By.xpath(unitPrices)).stream().map(element -> element.getText())
				.collect(Collectors.toList());

	}

	public void clickOnAddCart(String item) {
		waitAndClick(By.xpath(itemToAddXpath.replace("{name}", item)));
	}

	public CartPage clickOnCartHeader() {
		waitAndClick(By.xpath(CartHeader));
		System.out.println("Successfully clicked on wishlist header");
		return new CartPage(driver);
	}

}
