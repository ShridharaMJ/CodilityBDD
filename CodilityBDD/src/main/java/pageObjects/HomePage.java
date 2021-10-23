package pageObjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	private String itemNamexpath = "(//div[@data-id='5f470bd']//li//a/h2)[{i}]";
	private String wishListButton = "//div[@data-id='5f470bd']//li//div[@class='yith-wcwl-add-button']";
	private String wishListItem = "//div[@data-id='5f470bd']//li//a/h2[text()='{item_name}']";
	private String WishListHeader = "//div[contains(@class,'heading-row')]//a[@title='Wishlist']";
	private String shopMenu = "//a[@title='Shop']";

	public HomePage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Page utilities to add wishlist random feature items
	 * 
	 */
	public String addRandomItemsToWishListAndReturnName() {
		String itemName;
		List<WebElement> elements = getElements(By.xpath(wishListButton));
		int item = new Random().nextInt(elements.size());
		itemNamexpath.replace("{i}", String.valueOf(item));
		itemName = getElement(By.xpath(itemNamexpath)).getText();
		System.out.println("Adding item: " + itemName + " Wishlist");
		elements.get(item).click();
		System.out.println(itemName + " is successfuly added to WishList");
		return itemName;

	}

	public HomePage addFeaturedItemToWishList(String itemName) {
		wishListItem = wishListItem.replace("{item_name}", itemName);
		waitAndClick(By.xpath(wishListItem));
		System.out.println(itemName + " Successfully added to wish list..");
		return new HomePage(driver);
	}

	public WishListPage clickOnWishListHeader() {
		waitAndClick(By.xpath(WishListHeader));
		System.out.println("Successfully clicked on wishlist header");
		return new WishListPage(driver);
	}

	public ShopPage clickOnShopMenu() {
		waitAndClick(By.xpath("shopMenu"));
		return new ShopPage(driver);
	}



}
