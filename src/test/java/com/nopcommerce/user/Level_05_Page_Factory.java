package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjectFactory.HomePageObject;
import pageObjectFactory.LoginPageObject;
import pageObjectFactory.RegisterPageObject;


public class Level_05_Page_Factory extends BaseTest{
	WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	String emailAddressRandom = random() + "@gmail.com";
	 
	@Parameters({"browser","url"})
	@BeforeClass   
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = new HomePageObject(driver);
		homePage.clickRegisterLink();
		registerPage = new RegisterPageObject(driver);
		registerPage.inputFirstNameTextBox("grace");
	
		registerPage.inputLastNameTextBox("tran");

		registerPage.inputEmailTextBox(emailAddressRandom);
	
		registerPage.inputPasswordTextBox("123456");
		
		registerPage.inputConfirmPasswordTextBox("123456");
	
		registerPage.clickRegisterButton();
		
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		registerPage.clickToLogoutLink();
		homePage = new HomePageObject(driver);
	}

	@Test
	public void Login_TC_01_EmptyData() {	
		homePage.clickLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.clickLoginButton();
		Assert.assertEquals(loginPage.getErrorEmailMessage(), "Please enter your email");
	}
	
	@Test
	public void Login_TC_02_InvalidEmail() {
		homePage.clickLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.inputEmailTextbox("1234");
		loginPage.clickLoginButton();
		Assert.assertEquals(loginPage.getErrorEmailMessage(), "Wrong email");
	}
	
	@Test
	public void Login_TC_03_EmailNotRegister() {
		homePage.clickLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.inputEmailTextbox("1234@gmail.com");
		loginPage.clickLoginButton();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class = 'message-error validation-summary-errors']")).getText(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
		Assert.assertEquals(loginPage.getErrorEmailPasswordMessaage(),"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}
	@Test
	public void Login_TC_04_BlankPassword() {
		homePage.clickLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.inputEmailTextbox(emailAddressRandom);
		loginPage.clickLoginButton();
		Assert.assertEquals(loginPage.getErrorEmailPasswordMessaage(),"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}
	
	@Test
	public void Login_TC_05_WrongPassword() {
		homePage.clickLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.inputEmailTextbox(emailAddressRandom);
		loginPage.inputPasswordTextbox("1234");
		loginPage.clickLoginButton();
		Assert.assertEquals(loginPage.getErrorEmailPasswordMessaage(),"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
	
	@Test
	public void Login_TC_06_LoginSuccess() {
		homePage.clickLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.inputEmailTextbox(emailAddressRandom);
		loginPage.inputPasswordTextbox("123456");
		loginPage.clickLoginButton();
		Assert.assertEquals(loginPage.getLoginUrl(),"https://demo.nopcommerce.com/");
	}
	
	public int random() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}

