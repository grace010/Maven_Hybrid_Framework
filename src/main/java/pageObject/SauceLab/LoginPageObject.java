package pageObject.SauceLab;

import org.openqa.selenium.WebDriver;

import PageUIs.saucelab.LoginPageUI;
import commons.BasePage;

public class LoginPageObject extends BasePage{
	WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void enterUserName(String username) {
		waitforElementVisible(driver,LoginPageUI.USER_NAME_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.USER_NAME_TEXTBOX, username);
		
	}
	
	public void enterPassword(String password) {
		waitforElementVisible(driver,LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
		
	}
	
	public ProductPageObject clickToLoginButton() {
		waitForAllElementClickable(driver,LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return new ProductPageObject(driver);
		
	}
	
	
	
	
	
}
