package com.nopcommerce.common;

import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.Nopcommerce.portal.UserHomePageObject;
import pageObjects.Nopcommerce.portal.UserLoginPageObject;
import pageObjects.Nopcommerce.portal.UserRegisterPageObject;

public class Common_Register_Cookie extends BaseTest {
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	public static Set<Cookie> loggedCookie;
	
	@Parameters( "browser")
	@BeforeTest(description = "create one new a register account")
	public void Register(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		log.info("Register_Step01_Open reigster page");
		registerPage = homePage.clickRegisterLink();
		
		log.info("Register_Step02_Enter to firstname textbox");
		registerPage.inputFirstNameTextBox("grace");
		
		log.info("Register_Step03_Enter to lastname textbox");
		registerPage.inputLastNameTextBox("tran");
		
		log.info("Register_Step04_Enter to email texbox is '"+emailAdressFake+ "'");
		registerPage.inputEmailTextBox(emailAdressFake);
		
		log.info("Register_Step05_Enter to password texbox");
		registerPage.inputPasswordTextBox(password);
		
		log.info("Register_Step06_Enter to confirm password texbox");
		registerPage.inputConfirmPasswordTextBox(password);
		
		log.info("Register_Step07_Click to Register button");
		registerPage.clickRegisterButton();
		
		log.info("Register_Step08_Verify Register success");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		homePage = registerPage.clickToLogoutLink();
		loginPage = homePage.clickLoginLink();
		loginPage.inputEmailTextbox(emailAdressFake);
		loginPage.inputPasswordTextbox(password);
		homePage = loginPage.clickLoginButton();
		loggedCookie = homePage.getAllCookies(driver);
		
	}


	
	public static int random() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}

	@AfterTest
	public void afterClass() {
		driver.quit();
	}
	private WebDriver driver;
	public static String emailAdressFake  = random() + "@gmail.com";
	public static String password = "123456";
}
