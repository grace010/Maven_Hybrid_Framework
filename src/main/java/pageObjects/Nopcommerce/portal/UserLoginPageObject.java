package pageObjects.Nopcommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import PageUIs.nopcommerce.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
	private WebDriver driver;
	 public UserLoginPageObject(WebDriver driver) {
	  this.driver = driver;
	 }
	public UserHomePageObject clickLoginButton() {
		waitForAllElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return new UserHomePageObject(driver);
	}
	public String getErrorEmailMessage() {
		waitforElementVisible(driver, UserLoginPageUI.ERROR_EMAIL_MESSAGE);
		return getElementText(driver,UserLoginPageUI.ERROR_EMAIL_MESSAGE);
	}
	public void inputEmailTextbox(String emailAddress) {
		sendkeyToElement(driver,UserLoginPageUI.EMAIL_TEXTBOX , emailAddress);
		
	}
	public String getErrorEmailPasswordMessaage() {
		waitforElementVisible(driver, UserLoginPageUI.ERROR_EMAIL_PASSWORD_MESSAGE);
		return getElementText(driver,UserLoginPageUI.ERROR_EMAIL_PASSWORD_MESSAGE);
	}
	public void inputPasswordTextbox(String password) {
		sendkeyToElement(driver,UserLoginPageUI.PASSWORD_TEXTBOX , password);
		
	} 
	public String getLoginUrl() {
		return getCurrentUrl(driver);
	}
	
	public UserHomePageObject loginAsUser(String emailAddress, String password) {
		inputEmailTextbox(emailAddress);
		inputPasswordTextbox(password);	
		return clickLoginButton();
		
	}
	
	
	
	
	
}
