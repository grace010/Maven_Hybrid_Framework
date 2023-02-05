package pageObjects.Nopcommerce.portal;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.user.UserHomePageUI;
import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;

public class UserHomePageObject extends BasePage {
	private WebDriver driver;
	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Click to register link")
	public UserRegisterPageObject clickRegisterLink() {
		waitForAllElementClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		return new UserRegisterPageObject(driver);
	}
	
	public UserLoginPageObject clickLoginLink() {
		waitForAllElementClickable(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);
		
	}
	
	public UserCustomerInfoPageObject clickMyAccountLink() {
		waitForAllElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return new UserCustomerInfoPageObject(driver);
	}
	
	
}
