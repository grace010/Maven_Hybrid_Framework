package pageObjects.Nopcommerce.portal;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.user.UserMyAccountPageUI;
import commons.BasePage;
import io.qameta.allure.Step;

public class UserCustomerInfoPageObject extends BasePage {
	private WebDriver driver;
	public UserCustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Open Customer infor page")
	public Object getCustomerInforPageHeader() {
		waitforElementVisible(driver, UserMyAccountPageUI.CUSTOMER_INFO_HEADER);
		return getElementText(driver, UserMyAccountPageUI.CUSTOMER_INFO_HEADER);
	}

}
