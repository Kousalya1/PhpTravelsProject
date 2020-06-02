package pageObjects;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import managers.PageObjectManager;
import utilities.ElementFactory;

public class LoginPage {

	@FindBy(how = How.CSS, using = "img[alt='PHPTRAVELS']")
	private WebElement phpTravelsImage;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Logout')]")
	private WebElement logoutButton;
	
	@FindBy(how = How.CSS, using = "div[class='alert alert-success text-center']")
	private WebElement logoutSuccessMsg;
	
	@FindBy(how = How.XPATH, using = "//a[text()='Login']")
	private WebElement loginMenu;
	
	@FindBy(how = How.ID, using = "login")
	private WebElement loginButton;
	
	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Welcome Back')]")
	private WebElement welcomeMsg;
	
	@FindBy(how = How.CSS, using = "div[class='recaptcha-checkbox-border']")
	private WebElement recaptchaCheckbox;
	
	@FindBy(how = How.ID, using = "inputEmail")
	private WebElement emailAddress;
	
	@FindBy(how = How.ID, using = "inputPassword")
	private WebElement passwordTextBox;	
	
	
	WebDriver driver;
	ElementFactory elementFactory;
	PageObjectManager pageObjectManager;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		pageObjectManager = new PageObjectManager(driver);
		elementFactory = pageObjectManager.getElementFactory();
	}

	public void verifyHeader() {
		assertTrue("Image for 'PhpTravels' is not displayed.", phpTravelsImage.isDisplayed());
	}

	public void loginAndEnsure(String email, String password) {
		elementFactory.enterTextBox(emailAddress, email);
		elementFactory.enterTextBox(passwordTextBox, password);
		elementFactory.elementClick(recaptchaCheckbox);
		elementFactory.elementClick(loginButton);
		assertTrue("User is not logged in successfully.", welcomeMsg.isDisplayed());
	}
	
	public void logoutAndEnsure() {
		elementFactory.elementClick(logoutButton);
		assertTrue("User is not logged out successfully.", elementFactory.elementGetText(logoutSuccessMsg).trim()
				.equals("You have been successfully logged out."));
	}

}
