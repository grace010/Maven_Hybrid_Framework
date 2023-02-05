package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageUIs.jQuery.UploadFiles.BasePageJqueryUI;
import PageUIs.nopcommerce.user.BasePageUI;
import io.qameta.allure.Step;
import pageObjects.Nopcommerce.portal.UserAddressPageObject;
import pageObjects.Nopcommerce.portal.UserCustomerInfoPageObject;
import pageObjects.Nopcommerce.portal.UserRewardPointPageObject;

public class BasePage {
	Alert alert;

	public void openPageURL(WebDriver driver, String pageUrl) {
		driver.get(pageUrl); 
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl(); 
	}

	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public Set<Cookie> getAllCookies(WebDriver driver){
		return driver.manage().getCookies();
	}
	
	public void setCookies(WebDriver driver, Set<Cookie> cookies) {
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
		sleepInSection(3);
	}

	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver,longTimeout );
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	public String alertGetText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	public void sendkeyToAlert(WebDriver driver, String valueText) {
		waitForAlertPresence(driver).sendKeys(valueText);
		;
	}

	public void swithToWindowById(WebDriver driver, String WindowID) {
		Set<String> allWindowId = driver.getWindowHandles();
		for (String id : allWindowId) {
			if (!id.equals(WindowID)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}

	public void switchtoWindowbyTitle(WebDriver driver, String expectedTitle) {
		Set<String> windownID = driver.getWindowHandles();
		for (String id : windownID) {
			driver.switchTo().window(id);
			String title = driver.getTitle();
			if (title.equals(expectedTitle)) {
				break;
			}
		}
	}

	public void closeAllTabWithoutParent(WebDriver driver, String parentID) {
		Set<String> windownID = driver.getWindowHandles();
		for (String id : windownID) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();
			}
			driver.switchTo().window(parentID);
		}
	}

	public WebElement getWebElement(WebDriver driver, String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}

	public List<WebElement> getListWebElement(WebDriver driver, String locatorType) {
		return driver.findElements(getByLocator(locatorType));
	}

