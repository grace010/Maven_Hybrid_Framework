package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.Nopcommerce.portal.UserHomePageObject;
import pageObjects.Nopcommerce.portal.UserRegisterPageObject;

public class Level_03_Base_Object_01_Register {
	String projectPath = System.getProperty("user.dir");
	WebDriver driver;
	String emailAddress;
	int rand = random();
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private String firstName = "Grace", lastName = "Tran", password = "123456";

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		homePage = new UserHomePageObject(driver);
		registerPage = new UserRegisterPageObject(driver);
		driver.get("https://demo.nopcommerce.com/");
		emailAddress = rand + "@gmail.com";
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void Register_TC_01_EmptyData() {
		
		homePage.clickRegisterLink();

		
		registerPage.clickRegisterButton();
	
		Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
	
		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
		
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Email is required.");

		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password is required.");

		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "Password is required.");

	}

	@Test
	public void Register_TC_02_InvalidEmail() {
		homePage.clickRegisterLink();
		registerPage.inputEmailTextBox("1238u");
		//getWebElement(driver, "//input[@id='Email']").sendKeys(Keys.ENTER);
		registerPage.getEmailElement().sendKeys(Keys.ENTER);;
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Wrong email");

	}

	@Test
	public void Register_TC_03_RegisterSuccess() {
		homePage.clickRegisterLink();
		
		registerPage.inputFirstNameTextBox(firstName);
	
		registerPage.inputLastNameTextBox(lastName);

		registerPage.inputEmailTextBox(emailAddress);
	
		registerPage.inputPasswordTextBox(password);
		
		registerPage.inputConfirmPasswordTextBox("123456");
	
		registerPage.clickRegisterButton();
		
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		registerPage.clickToLogoutLink();

	}

	@Test
	public void Register_TC_04_RegisterEmailExist() {


		homePage.clickRegisterLink();

		registerPage.inputFirstNameTextBox(firstName);

		registerPage.inputLastNameTextBox(lastName);
		registerPage.inputEmailTextBox(emailAddress);
		
		registerPage.inputPasswordTextBox(password);
	
		registerPage.inputConfirmPasswordTextBox("123456");
		
		registerPage.clickRegisterButton();
		Assert.assertEquals(registerPage.getErrorExistingEmailMessaage(), "The specified email already exists");
	}

	@Test
	public void Register_TC_05_PasswordInvalid() {
		
		homePage.clickRegisterLink();
		registerPage.inputPasswordTextBox("1234");
		registerPage.clickRegisterButton();
		Assert.assertEquals(registerPage.getPasswordErrorMessage(),"Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void Register_TC_06_PasswordNotMatch() {

		homePage.clickRegisterLink();
		
		registerPage.inputPasswordTextBox(password);
		
		registerPage.inputConfirmPasswordTextBox("12345");
		
		registerPage.clickRegisterButton();
		
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(),"The password and confirmation password do not match.");

	}

	public int random() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

	

}
