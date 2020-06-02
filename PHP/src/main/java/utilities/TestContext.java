package utilities;

import org.openqa.selenium.WebDriver;

import managers.DriverManager;
import managers.PageObjectManager;

public class TestContext {

	private WebDriver driver;
	private PageObjectManager pageObjectManager;
	private DriverManager driverManager;
	private ElementFactory elementFactory;

	public TestContext() {
		driverManager = new DriverManager();
		try {
			driver = driverManager.getDriver(EnvPropertyManager.getBrowser());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public DriverManager getDriverManager() {
		return driverManager;
	}

	public WebDriver getWebDriver() {
		return driver;
	}

	public PageObjectManager getPageObjectManager() {
		return (pageObjectManager == null) ? pageObjectManager = new PageObjectManager(driver) : pageObjectManager;
	}

	public ElementFactory getElementFactory() {
		return (elementFactory == null) ? elementFactory = new ElementFactory(driver) : elementFactory;
	}

}