//	private By getByXpath(String locatorType) {
//		return By.xpath(locatorType);
//	}
	
	
	public void pressKeyToElement(WebDriver driver, String locatorType, Keys key,String...restParaValue) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, getDynamicLocator(locatorType, restParaValue)), key).perform();
	}
	
	private By getByLocator(String locatorType) { 
		By by = null;
		if (locatorType.startsWith("id=")) {
			by = By.id(locatorType.substring(3));
		} else if(locatorType.startsWith("class=")) {
			by = By.className(locatorType.substring(3));
		}
		else if(locatorType.startsWith("name=")) {
			by = By.name(locatorType.substring(5));
		} 
		else if(locatorType.startsWith("css=")) {
			by = By.cssSelector(locatorType.substring(4));
		}
		else if(locatorType.startsWith("xpath=")) {
			by = By.xpath(locatorType.substring(6));
		}
		else {
			throw new RuntimeException("Locator type is not supported");
		}
	
		return by;
	}
	
	private String getDynamicLocator(String locatorType, String...restParaValue) {
		if(locatorType.startsWith("xpath=")) {
			locatorType = String.format(locatorType, (Object[]) restParaValue);
		}
		return locatorType;
	}
	
	public void clickToElement(WebDriver driver, String locatorType) {
		getWebElement(driver, locatorType).click();
	}
	
	public void clickToElement(WebDriver driver, String locatorType, String...restParaValue) {
		getWebElement(driver, getDynamicLocator(locatorType, restParaValue)).click();
	}
	
	public void sendkeyToElement(WebDriver driver, String locatorType, String valueText) {
		WebElement element = getWebElement(driver, locatorType);
		element.clear();
		element.sendKeys(valueText);
	}
	public void sendkeyToElement(WebDriver driver, String locatorType, String valueText, String...restParaValue ) {
		WebElement element = getWebElement(driver, getDynamicLocator(locatorType, restParaValue));
		element.clear();
		element.sendKeys(valueText);
	}

	public void selectItembyDefaultDropdown(WebDriver driver, String locatorType, String textItem) {
		Select select = new Select(getWebElement(driver, locatorType));
		select.selectByVisibleText(textItem);
	}
	
	public void selectItembyDefaultDropdown(WebDriver driver, String locatorType, String textItem, String...restParaValue) {
		Select select = new Select(getWebElement(driver, getDynamicLocator(locatorType, restParaValue)));
		select.selectByVisibleText(textItem);
	}

	public String getSelectedItemDefaultDropDown(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropDownMultiple(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.isMultiple();
	}

	public void customDropDown(WebDriver driver, String parentNode, String childNode, String selectedItem) {
		getWebElement(driver, parentNode).click();

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childNode)));
		sleepInSection(1);
		List<WebElement> allItems = driver.findElements(getByLocator(childNode));

		for (WebElement item : allItems) {
			String textItem = item.getText();
			if (textItem.trim().equals(selectedItem)) {
				JavascriptExecutor jsExecutor;
				jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true)", item);
				item.click();
				break;
			}
		}
	}

	public void sleepInSection(long timeInSection) {
		try {
			Thread.sleep(timeInSection * 1000);
		} catch (Exception e) {
			// TODO: handle exceptVerify_Default_Dropdown2.javaion
			e.printStackTrace();
		}
	}

	public String getElementAttribute(WebDriver driver, String locatorType, String attributeValue) {
		return getWebElement(driver, locatorType).getAttribute(attributeValue);
	}
	
	public String getElementAttribute(WebDriver driver, String locatorType, String attributeValue, String...restParaValue) {
		return getWebElement(driver, getDynamicLocator(locatorType, restParaValue)).getAttribute(attributeValue);
	}

	public String getElementText(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).getText();
	}
	
	public String getElementText(WebDriver driver, String locatorType, String...restParaValue ) {
		return getWebElement(driver, getDynamicLocator(locatorType, restParaValue)).getText();
	}

	public String getElementCssValue(WebDriver driver, String locatorType, String propertyName) {
		return getWebElement(driver, locatorType).getCssValue(propertyName);
	}

	public String convertToHexa(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}

	public int getElementSize(WebDriver driver, String locatorType) {
		return getListWebElement(driver, locatorType).size();
	}
	
	public int getElementSize(WebDriver driver, String locatorType, String...restParaValue) {
		return getListWebElement(driver, getDynamicLocator(locatorType, restParaValue)).size();
	}

	public void checkTodefaultCheckbox(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (!element.isSelected()) {
			element.click();
		}
	}
	
	public void checkTodefaultCheckbox(WebDriver driver, String locatorType, String...restParaValue) {
		WebElement element = getWebElement(driver, getDynamicLocator(locatorType, restParaValue));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckTodefaultCheckbox(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplay(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isDisplayed();
	}

	public boolean isElementDisplay(WebDriver driver, String locatorType, String...restParaValue) {
		return getWebElement(driver, getDynamicLocator(locatorType, restParaValue)).isDisplayed();
	}
	
	public boolean isElementEnable(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isSelected();
	}

	public void swithToFrameOrIframe(WebDriver driver, String locatorType) {
		driver.switchTo().frame(getWebElement(driver, locatorType));
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void hoverMouseToElement(WebDriver driver, String locatorType) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locatorType)).perform();
	}

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void highlightElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locatorType);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");
		sleepInSection(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locatorType));
	}

	public void scrollToElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locatorType));
	}

	public void removeAttributeInDOM(WebDriver driver, String locatorType, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getWebElement(driver, locatorType));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;",
				getWebElement(driver, locatorType));
	}

	public boolean isImageLoaded(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getWebElement(driver, locatorType));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isImageLoaded(WebDriver driver, String locatorType, String...restParaValue) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getWebElement(driver, getDynamicLocator(locatorType, restParaValue)));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public void waitforElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
	}
	
	public void waitforElementVisible(WebDriver driver, String locatorType, String...restParaValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicLocator(locatorType, restParaValue))));
	}

	public void waitForAllElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
	}
	
	public void waitForAllElementVisible(WebDriver driver, String locatorType, String...restParaValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicLocator(locatorType, restParaValue))));
	}


	public void waitforElementInVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
	}
	/*
	 * Wait for elements undisplayed in dom or not in dom and override implicit timeout
	 */
	public void waitforElementUnDisplayed(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, shortTimeout);
		overrideImplicitTimeout(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
		overrideImplicitTimeout(driver, longTimeout);
	}
	
	public void waitforElementInVisible(WebDriver driver, String locatorType, String...restParaValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicLocator(locatorType, restParaValue))));
	}

	public void waitForAllElementInvisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, locatorType)));
	}
 
	public void waitForAllElementClickable(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
	}
	
	public void waitForAllElementClickable(WebDriver driver, String locatorType, String...restParaValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicLocator(locatorType, restParaValue))));
	}
	
	@Step("Open Address page")
	public UserAddressPageObject clickAddressLink(WebDriver driver) {
		waitForAllElementClickable(driver, BasePageUI.ADDRESSES);
		clickToElement(driver, BasePageUI.ADDRESSES);
		return PageGeneratorManager.getAddressPage(driver);
	}
	
	public UserCustomerInfoPageObject clickCustomerInfoLink(WebDriver driver) {
		waitForAllElementClickable(driver, BasePageUI.CUSTOMER_INFO);
		clickToElement(driver, BasePageUI.CUSTOMER_INFO);
		return PageGeneratorManager.getMyAccountPage(driver);
	}
	
	@Step("Open Reward page")
	public UserRewardPointPageObject clickRewardPointLink(WebDriver driver) {
		waitForAllElementClickable(driver, BasePageUI.REWARD_POINT);
		clickToElement(driver, BasePageUI.REWARD_POINT);
		return PageGeneratorManager.getRewardPointPage(driver);
	}
	
	public void uploadMutipleFiles(WebDriver driver, String...fileNames) {
		String filePath = GlobalConstants.UPLOAD_FILE_FOLDER;
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file +"\n";
		}
		fullFileName = fullFileName.trim();
		getWebElement(driver,BasePageJqueryUI.UPLOAD_FILE_BUTTON).sendKeys(fullFileName);
	}
	
	
	public BasePage switchMyAccountPage(WebDriver driver, String pageName) {
		waitForAllElementClickable(driver, BasePageUI.DYNAMIC_PAGE_AT_MYACCOUNT_AREA, pageName );
		clickToElement(driver, BasePageUI.DYNAMIC_PAGE_AT_MYACCOUNT_AREA, pageName);
		switch (pageName) {
		case "Customer info":
			return PageGeneratorManager.getMyAccountPage(driver);
		case "Addresses":
			return PageGeneratorManager.getAddressPage(driver);
		case "Reward points":
			return PageGeneratorManager.getRewardPointPage(driver);
		default:
			throw new RuntimeException("Invalid page name at my account area");
			
		}
	}
	
	public void switchMyAccountPageName(WebDriver driver, String pageName) {
		waitForAllElementClickable(driver, BasePageUI.DYNAMIC_PAGE_AT_MYACCOUNT_AREA, pageName );
		clickToElement(driver, BasePageUI.DYNAMIC_PAGE_AT_MYACCOUNT_AREA, pageName);
	}
	
	/*
	 * enter dynamic text box by id
	 */
	
	public void inputTextBoxByID(WebDriver driver, String textBoxID, String value ) {
		waitforElementVisible(driver, BasePageUI.DYNAMIC_TEXT_BOX_BY_ID, textBoxID);
		sendkeyToElement(driver, BasePageUI.DYNAMIC_TEXT_BOX_BY_ID, value, textBoxID);
	}
	
	/*
	 * click to dynamic button by text
	 */
	public void clickToButtonByText(WebDriver driver, String buttonText) {
		waitForAllElementClickable(driver, BasePageUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
		clickToElement(driver, BasePageUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
	}

	public void selectByDrpopDownAttributeName(WebDriver driver, String buttonDropDown, String value) {
		waitForAllElementClickable(driver, BasePageUI.DYNAMIC_DROP_DOWN_BY_ATTRIBUTE, buttonDropDown);
		selectItembyDefaultDropdown(driver, BasePageUI.DYNAMIC_DROP_DOWN_BY_ATTRIBUTE, value, buttonDropDown);
	}
	
	public String getTextBoxValueByID(WebDriver driver, String textBoxID) {
		waitforElementVisible(driver, BasePageUI.DYNAMIC_TEXT_BOX_BY_ID, textBoxID);
		return getElementAttribute(driver, BasePageUI.DYNAMIC_TEXT_BOX_BY_ID, "value", textBoxID);
	}

	public void overrideImplicitTimeout(WebDriver driver, long timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}
	
	public boolean isElementUndisplayed(WebDriver driver, String locatorType ) {
		overrideImplicitTimeout(driver, shortTimeout);
		List<WebElement> elements = getListWebElement(driver, locatorType);
		overrideImplicitTimeout(driver,longTimeout);
		if(elements.size()==0) {
			return true;
		}else if(elements.size()>0 && !elements.get(0).isDisplayed()) {
			return true;
		}else
			return false;
	}
	
	
	
	
	
	
	
	private long longTimeout = 30;
	private long shortTimeout = 5;

}
