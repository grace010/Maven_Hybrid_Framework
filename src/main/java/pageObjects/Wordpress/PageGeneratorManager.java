package pageObjects.Wordpress;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

	public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPO(driver);
	}

	public static AdminDashboardPO getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPO(driver);
	}

	public static AdminPostSeachPO getAdminPostSearchPage(WebDriver driver) {
		return new AdminPostSeachPO(driver);
	}

	public static AdminAddNewPO getAdminAddNewPage(WebDriver driver) {
		return new AdminAddNewPO(driver);
	}
}
