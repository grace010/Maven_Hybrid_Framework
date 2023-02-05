package com.nopcommerce.user;

import java.lang.reflect.Method;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.Nopcommerce.portal.UserAddressPageObject;
import pageObjects.Nopcommerce.portal.UserCustomerInfoPageObject;
import pageObjects.Nopcommerce.portal.UserHomePageObject;
import pageObjects.Nopcommerce.portal.UserRegisterPageObject;
import pageObjects.Nopcommerce.portal.UserRewardPointPageObject;


public class Level_15_Attach_Screenshot extends BaseTest {
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

	@Test
	public void User_01_Register(Method method) {
//		ExtentManager.startTest(method.getName(), "User_01_Register");
//		ExtentManager.getTest().log(LogStatus.INFO, "Register_Step01_Open reigster page");
//		registerPage = homePage.clickRegisterLink();
//		
//		ExtentManager.getTest().log(LogStatus.INFO,"Register_Step02_Enter to firstname textbox");
//		registerPage.inputFirstNameTextBox("grace");
//		
//		ExtentManager.getTest().log(LogStatus.INFO,"Register_Step03_Enter to lastname textbox");
//		registerPage.inputLastNameTextBox("tran");
//		
//		ExtentManager.getTest().log(LogStatus.INFO,"Register_Step04_Enter to email texbox is '"+emailAdressFake+ "'");
//		registerPage.inputEmailTextBox(emailAdressFake);
//		
//		ExtentManager.getTest().log(LogStatus.INFO,"Register_Step05_Enter to password texbox");
//		registerPage.inputPasswordTextBox("123456");
//		
//		ExtentManager.getTest().log(LogStatus.INFO,"Register_Step06_Enter to confirm password texbox");
//		registerPage.inputConfirmPasswordTextBox("123456");
//		
//		ExtentManager.getTest().log(LogStatus.INFO,"Register_Step07_Click to Register button");
//		registerPage.clickRegisterButton();
//		
//		ExtentManager.getTest().log(LogStatus.INFO,"Register_Step08_Verify Register success");
//		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration123 completed");
//		ExtentManager.endTest();
//	}
//
//
//	@Test
//	public void User_02_Switch_Account(Method method) {
//		ExtentManager.startTest(method.getName(), "User_02_Switch_Account");
//		ExtentManager.getTest().log(LogStatus.INFO, "Step01_Open customer infor page");
//		customerInforPage = homePage.clickMyAccountLink();
//		verifyEquals(customerInforPage.getCustomerInforPageHeader(), "My account1 - Customer info");
//		
//		ExtentManager.getTest().log(LogStatus.INFO,"Step01_Open customer address page");
//		addressPage = customerInforPage.clickAddressLink(driver);
//		
//		ExtentManager.getTest().log(LogStatus.INFO,"Step02_Open customer infor page");
//		customerInforPage = addressPage.clickCustomerInfoLink(driver);
//		verifyEquals(customerInforPage.getCustomerInforPageHeader(), "My account2 - Customer info");
//		
//		ExtentManager.getTest().log(LogStatus.INFO,"Step03_Open reward point page");
//		rewardPointPage = customerInforPage.clickRewardPointLink(driver);
//		
//		ExtentManager.getTest().log(LogStatus.INFO,"Step04_Open customer infor page");
//		customerInforPage = rewardPointPage.clickCustomerInfoLink(driver);
//		ExtentManager.endTest();

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
