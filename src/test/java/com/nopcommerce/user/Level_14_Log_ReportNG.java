package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
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

public class Level_14_Log_ReportNG extends BaseTest {
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
	public void User_01_Register() {
		log.info("Register_Step01_Open reigster page");
		registerPage = homePage.clickRegisterLink();
		
		log.info("Register_Step02_Enter to firstname textbox");
		registerPage.inputFirstNameTextBox("grace");
		
		log.info("Register_Step03_Enter to lastname textbox");
		registerPage.inputLastNameTextBox("tran");
		
		log.info("Register_Step04_Enter to email texbox is '"+emailAdressFake+ "'");
		registerPage.inputEmailTextBox(emailAdressFake);
		
		log.info("Register_Step05_Enter to password texbox");
		registerPage.inputPasswordTextBox("123456");
		
		log.info("Register_Step06_Enter to confirm password texbox");
		registerPage.inputConfirmPasswordTextBox("123456");
		
		log.info("Register_Step07_Click to Register button");
		registerPage.clickRegisterButton();
		
		log.info("Register_Step08_Verify Register success");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
	}
	
//	@Test
//	public void User_03_Switch_Account() {
//		log.info("Step01_Open customer infor page");
//		customerInforPage = homePage.clickMyAccountLink();
//		
//		log.info("Step01_Open customer address page");
//		addressPage = customerInforPage.clickAddressLink(driver);
//		
//		log.info("Step02_Open customer infor page");
//		customerInforPage = addressPage.clickCustomerInfoLink(driver);
//		
//		log.info("Step03_Open reward point page");
//		rewardPointPage = customerInforPage.clickRewardPointLink(driver);
//		
//		log.info("Step04_Open customer infor page");
//		customerInforPage = rewardPointPage.clickCustomerInfoLink(driver);
//
//	}

	
	public int random() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}
	
}
