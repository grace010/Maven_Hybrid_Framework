package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {
	
	private long timeout = 30;
	public void waitforElementVisible(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForAllElementVisible(WebDriver driver, WebElement elements) {
		WebDriverWait explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	public void waitforElementInVisible(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.invisibilityOf(element));
	}

	public void waitForAllElementInvisible(WebDriver driver, WebElement elements) {
		WebDriverWait explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(elements));
	}

	public void waitForAllElemetClickable(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void sendkeyToElement(WebDriver driver, WebElement element, String valueText) {
		element.clear();
		element.sendKeys(valueText);
	}
	
	public String getElementText(WebDriver driver, WebElement element) {
		return element.getText();
	}
	
	
	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	

}
