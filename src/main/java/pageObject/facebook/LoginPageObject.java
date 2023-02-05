package pageObject.facebook;

import org.openqa.selenium.WebDriver;

import PageUIs.facebook.LoginPageUI;
import commons.BasePage;

public class LoginPageObject extends BasePage {
	private WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	 
	public void clickToCreateNewAccount() {
		waitforElementVisible(driver, LoginPageUI.CREATE_NEW_ACCOUNT);
		clickToElement(driver, LoginPageUI.CREATE_NEW_ACCOUNT);
		 
	}
	public boolean verifyEmailAddressIsDisplayed() {
		waitforElementVisible(driver, LoginPageUI.EMAIL_ADDRESS);
		return isElementDisplay(driver, LoginPageUI.EMAIL_ADDRESS);
	}
	
	public void inputEmailAdress(String emailadress) {
		waitforElementVisible(driver, LoginPageUI.EMAIL_ADDRESS);
		sendkeyToElement(driver, LoginPageUI.EMAIL_ADDRESS, emailadress);
	}
	public boolean verifyConfirmEmailAddressIsDisplayed() {
		return isElementDisplay(driver, LoginPageUI.RE_ENTER_EMAIL_ADDRESS);
	}

	public void clickCloseIconAtRegisterForm() {
		waitforElementVisible(driver, LoginPageUI.CLOSE_SIGN_UP_POP_UP_BUTTON);
		clickToElement(driver, LoginPageUI.CLOSE_SIGN_UP_POP_UP_BUTTON);
		
	}

	public boolean verifyConfirmEmailAddressUnDisplayed() {
		waitforElementUnDisplayed(driver, LoginPageUI.RE_ENTER_EMAIL_ADDRESS);
		return isElementUndisplayed(driver, LoginPageUI.RE_ENTER_EMAIL_ADDRESS);
	}


}
