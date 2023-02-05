package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.PageGeneratorManager;
import pageObjects.Nopcommerce.portal.UserAddressPageObject;
import pageObjects.Nopcommerce.portal.UserCustomerInfoPageObject;
import pageObjects.Nopcommerce.portal.UserHomePageObject;
import pageObjects.Nopcommerce.portal.UserLoginPageObject;
import pageObjects.Nopcommerce.portal.UserRegisterPageObject;

public class Level_07_Switch_Page{
	String projectPath = System.getProperty("user.dir");
	WebDriver driver;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserRegisterPageObject registerPage;
	private UserCustomerInfoPageObject customerInforPage;
	private UserAddressPageObject addressPage;
	
	
	String emailAdressFake = random() + "@gmail.com";

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void User_01_Register() {
		homePage = PageGeneratorManager.getHomePage(driver);

		registerPage = homePage.clickRegisterLink();
		registerPage.inputFirstNameTextBox("grace");

		registerPage.inputLastNameTextBox("tran");

		registerPage.inputEmailTextBox(emailAdressFake);

		registerPage.inputPasswordTextBox("123456");

		registerPage.inputConfirmPasswordTextBox("123456");

		registerPage.clickRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void User_02_Login() {
		loginPage = homePage.clickLoginLink();
		loginPage.inputEmailTextbox(emailAdressFake);
		loginPage.inputPasswordTextbox("123456");
		homePage = loginPage.clickLoginButton();
		Assert.assertEquals(loginPage.getLoginUrl(),"https://demo.nopcommerce.com/");

	}

	@Test
	public void User_03_MyAccount() {
		customerInforPage = homePage.clickMyAccountLink();
	}
	
	@Test
	public void User_04_Switch_Account() {
		//customer infor >> address
		addressPage = customerInforPage.clickAddressLink(driver);
		//address > customer info
		customerInforPage = addressPage.clickCustomerInfoLink(driver);
		
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
