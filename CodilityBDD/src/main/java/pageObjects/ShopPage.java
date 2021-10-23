package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShopPage extends BasePage {

	public ShopPage(WebDriver driver) {
		super(driver);
	}

	private String itemXpath = "//li/a/h2[text()='{name}']//ancestor::li//div[@class='yith-wcwl-add-button']";
	private String WishListHeader = "//div[contains(@class,'heading-row')]//a[@title='Wishlist']";


	public ShopPage addToWishList(String itemname) {
		waitAndClick(By.xpath(itemXpath.replace("{name}", itemname)));
		System.out.println(itemname + " successfully added to wishlist....");
		return new ShopPage(driver);
	}

	public WishListPage clickOnWishListHeader() {
		waitAndClick(By.xpath(WishListHeader));
		System.out.println("Successfully clicked on wishlist header");
		return new WishListPage(driver);
	}

	
}
