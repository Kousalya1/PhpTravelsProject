package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class ElementFactory {

	private WebDriver driver;
	private Wait<WebDriver> wait;

	public ElementFactory(WebDriver driver) {
		this.driver = driver;
		wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMillis(30000))
				.pollingEvery(Duration.ofMillis(200)).ignoring(NoSuchElementException.class);
	}

	/**
	 * This method is will click the WebElement
	 *
	 * @param element - WebElement that needs to be clicked
	 * 
	 */
	public void elementClick(WebElement element) {
		try {
			waitUntilClickable(element);
			scrollIntoView(element);
			element.click();
		} catch (Exception e) {
			javaScriptExecutorClick(element);
		}
	}

	/**
	 * This method is will enter value in textbox fields
	 *
	 * @param element - Text field WebElement to interact with
	 * @param value   - value for the field
	 * 
	 */
	public void enterTextBox(WebElement element, String value) {
		waitUntilVisible(element);
		element.clear();
		if (!value.trim().isEmpty())
			element.sendKeys(value);
	}

	/***
	 * This method wait until the WebElement is clickable
	 * 
	 * @param element - WebElement to interact with
	 *
	 */
	public void waitUntilClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/***
	 * This method wait until the WebElement is visible
	 * 
	 * @param element - WebElement to interact with
	 *
	 */
	public void waitUntilVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/***
	 * This method wait click the WebElement using java script executor
	 * 
	 * @param element - WebElement that needs to be clicked
	 *
	 */
	public void javaScriptExecutorClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	/***
	 * This method will scroll the page till the element is visible
	 *
	 * @param element - WebElement to interact with
	 * 
	 */
	public void scrollIntoView(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * This method is will return the text value from WebElement
	 *
	 * @param element - WebElement to interact with
	 * 
	 * @return text value of the WebElement as string
	 * 
	 */
	public String elementGetText(WebElement element) {
		String returnText = "";
		if (wait.until(ExpectedConditions.elementToBeClickable(element)) != null) {
			if (element.isDisplayed() && element.isEnabled()) {
				returnText = element.getText().trim();
			}
		}
		return returnText;
	}
}
