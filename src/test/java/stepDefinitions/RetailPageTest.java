package stepDefinitions;

import java.io.IOException;
import java.util.Date;

import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.Status;

import core.Base;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.RetailPageObjects;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class RetailPageTest extends Base {

	RetailPageObjects retailPageObjects;

	// take screenshot:

//	@After
//	public void tearDown(Scenario scenario) {
//		if (scenario.isFailed()) {
//			String screenshotName = scenario.getName().replaceAll(" ", "_");
//			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//			scenario.attach(sourcePath, "image/png", screenshotName);
//		} 
//	}

	// step definitions

	@When("^User click on Login$")
	public void user_click_on_login() throws Throwable {
		retailPageObjects = new RetailPageObjects();
		retailPageObjects.clickOnLogin();
	}

	@When("^User click on ‘Register for an Affiliate Account’ link$")
	public void user_click_on_register_for_an_affiliate_account_link() throws Throwable {
		retailPageObjects = new RetailPageObjects();
		retailPageObjects.clickOnRegisterForAffiliateAccount();
	}

	@When("^User click on ‘Edit your affiliate information' link$")
	public void user_click_on_edit_your_affiliate_information_link() throws Throwable {
		retailPageObjects = new RetailPageObjects();
		retailPageObjects.clickOnEditYourAffiliateInfo();
	}

	@When("^User click on ‘Edit your account information’ link$")
	public void user_click_on_edit_your_account_information_link() throws Throwable {
		retailPageObjects = new RetailPageObjects();
		retailPageObjects.clickOnEditYourAccountInfo();
	}

	@Then("^User should be logged in to My Account dashboard$")
	public void user_should_be_logged_in_to_my_account_dashboard() throws Throwable {
		retailPageObjects = new RetailPageObjects();
		retailPageObjects.loggedInToDashboard();
	}

	@Then("^User should see a success message$")
	public void user_should_see_a_success_message() throws Throwable {
		retailPageObjects = new RetailPageObjects();
		retailPageObjects.seeSuccessMessage();
		//tearDown();
	}

	@Then("^User should see a message ‘Success: Your account has been successfully updated.’$")
	public void user_should_see_a_message_success_your_account_has_been_successfully_updated() throws Throwable {
		retailPageObjects = new RetailPageObjects();
		retailPageObjects.successMessageMatches();
	}

	@And("^User click on My Account$")
	public void user_click_on_my_account() throws Throwable {
		retailPageObjects = new RetailPageObjects();
		retailPageObjects.clickOnMyAccount();
	}

	@And("^User enter username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_enter_username_something_and_password_something(String strArg1, String strArg2) throws Throwable {
		retailPageObjects = new RetailPageObjects();
		retailPageObjects.enterEmail(strArg1);
		retailPageObjects.enterPassword(strArg2);
	}

	@And("^User clicks on Login button$")
	public void user_clicks_on_login_button() throws Throwable {
		retailPageObjects = new RetailPageObjects();
		retailPageObjects.clickOnLoginButton();
	}

	@And("^User fill affiliate form with below information (.+), (.+), (.+), (.+) and (.+)$")
	public void user_fill_affiliate_form_with_below_information_and(String company, String website, String taxid,
			String paymentmethod, String chequepayeename) throws Throwable {
		// And User fill affiliate form with below information <company>, <website>,
		// <taxID>, <paymentMethod> and <Cheque Payee Name>
		retailPageObjects = new RetailPageObjects();
		retailPageObjects.enterCompanyName(company);
		retailPageObjects.enterWebsite(website);
		retailPageObjects.enterTaxID(taxid);
		retailPageObjects.enterPaymentMethod(paymentmethod);
		retailPageObjects.enterChequePayeeName(chequepayeename);
	}

	@And("^User check on About us check box$")
	public void user_check_on_about_us_check_box() throws Throwable {
		retailPageObjects = new RetailPageObjects();
		retailPageObjects.checkAboutUsCheckbox();
	}

	@And("^User click on Continue button$")
	public void user_click_on_continue_button() throws Throwable {
		retailPageObjects = new RetailPageObjects();
		retailPageObjects.clickOnContinueButton();
	}

	@And("^user click on Bank Transfer radio button$")
	public void user_click_on_bank_transfer_radio_button() throws Throwable {
		retailPageObjects = new RetailPageObjects();
		retailPageObjects.clickOnBankTransferRadioButton();
	}

	@And("^User fill Bank information with below information (.+), (.+), (.+), (.+) and (.+)$")
	public void user_fill_bank_information_with_below_information_and(String bankname, String abanumber,
			String swiftcode, String accountname, String accountnumber) throws Throwable {
		// And User fill Bank information with below information <bankName>,
		// <abaNumber>, <swiftCode>, <accountName> and <accountNumber>
		retailPageObjects = new RetailPageObjects();
		retailPageObjects.enterBankName(bankname);
		retailPageObjects.enterABANumber(abanumber);
		retailPageObjects.enterSwiftCode(swiftcode);
		retailPageObjects.enterAccountName(accountname);
		retailPageObjects.enterAccountNumber(accountnumber);
	}

	@And("^User modify below information (.+), (.+), (.+) and (.+)$")
	public void user_modify_below_information_and(String firstname, String lastname, String email, String telephone)
			throws Throwable {
		// And User modify below information <firstname>, <lastName>, <email> and
		// <telephone>
		retailPageObjects = new RetailPageObjects();
		retailPageObjects.enterFirstName(firstname);
		retailPageObjects.enterLastName(lastname);
		retailPageObjects.enterEmail(email);
		retailPageObjects.enterTelephone(telephone);
	}
}
