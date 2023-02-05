package com.nopcommerce.user;

import java.lang.reflect.Method;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import io.qameta.allure.Description;
import pageObjects.Nopcommerce.portal.UserAddressPageObject;
import pageObjects.Nopcommerce.portal.UserCustomerInfoPageObject;
import pageObjects.Nopcommerce.portal.UserHomePageObject;
import pageObjects.Nopcommerce.portal.UserRegisterPageObject;
import pageObjects.Nopcommerce.portal.UserRewardPointPageObject;

public class Level_15_Report_Allure extends BaseTest {
	String projectPath = System.getProperty("user.dir");
	WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserCustomerInfoPageObject customerInforPage;
	private UserAddressPageObject addressPage;
	private UserRewardPointPageObject rewardPointPage;

	String emailAdressFake = random() + "@gmail.com";

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}
	
	@Description("Register to system")
	@Test
	public void User_01_Register() {
		
		registerPage = homePage.clickRegisterLink();
		
		
		registerPage.inputFirstNameTextBox("grace");
		
		registerPage.inputLastNameTextBox("tran");
		
		registerPage.inputEmailTextBox(emailAdressFake);
		
		registerPage.inputPasswordTextBox("123456");
		
		registerPage.inputConfirmPasswordTextBox("123456");
		
		registerPage.clickRegisterButton();
		
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration123 completed");
	}

	@Description("Switch account each other")
	@Test
	public void User_02_Switch_Account(Method method) {
		
		customerInforPage = homePage.clickMyAccountLink();
		verifyEquals(customerInforPage.getCustomerInforPageHeader(), "My account1 - Customer info");
		
		addressPage = customerInforPage.clickAddressLink(driver);
		
		customerInforPage = addressPage.clickCustomerInfoLink(driver);
		verifyEquals(customerInforPage.getCustomerInforPageHeader(), "My account2 - Customer info");
		
		rewardPointPage = customerInforPage.clickRewardPointLink(driver);
		
		customerInforPage = rewardPointPage.clickCustomerInfoLink(driver);
		

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
