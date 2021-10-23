package stepDefinations;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.SelfInjection.Split;
import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.ShopPage;
import pageObjects.WishListPage;
import utilities.DriverFactory;

public class TestScenarioSteps extends DriverFactory {

	public HomePage homepage;
	public ShopPage shoppage;
	public WishListPage wishlistpage;
	public CartPage cartpage;
	private String ProductOfMinUnitPrice;
	List<String> wishlistProduct;

	// Product list
	public static final List<String> products = Arrays.asList("Black trousers", "Evening trousers", "Modern",
			"Single Shirt");

	@Given("^I add four different products to my wish list$")
	public void i_add_four_different_products_to_my_wish_list() throws Throwable {
		driver.get("https://testscriptdemo.com/");
		HomePage hs = new HomePage(driver);
		shoppage = hs.clickOnShopMenu();
		for (String string : products) {
			shoppage.addToWishList(string);
		}

		wishlistpage = shoppage.clickOnWishListHeader();
	}

	@When("^I view my wishlist table$")
	public void i_view_my_wishlist_table() throws Throwable {

		wishlistProduct = wishlistpage.getProducts();
		Assert.assertEquals(products.size(), wishlistProduct.size());
		for (String string : products) {
			boolean contains = wishlistProduct.contains(string);
			Assert.assertTrue(string + " is not added to wishlist", contains);
		}

	}

	@When("^I search for lowest price product$")
	public void i_search_for_lowest_price_product() throws Throwable {
		List<Double> unitPriceDoubleType = new ArrayList<Double>();
		List<String> unitPrice = wishlistpage.getUnitPrice();
		for (int i = 0; i < unitPrice.size(); i++) {
			String string = unitPrice.get(i);
			String[] split = string.split("£");
			String unitPriceNew = split[split.length - 1];
			Double valueOf = Double.valueOf(unitPriceNew);
			unitPriceDoubleType.add(valueOf);
		}

		Double minDoubleNumber = unitPriceDoubleType.stream().min(Comparator.naturalOrder()).get();
		int indexOfMinProduct = unitPriceDoubleType.indexOf(minDoubleNumber);
		ProductOfMinUnitPrice = wishlistProduct.get(indexOfMinProduct);
	}

	@And("^I am able to add lowest price item to my cart$")
	public void i_am_able_to_add_lowest_price_item_to_my_cart() throws Throwable {
		wishlistpage.clickOnAddCart(ProductOfMinUnitPrice);
		cartpage = wishlistpage.clickOnCartHeader();
	}

	@Then("^I am able to verify the item in my cart$")
	public void i_am_able_to_verify_the_item_in_my_cart() throws Throwable {
		List<String> cartproducts = cartpage.getProducts();
		boolean contains = cartproducts.contains(ProductOfMinUnitPrice);
		Assert.assertTrue(contains);

	}

}