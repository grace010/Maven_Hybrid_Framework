package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.Nopcommerce.admin.AdminDashboardPageObject;
import pageObjects.Nopcommerce.admin.AdminLoginPageObject;
import pageObjects.Nopcommerce.portal.UserAddressPageObject;
import pageObjects.Nopcommerce.portal.UserCustomerInfoPageObject;
import pageObjects.Nopcommerce.portal.UserHomePageObject;
import pageObjects.Nopcommerce.portal.UserLoginPageObject;
import pageObjects.Nopcommerce.portal.UserRegisterPageObject;
import pageObjects.Nopcommerce.portal.UserRewardPointPageObject;

public class PageGeneratorManager {
	public static UserHomePageObject getHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	} 
	
	public static UserRegisterPageObject geRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}
	
	public static UserLoginPageObject getLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}
	
	public static UserCustomerInfoPageObject getMyAccountPage(WebDriver driver) {
		return new UserCustomerInfoPageObject(driver);
	}
	public static UserAddressPageObject getAddressPage(WebDriver driver) {
		return new UserAddressPageObject(driver);
	}
	
	public static UserRewardPointPageObject getRewardPointPage(WebDriver driver) {
		return new UserRewardPointPageObject(driver);
	}
	
	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	
	public static AdminDashboardPageObject getAdminHomePage(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}

}
