package pageObjects.Wordpress;

import org.openqa.selenium.WebDriver;

import PageUIs.wordpress.admin.AdminDashboardPageUI;
import commons.BasePage;

public class AdminDashboardPO extends BasePage{
	private WebDriver driver;

	public AdminDashboardPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostSeachPO clickToPostMenuLink() {
		waitForAllElementClickable(driver, AdminDashboardPageUI.POST_MENU_LINK);
		clickToElement(driver, AdminDashboardPageUI.POST_MENU_LINK);
		return PageGeneratorManager.getAdminPostSearchPage(driver);
	}
}
