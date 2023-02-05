package pageObjects.Nopcommerce.portal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import PageUIs.nopcommerce.user.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	private WebDriver driver;
	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Click to register button")
	public void clickRegisterButton() {
		waitForAllElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
	}
	
	public String getFirstNameErrorMessage() {
		waitforElementVisible(driver, UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}
	
	public String getLastNameErrorMessage() {

		waitforElementVisible(driver, UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}

	public String getEmailErrorMessage() {

		waitforElementVisible(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getPasswordErrorMessage() {
		waitforElementVisible(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getConfirmPasswordErrorMessage() {
		waitforElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}
	
	@Step("Input firstname textbox : {0}")
	public void inputFirstNameTextBox(String firstName) {
		waitforElementVisible(driver, UserRegisterPageUI.INPUT_TO_FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.INPUT_TO_FIRST_NAME_TEXTBOX, firstName);

	}
	
	@Step("Input lastname textbox : {0}")
	public void inputLastNameTextBox(String lastName) {
		waitforElementVisible(driver, UserRegisterPageUI.INPUT_TO_LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.INPUT_TO_LAST_NAME_TEXTBOX, lastName);

	}

	@Step("Input password textbox : {0}")
	public void inputPasswordTextBox(String password) {
		waitforElementVisible(driver, UserRegisterPageUI.INPUT_TO_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.INPUT_TO_PASSWORD_TEXTBOX, password);

	}
	
	@Step("Input confirm password textbox : {0}")
	public void inputConfirmPasswordTextBox(String confirmPassword) {
		waitforElementVisible(driver, UserRegisterPageUI.INPUT_TO_CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.INPUT_TO_CONFIRM_PASSWORD_TEXTBOX, confirmPassword);

	}

	@Step("Verify regisger success message")
	public String getRegisterSuccessMessage() {
		waitforElementVisible(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public UserHomePageObject clickToLogoutLink() {
		waitForAllElementClickable(driver, UserRegisterPageUI.LOGOUT_BUTTON);
		clickToElement(driver, UserRegisterPageUI.LOGOUT_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
		

	}

	public String getErrorExistingEmailMessaage() {
		waitforElementVisible(driver, UserRegisterPageUI.EMAIL_REGISTER_EXISTING_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EMAIL_REGISTER_EXISTING_MESSAGE);
	}

	public WebElement getEmailElement() {
		return getWebElement(driver, UserRegisterPageUI.INPUT_TO_EMAIL_TEXTBOX);
	}

	public void inputEmailTextBox(String emailAddress) {
		waitforElementVisible(driver, UserRegisterPageUI.INPUT_TO_EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.INPUT_TO_EMAIL_TEXTBOX, emailAddress);
		
	}


}