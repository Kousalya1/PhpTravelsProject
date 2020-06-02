package pageObjects;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import managers.PageObjectManager;
import utilities.ElementFactory;

public class RegistrationPage {

	WebDriver driver;

	@FindBy(how = How.ID, using = "inputFirstName")
	private WebElement firstName;

	@FindBy(how = How.ID, using = "inputLastName")
	private WebElement lastName;

	@FindBy(how = How.ID, using = "inputEmail")
	private WebElement emailAddress;

	@FindBy(how = How.ID, using = "inputPhone")
	private WebElement phoneNumber;

	@FindBy(how = How.ID, using = "inputCompanyName")
	private WebElement companyName;

	@FindBy(how = How.ID, using = "inputAddress1")
	private WebElement streetAddress;

	@FindBy(how = How.ID, using = "inputAddress2")
	private WebElement streetAddress2;

	@FindBy(how = How.ID, using = "inputCity")
	private WebElement city;

	@FindBy(how = How.ID, using = "stateinput")
	private WebElement state;

	@FindBy(how = How.ID, using = "inputPostcode")
	private WebElement postCode;

	@FindBy(how = How.ID, using = "inputCountry")
	private WebElement country;

	@FindBy(how = How.ID, using = "customfield1")
	private WebElement howFindUsDropdown;

	@FindBy(how = How.ID, using = "customfield2")
	private WebElement mobNumber;

	@FindBy(how = How.ID, using = "inputNewPassword1")
	private WebElement password;

	@FindBy(how = How.ID, using = "inputNewPassword2")
	private WebElement confirmPassword;

	@FindBy(how = How.ID, using = "passwordStrengthTextLabel")
	private WebElement passwordStrength;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Generate Password')]")
	private WebElement generatePassword;

	@FindBy(how = How.XPATH, using = "//span[text()='No']")
	private WebElement noButtonJobMailingList;

	@FindBy(how = How.CSS, using = "div[class='recaptcha-checkbox-border']")
	private WebElement captchaCheckbox;

	@FindBy(how = How.XPATH, using = "//input[@value='Register']")
	private WebElement registerButton;

	@FindBy(how = How.XPATH, using = "//a[text()='Register']")
	private WebElement registerButtonMenu;

	@FindBy(how = How.XPATH, using = "//div[@class='alert alert-danger']//following::ul")
	private WebElement errors;

	ElementFactory elementFactory;
	PageObjectManager pageObjectManager;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		pageObjectManager = new PageObjectManager(driver);
		elementFactory = pageObjectManager.getElementFactory();
	}

	public void enterPersonalInfo(String firstNameValue, String lastNameValue, String emailAddressValue,
			String phoneNum) {
		elementFactory.enterTextBox(firstName, firstNameValue);
		elementFactory.enterTextBox(lastName, lastNameValue);
		elementFactory.enterTextBox(emailAddress, emailAddressValue);
		elementFactory.enterTextBox(phoneNumber, phoneNum);
	}

	public void enterBillingAddress(String compName, String address1, String address2, String cityValue,
			String stateValue, String postCodeValue, String countryValue) {
		elementFactory.enterTextBox(companyName, compName);
		elementFactory.enterTextBox(streetAddress, address1);
		elementFactory.enterTextBox(streetAddress2, address2);
		elementFactory.enterTextBox(city, cityValue);
		elementFactory.enterTextBox(postCode, postCodeValue);
		elementFactory.enterTextBox(country, countryValue);
	}

	public void enterAddReqInfo(String howFindUs, String mobNum) {
		elementFactory.enterTextBox(howFindUsDropdown, howFindUs);
		elementFactory.enterTextBox(mobNumber, mobNum);
	}

	public void enterAccountSecurity(String pass, String confirmPass) {
		elementFactory.enterTextBox(password, pass);
		elementFactory.enterTextBox(confirmPassword, confirmPass);
	}

	public void disableJoinOurMailingList() {
		elementFactory.elementClick(noButtonJobMailingList);
	}
	
	public void selectCaptchaCheckbox() {
		elementFactory.elementClick(captchaCheckbox);
	}
	
	public void clickRegisterButton() {
		elementFactory.elementClick(registerButton);
	}

	public void clickRegisterMenu() {
		elementFactory.elementClick(registerButtonMenu);
	}
	
	
	public void validatePassWeakModerateStrong() {
		elementFactory.enterTextBox(password, "jjgrh");
		assertTrue("Password strength is Weak.",
				elementFactory.elementGetText(passwordStrength).trim().equals("Password Strength: 40% Weak"));
		elementFactory.enterTextBox(password, "jjgrh8789");
		assertTrue("Password strength is Moderate.",
				elementFactory.elementGetText(passwordStrength).trim().equals("Password Strength: 60% Moderate"));
		elementFactory.enterTextBox(password, "jjgrh8789@&*");
		assertTrue("Password strength is Strong.",
				elementFactory.elementGetText(passwordStrength).trim().equals("Password Strength: 75% Strong"));
	}

	public void validateEmailInvalidField() {
		assertTrue("Error found:" + " You did not enter your phone number.", elementFactory
				.elementGetText(passwordStrength).trim().equals("The email address you entered was not valid"));
	}
	
	public void verifyMobNumMissingError() {
		assertTrue("Error found:" + " You did not enter your phone number.", elementFactory
				.elementGetText(passwordStrength).trim().equals("You did not enter your phone number"));
	}


	
}
