package pageObjects;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;

public class RetailPageObjects extends Base {

	boolean affiliateAccountExists;

	WebDriver driver = super.driver;

	public RetailPageObjects() {
		PageFactory.initElements(driver, this);
	}

	// locators

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccount;

	@FindBy(xpath = "//a[text()='Login']")
	private WebElement login;

	@FindBy(id = "input-email")
	private WebElement email;

	@FindBy(id = "input-password")
	private WebElement password;

	@FindBy(css = "input[type='submit']")
	private WebElement loginButton;

	@FindBy(xpath = "//div/a[text()='Logout']")
	private WebElement confirmDashboard;

	@FindBy(xpath = "//a[text()='Register for an affiliate account']")
	private WebElement registerForAffiliateAccountLink;

	@FindBy(name = "company")
	private WebElement companyName;

	@FindBy(id = "input-website")
	private WebElement companyWebsite;

	@FindBy(id = "input-tax")
	private WebElement companyTaxID;

	@FindAll({ @FindBy(xpath = "//input[@name='payment']") })
	private List<WebElement> paymentMethods;

	@FindBy(id = "input-cheque")
	private WebElement chequePayeeName;

	@FindBy(name = "agree")
	private WebElement agreeCheckbox;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;

	@FindBy(xpath = "//a[text()='Edit your affiliate information']")
	private WebElement editYourAffiliateInfoLink;

	@FindBy(id = "input-bank-name")
	private WebElement bankName;

	@FindBy(id = "input-bank-branch-number")
	private WebElement branchNumber;

	@FindBy(id = "input-bank-swift-code")
	private WebElement swiftCode;

	@FindBy(name = "bank_account_name")
	private WebElement accountName;

	@FindBy(name = "bank_account_number")
	private WebElement accountNumber;

	@FindBy(xpath = "//a[text()='Edit your account information']")
	private WebElement editYourAccountInfoLink;

	@FindBy(name = "firstname")
	private WebElement firstName;

	@FindBy(name = "lastname")
	private WebElement lastName;

	@FindBy(id = "input-telephone")
	private WebElement telephone;

	// methods

	public void clickOnMyAccount() {
		if (myAccount.isDisplayed()) {
			myAccount.click();
			logger.info("Clicked on 'My Account' tab.");
		} else {
			logger.error("'My Account' tab was not displayed.");
		}
	}

	public void clickOnLogin() {
		if (login.isDisplayed()) {
			login.click();
			logger.info("Clicked on 'Login' menu.");
		} else {
			logger.error("'Login' menu was not displayed.");
		}
	}

	public void enterEmail(String emailAddress) {
		if (email.isDisplayed()) {
			email.clear();
			email.sendKeys(emailAddress);
			logger.info("Entered email address.");
		} else {
			logger.error("Email address text box was not displayed.");
		}
	}

	public void enterPassword(String pass) {
		if (password.isDisplayed()) {
			password.clear();
			password.sendKeys(pass);
			logger.info("Password was entered.");
		} else {
			logger.error("Password text box was not displayed.");
		}
	}

	public void clickOnLoginButton() {
		if (loginButton.isDisplayed()) {
			loginButton.click();
			logger.info("Clicked on 'Login' button.");
		} else {
			logger.error("'Login' button was not displayed.");
		}
	}

	public boolean loggedInToDashboard() {
		if (confirmDashboard.isDisplayed()) {
			logger.info("Dashboard was displayed.");
			return true;
		}
		logger.error("Dashboard was not displayed.");
		return false;
	}

	public void clickOnRegisterForAffiliateAccount() {

		try {
			registerForAffiliateAccountLink.click();
			logger.info("Clicked on 'Register for Affiliate Account Link'.");
			affiliateAccountExists = true;
		} catch (NoSuchElementException e) {
			logger.error("Registration link does not exist: Affliate account already exists.");
			affiliateAccountExists = false;
		}
	}

	public void enterCompanyName(String name) {
		if (affiliateAccountExists == true) {
			try {
				companyName.sendKeys(name);
				logger.info("Entered company name.");
			} catch (NoSuchElementException e) {
				logger.error(" -> Company Name skipped: Affliate account already exists.");
			}
		} else {
			logger.error(" -> Company Name skipped: Affliate account already exists.");
		}
	}

	public void enterWebsite(String website) {
		if (affiliateAccountExists == true) {
			try {
				companyWebsite.sendKeys(website);
				logger.info("Website entered.");
			} catch (NoSuchElementException e) {
				logger.error(" -> Website skipped: Affliate account already exists.");
			}
		} else {
			logger.error(" -> Website skipped: Affliate account already exists.");
		}
	}

	public void enterTaxID(String taxID) {
		if (affiliateAccountExists == true) {
			try {
				companyTaxID.sendKeys(taxID);
				logger.info("Company ID entered.");
			} catch (NoSuchElementException e) {
				logger.error(" -> Tax ID skipped: Affliate account already exists.");
			}
		} else {
			logger.error(" -> Tax ID skipped: Affliate account already exists.");
		}
	}

