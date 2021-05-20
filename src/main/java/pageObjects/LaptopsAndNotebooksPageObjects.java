package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;

public class LaptopsAndNotebooksPageObjects extends Base {
	
	WebDriver driver = super.driver;

	public LaptopsAndNotebooksPageObjects() {
		PageFactory.initElements(driver, this);
	}

	// locators

	@FindBy(xpath = "//a[text()='Laptops & Notebooks']")
	private WebElement laptopsAndNotebooksTab;

	@FindBy(xpath = "//a[text()='Show All Laptops & Notebooks']")
	private WebElement showAllLaptopsAndNotebooks;

	@FindAll({ @FindBy(xpath = "//div[@class='product-thumb']//h4/a") })
	private List<WebElement> productsOnLaptopsAndNotebooksPage;

	@FindBy(xpath = "//input[@name='quantity']")
	private WebElement productQuantity;

	@FindBy(xpath = "//button[@id='button-cart']")
	private WebElement addToCartButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;

	@FindBy(xpath = "//span[@id='cart-total']")
	private WebElement cartTotal;

	@FindBy(xpath = "//button[contains(@onclick, 'cart.remove')]")
	private WebElement redXButton;

	@FindAll({ @FindBy(css = "button[data-original-title='Compare this Product']") })
	private List<WebElement> compareProductsButtons;

	@FindBy(xpath = "//a[text()='product comparison']")
	private WebElement productComparisonLink;

	@FindBy(css = "table[class='table table-bordered']")
	private WebElement productComparisonChart;

	@FindAll({ @FindBy(css = "button[data-original-title='Add to Wish List']") })
	private List<WebElement> addToWishListButtons;

	@FindBy(xpath = "//h2[text()='$2,000.00']")
	private WebElement priceTag;

	// methods

	public void clickOnLaptopAndNotebooksTab() {
		if (laptopsAndNotebooksTab.isDisplayed()) {
			laptopsAndNotebooksTab.click();
			logger.info("Clicked on 'Laptops & Notebooks' tab.");
		} else {
			logger.error("'Laptops & Notebooks' tab was not dispayed.");
		}
	}

	public void clickOnShowAllLaptopAndNotebooksOption() {
		if (showAllLaptopsAndNotebooks.isDisplayed()) {
			showAllLaptopsAndNotebooks.click();
			logger.info("Clicked on 'Show All Laptops & Notebooks' menu.");
		} else {
			logger.error("'Show All Laptops & Notebooks' was not displayed.");
		}
	}

	public void clickOnProduct(String product) {

		for (int i = 0; i < productsOnLaptopsAndNotebooksPage.size(); i++) {
			if (productsOnLaptopsAndNotebooksPage.get(i).getText().equalsIgnoreCase(product)) {
				if (productsOnLaptopsAndNotebooksPage.get(i).isDisplayed()) {
					productsOnLaptopsAndNotebooksPage.get(i).click();
					logger.info(product + " was selected.");
				} else {
					logger.error(product + " was not displayed.");
				}
			}
		}
	}

	public void clickOnAddToCartButton() {
		if (addToCartButton.isDisplayed()) {
			addToCartButton.click();
			logger.info("Clicked on 'Add to Cart' button.");
		} else {
			logger.error("'Add to Cart' button was not displayed.");
		}
	}

	public boolean alertMessageIsDisplayed(String successMessage) {
		String message = alert.getText();
		if (message.equals(successMessage)) {
			logger.info("Success message was displayed.");
			return true;
		}
		logger.error("Success message was not displayed or is incorrect.");
		return false;
	}

	public boolean cartTotalIsDisplayed(String cartTotal) {
		String total = this.cartTotal.getText();
		if (cartTotal.equalsIgnoreCase(total)) {
			logger.info("Cart total was displayed.");
			return true;
		}
		logger.error("Cart total was not displayed or is incorrect.");
		return false;
	}

	public void clickOnCartOption() {
		if (cartTotal.isDisplayed()) {
			cartTotal.click();
			logger.info("Clicked on cart option.");
		} else {
			logger.error("Cart option was not displayed.");
		}
	}

	public void clickOnRedXButton() {
		if (redXButton.isDisplayed()) {
			redXButton.click();
			logger.info("Clicked on red X button.");
		} else {
			logger.error("Red X button was not displayed.");
		}
	}

	public void clickOnProductComparisonIcon(String product) {
		for (int i = 0; i < this.productsOnLaptopsAndNotebooksPage.size(); i++) {
			if (productsOnLaptopsAndNotebooksPage.get(i).getText().equalsIgnoreCase(product)) {
				if (compareProductsButtons.get(i).isDisplayed()) {
					compareProductsButtons.get(i).click();
					logger.info("Clicked on 'Compare this Product' icon.");
				} else {
					logger.error("'Clicked on 'Compare' icon was not dispayed.");
				}
			}
		}
	}

	public void clickOnProductComparisonLink() {
		if (productComparisonLink.isDisplayed()) {
			productComparisonLink.click();
			logger.info("Clicked on 'product comparison' link.");
		} else {
			logger.error("'product comparison' link was not dispayed.");
		}
	}

	public boolean productComparisonChartIsDisplayed() {
		if (productComparisonChart.isDisplayed()) {
			logger.info("'Product Comparison' chart was displayed.");
			return true;
		}
		logger.error("'Product Comparison' chart was not displayed.");
		return false;
	}

	public void addProductToWishList(String product) {
		for (int i = 0; i < this.productsOnLaptopsAndNotebooksPage.size(); i++) {
			if (this.productsOnLaptopsAndNotebooksPage.get(i).getText().equalsIgnoreCase(product)) {
				if (productsOnLaptopsAndNotebooksPage.get(i).isDisplayed()) {
					this.addToWishListButtons.get(i).click();
					logger.info("Clicked on 'Add to Wish List' icon.");
				} else {
					logger.error("'Add to Wish List' icon was not displayed.");
				}
			}
		}
	}

	public boolean priceTagIsDisplayed(String price) {
		if (this.priceTag.getText().equalsIgnoreCase(price)) {
			logger.info("Price tag was dispayed.");
			return true;
		}
		logger.error("Price tag was not dispayed or was incorrect.");
		return false;
	}
}
