package pageObject.jQuery.UploadFile;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageUIs.jQuery.UploadFiles.HomePageUI;
import commons.BasePage;

public class HomePageObject extends BasePage{
	WebDriver driver;
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean VerifyFileUpload(String... fileName) {
		waitforElementVisible(driver, HomePageUI.FILE_UPLOADED, fileName);
		return isElementDisplay(driver, HomePageUI.FILE_UPLOADED, fileName);
	}

	public void clickToStartButton() {
		waitForAllElementClickable(driver, HomePageUI.START_BUTTON);
		List <WebElement> listStartButton = getListWebElement(driver, HomePageUI.START_BUTTON) ;
		for (WebElement startButton : listStartButton) {
			startButton.click();
		}
	}
	
	public boolean VerifyFileUploadedLink(String... fileName) {
		waitforElementVisible(driver, HomePageUI.FILE_NAME_UPLOADED_LINK, fileName);
		return isElementDisplay(driver, HomePageUI.FILE_NAME_UPLOADED_LINK, fileName);
	}
	
	public boolean VerifyFileUploadedImage(String... fileName) {
		waitforElementVisible(driver, HomePageUI.FILE_NAME_UPLOADED_IMAGE, fileName);
		return isImageLoaded(driver, HomePageUI.FILE_NAME_UPLOADED_IMAGE, fileName);
	}
	
} 