	public void enterPaymentMethod(String paymentMethod) {
		if (affiliateAccountExists == true) {
			try {
				for (int i = 0; i < paymentMethods.size(); i++) {
					if (paymentMethods.get(i).getText().contains(paymentMethod)) {
						this.paymentMethods.get(i).click();
						logger.info("Payment method was selected.");
					}
				}
			} catch (NoSuchElementException e) {
				logger.error(" -> Payment Method skipped: Affliate account already exists.");
			}
		} else {
			logger.error(" -> Payment Method skipped: Affliate account already exists.");
		}
	}

	public void enterChequePayeeName(String name) {
		if (affiliateAccountExists == true) {
			try {
				chequePayeeName.sendKeys(name);
				logger.info("Cheque payee name was entered.");
			} catch (NoSuchElementException e) {
				logger.error(" -> Cheque Payee Name skipped: Affliate account already exists.");
			}
		} else {
			logger.error(" -> Cheque Payee Name skipped: Affliate account already exists.");
		}
	}

	public void checkAboutUsCheckbox() {
		if (affiliateAccountExists == true) {
			try {
				agreeCheckbox.click();
				logger.info("Agree checkbox selected.");
			} catch (NoSuchElementException e) {
				logger.error(" -> Checkbox selection skipped: Affliate account already exists.");
			}
		} else {
			logger.error(" -> Checkbox selection skipped: Affliate account already exists.");
		}
	}

	public void clickOnContinueButton() {
		try {
			continueButton.click();
			logger.info("Clicked on 'Continue' button.");
		} catch (NoSuchElementException e) {
			logger.error(" -> 'Continue' button skipped: Affliate account already exists.");
		}
	}

	public boolean seeSuccessMessage() {
		try {
			if (alert.isDisplayed()) {
				logger.info("Success message is displayed.");
				return true;
			}
		} catch (NoSuchElementException e) {
			logger.error("Success message was not displayed.");
		}
		return false;
	}

	public void clickOnEditYourAffiliateInfo() {
		if (editYourAffiliateInfoLink.isDisplayed()) {
			editYourAffiliateInfoLink.click();
			logger.info("Clicked on 'Edit your Affliate Information' link.");
		} else {
			logger.error("'Edit your Affiliate Information' link was not displayed.");
		}
	}

	public void clickOnBankTransferRadioButton() {
		for (int i = 0; i < paymentMethods.size(); i++) {
			if (paymentMethods.get(i).getText().contains("Bank Transfer")) {
				if (paymentMethods.get(i).isDisplayed()) {
					paymentMethods.get(i).click();
					logger.info("Bank transfer radio button selected.");
				} else {
					logger.error("Bank transfer radio button was not displayed.");
				}
			}
		}
	}

	public void enterBankName(String name) {
		if (bankName.isDisplayed()) {
			bankName.clear();
			bankName.sendKeys(name);
			logger.info("Bank name entered.");
		} else {
			logger.error("Bank name text box was not displayed.");
		}
	}

	public void enterABANumber(String number) {
		if (branchNumber.isDisplayed()) {
			branchNumber.clear();
			branchNumber.sendKeys(number);
			logger.info("Branch number was entered.");
		} else {
			logger.error("Branch number text box was not displayed.");
		}
	}

	public void enterSwiftCode(String code) {
		if (swiftCode.isDisplayed()) {
			swiftCode.clear();
			swiftCode.sendKeys(code);
			logger.info("Swift code was entered.");
		} else {
			logger.error("Swift code text box was not displayed.");
		}
	}

	public void enterAccountName(String name) {
		if (accountName.isDisplayed()) {
			accountName.clear();
			accountName.sendKeys(name);
			logger.info("Account name was entered.");
		} else {
			logger.error("Account name text box was not displayed.");
		}
	}

	public void enterAccountNumber(String number) {
		if (accountNumber.isDisplayed()) {
			accountNumber.clear();
			accountNumber.sendKeys(number);
			logger.info("Account number was entered.");
		} else {
			logger.error("Account number text box was not displayed.");
		}
	}

	public void clickOnEditYourAccountInfo() {
		if (editYourAccountInfoLink.isDisplayed()) {
			editYourAccountInfoLink.click();
			logger.info("Clicked on 'Edit your Account Information' link.");
		} else {
			logger.error("'Edit your Account Information' link was not displayed.");
		}
	}

	public void enterFirstName(String name) {
		if (firstName.isDisplayed()) {
			firstName.clear();
			firstName.sendKeys(name);
			logger.info("Entered first name.");
		} else {
			logger.error("First name text box was not displayed.");
		}
	}

	public void enterLastName(String name) {
		if (lastName.isDisplayed()) {
			lastName.clear();
			lastName.sendKeys(name);
			logger.info("Entered last name.");
		} else {
			logger.error("Last name text box was not displayed.");
		}
	}

	public void enterTelephone(String phone) {
		if (lastName.isDisplayed()) {
			telephone.clear();
			telephone.sendKeys(phone);
			logger.info("Entered telephone number.");
		} else {
			logger.error("Telephone number text box was not displayed.");
		}
	}

	public boolean successMessageMatches() {
		if (alert.getText().contains("Success: Your account has been successfully updated.")) {
			tearDown();
			logger.info("Success message was displayed.");
			return true;
		} else {
			tearDown();
			logger.error("Success message was not displayed or was incorrect.");
			return false;
		}
	}
}
