package pageObjects.Wordpress;

import org.openqa.selenium.WebDriver;

import PageUIs.wordpress.admin.AdminLoginPageUI;
import commons.BasePage;

public class AdminLoginPO extends BasePage{
	private WebDriver driver;

	public AdminLoginPO(WebDriver driver) {
		this.driver = driver;
	}

	public void inputAdminUserName(String adminUsername) {
		waitforElementVisible(driver, AdminLoginPageUI.USER_NAME_TEXT_BOX);
		sendkeyToElement(driver, AdminLoginPageUI.USER_NAME_TEXT_BOX,adminUsername );
	}

	public void inputAdminPassword(String adminPassword) {
		waitforElementVisible(driver,AdminLoginPageUI.PASSWORD_TEXT_BOX );
		sendkeyToElement(driver,AdminLoginPageUI.PASSWORD_TEXT_BOX,adminPassword );
	}

	public AdminDashboardPO clickToLoginButton() {
		waitForAllElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashboardPage(driver);
	}
}
