package pageObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class RegisterPageObject extends BasePageFactory{
	 private WebDriver driver;
	 public RegisterPageObject(WebDriver driver) {
	  this.driver = driver;
	  PageFactory.initElements(driver, this);
	 }
	 @FindBy(xpath = "//button[@id ='register-button']")
	 private WebElement registerButton;
	 
	 @FindBy(xpath = "//span[@id = 'FirstName-error']")
	 private WebElement firstNameErrorMessage;
	 
	 @FindBy(xpath = "//span[@id ='LastName-error']")
	 private WebElement lastNameErrorMessage;
	 
	 @FindBy(xpath = "//span[@id = 'Email-error']")
	 private WebElement emailErrorMessage;
	 
	 @FindBy(xpath = "//span[@id = 'Password-error']")
	 private WebElement passwordErrorMessage;
	 
	 @FindBy(xpath = "//span[@id = 'ConfirmPassword-error']")
	 private WebElement confirmPasswordErrorMessage;
	 
	 @FindBy(xpath = "//input[@id='FirstName']")
	 private WebElement inputfirstNameTextbox;
	 
	 @FindBy(xpath = "//input[@id='LastName']")
	 private WebElement inputlastNameTextbox;
	 
	 @FindBy(xpath = "//input[@id='Email']")
	 private WebElement inputEmailTextbox;
	 
	 @FindBy(xpath = "//input[@id='Password']")
	 private WebElement inputPaswordTextbox;
	 
	 @FindBy(xpath = "//input[@id='ConfirmPassword']")
	 private WebElement inputConfirmPaswordTextbox;
	 
	 @FindBy(xpath = "//div[@class= 'result']")
	 private WebElement registerSuccessMessage;
	 
	 @FindBy(xpath = "//a[@class ='ico-logout']")
	 private WebElement logoutButton;
	 
	 @FindBy(xpath = "//div[@class = 'message-error validation-summary-errors']//li")
	 private WebElement emailRegisterExistingMessage;
	 
	 public void clickRegisterButton() {
			waitForAllElemetClickable(driver, registerButton);
			clickToElement(driver,registerButton);
		}

		public String getFirstNameErrorMessage() {
			waitforElementVisible(driver, firstNameErrorMessage);
			return getElementText(driver, firstNameErrorMessage);
		} 

		public String getLastNameErrorMessage() {

			waitforElementVisible(driver, lastNameErrorMessage);
			return getElementText(driver,lastNameErrorMessage);
		}

		public String getEmailErrorMessage() {

			waitforElementVisible(driver, emailErrorMessage);
			return getElementText(driver, emailErrorMessage);
		}

		public String getPasswordErrorMessage() {
			waitforElementVisible(driver, passwordErrorMessage);
			return getElementText(driver, passwordErrorMessage);
		}

		public String getConfirmPasswordErrorMessage() {
			waitforElementVisible(driver, confirmPasswordErrorMessage);
			return getElementText(driver, confirmPasswordErrorMessage);
		}

		public void inputFirstNameTextBox(String firstName) {
			waitforElementVisible(driver, inputfirstNameTextbox);
			sendkeyToElement(driver,inputfirstNameTextbox, firstName);

		}

		public void inputLastNameTextBox(String lastName) {
			waitforElementVisible(driver, inputlastNameTextbox);
			sendkeyToElement(driver,inputlastNameTextbox, lastName);

		}

		public void inputPasswordTextBox(String password) {
			waitforElementVisible(driver, inputPaswordTextbox);
			sendkeyToElement(driver, inputPaswordTextbox, password);

		}

		public void inputConfirmPasswordTextBox(String confirmPassword) {
			waitforElementVisible(driver, inputConfirmPaswordTextbox);
			sendkeyToElement(driver, inputConfirmPaswordTextbox, confirmPassword);

		}

		public String getRegisterSuccessMessage() {
			waitforElementVisible(driver, registerSuccessMessage);
			return getElementText(driver, registerSuccessMessage);
		}

		public void clickToLogoutLink() {
			waitForAllElemetClickable(driver, logoutButton);
			clickToElement(driver,logoutButton);

		}

		public String getErrorExistingEmailMessaage() {
			waitforElementVisible(driver, emailRegisterExistingMessage);
			return getElementText(driver, emailRegisterExistingMessage);
		}

		public WebElement getEmailElement() {
			return inputEmailTextbox;
		}

		public void inputEmailTextBox(String emailAddress) {
			waitforElementVisible(driver, inputEmailTextbox);
			sendkeyToElement(driver, inputEmailTextbox, emailAddress);

		}
		
}