package stepDefinitions;

import core.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LaptopsAndNotebooksPageObjects;

public class LaptopsAndNotebooksTest extends Base {

	LaptopsAndNotebooksPageObjects laptopsAndNotebooksPageObjects;

    @When("^User click on Laptops & NoteBooks tab$")
    public void user_click_on_laptop_notebooks_tab() throws Throwable {
    	laptopsAndNotebooksPageObjects = new LaptopsAndNotebooksPageObjects();
    	laptopsAndNotebooksPageObjects.clickOnLaptopAndNotebooksTab();
    }

    @When("User click on Show all Laptops & NoteBooks option")
    public void user_click_on_show_all_laptops_note_books_option() {
    	laptopsAndNotebooksPageObjects = new LaptopsAndNotebooksPageObjects();
    	laptopsAndNotebooksPageObjects.clickOnShowAllLaptopAndNotebooksOption();

    }
    
    @Then("^User should see a message ‘Success: You have added \"([^\"]*)\" to your shopping cart!’$")
    public void user_should_see_a_message_success_you_have_added_something_to_your_shopping_cart(String strArg1) throws Throwable {
    	String successMessage = "Success: You have added " + strArg1 + " to your shopping cart!";
    	laptopsAndNotebooksPageObjects = new LaptopsAndNotebooksPageObjects();
    	laptopsAndNotebooksPageObjects.alertMessageIsDisplayed(successMessage);
    }

    @Then("^item should be removed and cart should show \"([^\"]*)\"$")
    public void item_should_be_removed_and_cart_should_show_something(String strArg1) throws Throwable {
    	laptopsAndNotebooksPageObjects = new LaptopsAndNotebooksPageObjects();
    	laptopsAndNotebooksPageObjects.cartTotalIsDisplayed(strArg1);
    	tearDown();
    }

    @Then("^User should see a message ‘Success: You have added \"([^\"]*)\" to your product comparison!’$")
    public void user_should_see_a_message_success_you_have_added_something_to_your_product_comparison(String strArg1) throws Throwable {
    	String successMessage = "Success: You have added " + strArg1 + "to your product comparison!";
    	laptopsAndNotebooksPageObjects = new LaptopsAndNotebooksPageObjects();
    	laptopsAndNotebooksPageObjects.alertMessageIsDisplayed(successMessage);
    }

    @Then("^User should see Product Comparison chart$")
    public void user_should_see_product_comparison_chart() throws Throwable {
    	laptopsAndNotebooksPageObjects = new LaptopsAndNotebooksPageObjects();
    	laptopsAndNotebooksPageObjects.productComparisonChartIsDisplayed();
    	tearDown();
    }

    @Then("^User should get a message ‘You must login or create an account to save \"([^\"]*)\" to your wish list!’$")
    public void user_should_get_a_message_you_must_login_or_create_an_account_to_save_something_to_your_wish_list(String strArg1) throws Throwable {
    	String message = "You must login or create an account to save " + strArg1 + "to your wish list!";
    	laptopsAndNotebooksPageObjects = new LaptopsAndNotebooksPageObjects();
    	laptopsAndNotebooksPageObjects.alertMessageIsDisplayed(message);
    	tearDown();
    }

    @Then("^User should see \"([^\"]*)\" price tag is present on UI.$")
    public void user_should_see_something_price_tag_is_present_on_ui(String strArg1) throws Throwable {
    	laptopsAndNotebooksPageObjects = new LaptopsAndNotebooksPageObjects();
    	laptopsAndNotebooksPageObjects.priceTagIsDisplayed(strArg1);    
    	tearDown();
    }

    @And("^User clicks on \"([^\"]*)\" item$")
    public void user_clicks_on_something_item(String strArg1) throws Throwable {
    	laptopsAndNotebooksPageObjects = new LaptopsAndNotebooksPageObjects();
    	laptopsAndNotebooksPageObjects.clickOnProduct(strArg1);

    }

    @And("^User click Add to Cart button$")
    public void user_click_add_to_cart_button() throws Throwable {
    	laptopsAndNotebooksPageObjects = new LaptopsAndNotebooksPageObjects();
    	laptopsAndNotebooksPageObjects.clickOnAddToCartButton();

    }

    @And("^User should see \"([^\"]*)\" showed to the cart$")
    public void user_should_see_something_showed_to_the_cart(String strArg1) throws Throwable {
    	laptopsAndNotebooksPageObjects = new LaptopsAndNotebooksPageObjects();
    	laptopsAndNotebooksPageObjects.cartTotalIsDisplayed(strArg1);
    }

    @And("^User click on cart option$")
    public void user_click_on_cart_option() throws Throwable {
    	laptopsAndNotebooksPageObjects = new LaptopsAndNotebooksPageObjects();
    	laptopsAndNotebooksPageObjects.clickOnCartOption();
    }

    @And("^user click on red X button to remove the item from cart$")
    public void user_click_on_red_x_button_to_remove_the_item_from_cart() throws Throwable {
    	laptopsAndNotebooksPageObjects = new LaptopsAndNotebooksPageObjects();
    	laptopsAndNotebooksPageObjects.clickOnRedXButton();
    }

    @And("^User click on product comparison icon on \"([^\"]*)\"$")
    public void user_click_on_product_comparison_icon_on_something(String strArg1) throws Throwable {
    	laptopsAndNotebooksPageObjects = new LaptopsAndNotebooksPageObjects();
    	laptopsAndNotebooksPageObjects.clickOnProductComparisonIcon(strArg1);
    }

    @And("^User click on Product Comparison link$")
    public void user_click_on_product_comparison_link() throws Throwable {
    	laptopsAndNotebooksPageObjects = new LaptopsAndNotebooksPageObjects();
    	laptopsAndNotebooksPageObjects.clickOnProductComparisonLink();
    }

    @And("^User click on heart icon to add \"([^\"]*)\" laptop to wish list$")
    public void user_click_on_heart_icon_to_add_something_laptop_to_wish_list(String strArg1) throws Throwable {
    	laptopsAndNotebooksPageObjects = new LaptopsAndNotebooksPageObjects();
    	laptopsAndNotebooksPageObjects.addProductToWishList(strArg1);    	
    }
}
