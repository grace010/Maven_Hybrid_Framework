package pageObjects.Nopcommerce.admin;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.admin.AdminLoginPageUI;
import commons.BasePage;
import commons.PageGeneratorManager;

public class AdminLoginPageObject  extends BasePage {
	private WebDriver driver;
	 public AdminLoginPageObject(WebDriver driver) {
	  this.driver = driver;
	 }
	 
	 public AdminDashboardPageObject clickLoginButton() {
			waitForAllElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
			clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
			return new AdminDashboardPageObject(driver);
		}
	 public void inputEmailTextbox(String emailAddress) {
			sendkeyToElement(driver,AdminLoginPageUI.LOGIN_EMAIL_TEXTBOX , emailAddress);
			
		}
	 public void inputPasswordTextbox(String password) {
			sendkeyToElement(driver,AdminLoginPageUI.LOGIN_PASSWORD_TEXTBOX , password);
			
		}
	 
	 public AdminDashboardPageObject loginAsAdmin(String emailAddress, String password ) {
		 inputEmailTextbox(emailAddress);
		 inputPasswordTextbox(password);
		 clickLoginButton();
		 return PageGeneratorManager.getAdminHomePage(driver);	 
	 }
	 
	 
	 
}
