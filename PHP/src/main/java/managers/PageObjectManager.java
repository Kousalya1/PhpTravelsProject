package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.RegistrationPage;
import pageObjects.LoginPage;
import pageObjects.MyDetailsPage;
import utilities.ElementFactory;

public class PageObjectManager {

	WebDriver driver;
	RegistrationPage registrationPage;
	LoginPage loginPage;
	MyDetailsPage myDetailsPage;
	ElementFactory elementFactory;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
	}

	public RegistrationPage getRegistrationPage() {
		return (registrationPage == null) ? registrationPage = new RegistrationPage(driver) : registrationPage;
	}
	
	public MyDetailsPage getMyDetailsPage() {
		return (myDetailsPage == null) ? myDetailsPage = new MyDetailsPage(driver) : myDetailsPage;
	}

	public ElementFactory getElementFactory() {
		return (elementFactory == null) ? elementFactory = new ElementFactory(driver) : elementFactory;
	}

}
