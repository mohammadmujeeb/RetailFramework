package stepDefinitions;

import core.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DesktopsPageObjects;

public class DesktopsTest extends Base{
	
	DesktopsPageObjects desktopPageObjects;
	
	@Given("^User is on Retail website$")
    public void user_is_on_retail_website() throws Throwable {
		initializeDriver();
		logger.info("Initialized the driver.");
    }


	@When("^User click on Desktops tab$")
    public void user_click_on_desktops_tab() throws Throwable {
    	desktopPageObjects = new DesktopsPageObjects();
		desktopPageObjects.clickOnDesktopsTab();
		logger.info("Clicked on the desk.");
    }

    @And("^User click on Show all desktops$")
    public void user_click_on_show_all_desktops() throws Throwable {
    	desktopPageObjects = new DesktopsPageObjects();
    	desktopPageObjects.clickOnShowAllDesktopsMenu();
    }

    @And("^User click ADD TO CART option on \"([^\"]*)\" item$")
    public void user_click_add_to_cart_option_on_something_item(String strArg1) throws Throwable {
    	desktopPageObjects = new DesktopsPageObjects();
    	desktopPageObjects.clickOnAddToCartLink(strArg1);
    }

    @And("^User select quantity \"([^\"]*)\"$")
    public void user_select_quantity_something(String strArg1) throws Throwable {
    	desktopPageObjects = new DesktopsPageObjects();
    	desktopPageObjects.enterProductQuantity(strArg1);
    }

    @And("^User click add to Cart button$")
    public void user_click_add_to_cart_button() throws Throwable {
    	desktopPageObjects = new DesktopsPageObjects();
    	desktopPageObjects.clickOnAddToCartButton();
    }

    @And("^User select color from dropdown \"([^\"]*)\"$")
    public void user_select_color_from_dropdown_something(String strArg1) throws Throwable {
    	desktopPageObjects = new DesktopsPageObjects();
    	desktopPageObjects.selectProductColor(strArg1);
    }

    @And("^User click on \"([^\"]*)\" item$")
    public void user_click_on_something_item(String strArg1) throws Throwable {
    	desktopPageObjects = new DesktopsPageObjects();
    	desktopPageObjects.selectAProduct(strArg1);
    }

    @And("^User click on write a review link$")
    public void user_click_on_write_a_review_link() throws Throwable {
    	desktopPageObjects = new DesktopsPageObjects();
    	desktopPageObjects.clickOnWriteAReviewLink();
    }

    @And("^user fill the review information with (.+), (.+) and (.+)$")
    public void user_fill_the_review_information_with_and(String name, String review, String rating) throws Throwable {
    	desktopPageObjects = new DesktopsPageObjects();
    	desktopPageObjects.writeAReview(name, review, rating);
    }

    @And("^User click on Continue Button$")
    public void user_click_on_continue_button() throws Throwable {
    	desktopPageObjects = new DesktopsPageObjects();
    	desktopPageObjects.clickOnContinueButton();
    }
    
    @Then("^User should see all items are present in Desktop page$")
    public void user_should_see_all_items_are_present_in_desktop_page() throws Throwable {
    	desktopPageObjects = new DesktopsPageObjects();
    	desktopPageObjects.allItemsDisplayed();
        tearDown();
    }

    @Then("^User should see a message ‘Success: you have added \"([^\"]*)\" to your shopping cart!’$")
    public void user_should_see_a_message_success_you_have_added_something_to_your_shopping_cart(String strArg1) throws Throwable {
    	String successMessage = "Success: You have added " + strArg1 + " to your shopping cart!";
    	desktopPageObjects = new DesktopsPageObjects();
    	desktopPageObjects.successAlertIsDisplayed(successMessage);
        tearDown();
    }
    
    
    @Then("^User should see a message with ‘Thank you for your review. It has been submitted to the webmaster for approval.'$")
    public void user_should_see_a_message_with_thank_you_for_your_review_it_has_been_submitted_to_the_webmaster_for_approval() throws Throwable {
    	desktopPageObjects = new DesktopsPageObjects();
    	desktopPageObjects.thankYouMessageIsDisplayed();
        tearDown();
    }

}
