package pageObjects;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import managers.PageObjectManager;
import utilities.ElementFactory;

public class MyDetailsPage {

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

	@FindBy(how = How.ID, using = "country")
	private WebElement country;

	@FindBy(how = How.ID, using = "customfield1")
	private WebElement howFindUsDropdown;

	@FindBy(how = How.ID, using = "customfield2")
	private WebElement mobNumber;
	
	@FindBy(how = How.XPATH, using = "//span[text()='No']")
	private WebElement noButtonJobMailingList;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'My Details')]")
	private WebElement myDetailsButton;
	
	@FindBy(how = How.XPATH, using = "//i[@class='fas fa-pencil-alt']")
	private WebElement updateButton;
	
	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'My Details')]")
	private WebElement myDetailsText;
	
	WebDriver driver;
	ElementFactory elementFactory;
	PageObjectManager pageObjectManager;

	public MyDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		pageObjectManager = new PageObjectManager(driver);
		elementFactory = pageObjectManager.getElementFactory();
	}

	public void navigateToMydetailsPage() {
		elementFactory.elementClick(updateButton);
		assertTrue(myDetailsButton.isDisplayed());
	}
	
	public void verifyPersonalInfo(String firstNameValue, String lastNameValue, String emailAddressValue,
			String phoneNum) {
		assertTrue(elementFactory.elementGetText(firstName).equals(firstNameValue));
		assertTrue(elementFactory.elementGetText(lastName).equals(lastNameValue));		
		assertTrue(elementFactory.elementGetText(emailAddress).equals(emailAddressValue));		
		assertTrue(elementFactory.elementGetText(phoneNumber).equals(phoneNum));		
	}
	
	public void verifyBillingAddress(String compName, String address1, String address2, String cityValue,
			String stateValue, String postCodeValue, String countryValue) {
		assertTrue(elementFactory.elementGetText(companyName).equals(compName));
		assertTrue(elementFactory.elementGetText(streetAddress).equals(address1));	
		assertTrue(elementFactory.elementGetText(streetAddress2).equals(address2));
		assertTrue(elementFactory.elementGetText(city).equals(cityValue));	
		assertTrue(elementFactory.elementGetText(state).equals(stateValue));
		assertTrue(elementFactory.elementGetText(postCode).equals(postCodeValue));	
		assertTrue(elementFactory.elementGetText(country).equals(countryValue));
	}
	
	public void verifyAddReqInfo(String howFindUs, String mobNum) {
		assertTrue(elementFactory.elementGetText(howFindUsDropdown).equals(howFindUs));
		assertTrue(elementFactory.elementGetText(mobNumber).equals(mobNum));
	}
	
	public void verifyJoinOurMailingListIsDisabled() {
		assertTrue("", noButtonJobMailingList.isDisplayed());
	}
	
	
	
}