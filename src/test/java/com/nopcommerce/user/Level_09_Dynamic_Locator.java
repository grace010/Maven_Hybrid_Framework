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
import pageObjects.Nopcommerce.portal.UserRegisterPageObject;
import pageObjects.Nopcommerce.portal.UserRewardPointPageObject;

public class Level_09_Dynamic_Locator{
	String projectPath = System.getProperty("user.dir");
	WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserCustomerInfoPageObject customerInforPage;
	private UserAddressPageObject addressPage;
	private UserRewardPointPageObject rewardPointPage;
	
	
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
	}

	@Test
	public void User_02_MyAccount() {
		customerInforPage = homePage.clickMyAccountLink();
	}
	
	@Test
	public void User_03_Switch_Account() {
		//customer infor >> address
		addressPage = customerInforPage.clickAddressLink(driver);
		//address > customer info
		customerInforPage = addressPage.clickCustomerInfoLink(driver);
		//customer info > Reward point
		rewardPointPage = customerInforPage.clickRewardPointLink(driver);
		//Reward point > customer infor
		customerInforPage = rewardPointPage.clickCustomerInfoLink(driver);
		
	}
	
	@Test
	public void User_04_Dynamic_Page_01() {
		//customer infor >> address
		addressPage = (UserAddressPageObject) customerInforPage.switchMyAccountPage(driver, "Addresses");
		//address > customer info
		customerInforPage = (UserCustomerInfoPageObject) addressPage.switchMyAccountPage(driver, "Customer info");
		//customer info > Reward point
		rewardPointPage = (UserRewardPointPageObject) customerInforPage.switchMyAccountPage(driver, "Reward points");
		//Reward point > customer infor
		customerInforPage = (UserCustomerInfoPageObject) rewardPointPage.switchMyAccountPage(driver, "Customer info");
		
	}
	
	@Test
	public void User_04_Dynamic_Page_02() {
		//customer infor >> address
		customerInforPage.switchMyAccountPageName(driver, "Addresses");
		addressPage = PageGeneratorManager.getAddressPage(driver);
		
		//address > customer info
		addressPage.switchMyAccountPageName(driver, "Customer info");
		customerInforPage = PageGeneratorManager.getMyAccountPage(driver);
		
		//customer info > Reward point
		customerInforPage.switchMyAccountPageName(driver, "Reward points");
		rewardPointPage = PageGeneratorManager.getRewardPointPage(driver);
		
		//Reward point > customer infor
		rewardPointPage.switchMyAccountPageName(driver, "Customer info");
		customerInforPage = PageGeneratorManager.getMyAccountPage(driver);
		
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
