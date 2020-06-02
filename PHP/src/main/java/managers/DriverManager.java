package managers;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This is the helper class for initializing WebDrivers and loading the browser
 * with base URL
 */
public class DriverManager {

	private WebDriver driver;

	/**
	 * This method will create driver for respective browser
	 * 
	 * @param driverType - Type of the driver needs to be creates
	 * 
	 * @return WebDriver based on type of the driver
	 * 
	 * @throws Exception if the driver is not created successfully
	 */
	public WebDriver getDriver(DriverType driverType) throws Exception {
		try {
			switch (driverType) {
			case FIREFOX:
				System.setProperty(DataManager.getFirefoxDriver(), DataManager.getFirefoxDriverPath());
				driver = new FirefoxDriver();
				break;
			case CHROME:
				System.setProperty(DataManager.getChromeDriver(), DataManager.getChromeDriverPath());
				driver = new ChromeDriver();
				break;
			default:
				System.setProperty(DataManager.getChromeDriver(), DataManager.getChromeDriverPath());
				driver = new ChromeDriver();
				break;
			}
			maximizeWindow();
			driver.manage().timeouts().pageLoadTimeout(10000,
					TimeUnit.MILLISECONDS);
		} catch (Exception e) {
			throw new Exception("Driver is not initialized for driver type " + driverType.toString() + e);
		}
		return driver;
	}

	/**
	 * This method will load the URL in the browser without angular wait
	 * 
	 * @param baseUrl - URL which needs to loaded in browser
	 * 
	 * @throws Exception if the URL is not loaded successfully
	 */
	public void navigateToUrlWithoutAngularWait(String baseUrl) {
		driver.get(baseUrl);
	}

	/**
	 * This method will close the current browser window
	 * 
	 * @throws Exception if the browser is not closed successfully
	 */
	public void closeBrowser() {
		driver.close();
	}

	/**
	 * This method will quit all the browsers window
	 * 
	 * @throws Exception if all the browsers are not quited successfully
	 */
	public void quitBrowser() {
		driver.quit();
	}

	/**
	 * This method will maximize the browser window
	 * 
	 */
	private void maximizeWindow() {
		driver.manage().window().maximize();
	}
}
