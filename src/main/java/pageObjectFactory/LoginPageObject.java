package pageObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class LoginPageObject extends BasePageFactory{
	 private WebDriver driver;
	 public LoginPageObject(WebDriver driver) {
	  this.driver = driver;
	  PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(xpath = "//button[@class= 'button-1 login-button']")
	 private WebElement loginButton;
	 @FindBy(xpath = "//span[@id= 'Email-error']")
	 private WebElement emailErrorMessage;
	 @FindBy(xpath = "//input[@id = 'Email']")
	 private WebElement emailTextbox;
	 @FindBy(xpath = "//div[@class = 'message-error validation-summary-errors']")
	 private WebElement errorEmailPasswordMessage;
	 @FindBy(xpath = "//span[@id ='Email-error']")
	 private WebElement errorEmailMessage;
	 @FindBy(xpath = "//input[@id='Password']")
	 private WebElement passwordTextbox;
	
	 public void clickLoginButton() {
			waitForAllElemetClickable(driver, loginButton);
			clickToElement(driver,loginButton);
			
		}
		public String getErrorEmailMessage() {
			waitforElementVisible(driver, emailErrorMessage);
			return getElementText(driver, emailErrorMessage);
		}
		public void inputEmailTextbox(String emailAddress) {
			sendkeyToElement(driver, emailTextbox, emailAddress);
			
		}
		public String getErrorEmailPasswordMessaage() {
			waitforElementVisible(driver, errorEmailPasswordMessage);
			return getElementText(driver, errorEmailPasswordMessage);
		}
		public void inputPasswordTextbox(String password) {
			sendkeyToElement(driver, passwordTextbox, password);
			
		} 
		public String getLoginUrl() {
			return getCurrentUrl(driver);
		}
}









