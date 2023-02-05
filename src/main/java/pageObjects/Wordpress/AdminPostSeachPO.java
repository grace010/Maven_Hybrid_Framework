package pageObjects.Wordpress;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageUIs.wordpress.admin.AdminPostSearchPageUI;
import commons.BasePage;

public class AdminPostSeachPO extends BasePage {
	private WebDriver driver;

	public AdminPostSeachPO(WebDriver driver) {
		this.driver = driver;
	}

	public void inputSearchValue(String searchValue) {
		waitforElementVisible(driver, AdminPostSearchPageUI.SEARCH_BOX);
		sendkeyToElement(driver, AdminPostSearchPageUI.SEARCH_BOX, searchValue);
		
		
	}

	public void clickToSearchPostButton() {
		waitForAllElementClickable(driver, AdminPostSearchPageUI.SEARCH_POST_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.SEARCH_POST_BUTTON);
	}
	
	public boolean getSearchTitle(String searchValue) {
		List<WebElement> elements = getListWebElement(driver, AdminPostSearchPageUI.SEARCH_TITLE);
		waitForAllElementVisible(driver, AdminPostSearchPageUI.SEARCH_TITLE);
		for (WebElement webElement : elements) {
			if (webElement.getText().contains(searchValue)) {
				return true;
			}
		}
		return true;

	}

}
