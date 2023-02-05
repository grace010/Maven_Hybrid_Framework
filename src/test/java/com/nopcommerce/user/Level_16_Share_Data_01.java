package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_Register_Cookie;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.Nopcommerce.portal.UserHomePageObject;
import pageObjects.Nopcommerce.portal.UserLoginPageObject;

public class Level_16_Share_Data_01 extends BaseTest {
	WebDriver driver;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		emailAdress = Common_Register_Cookie.emailAdressFake;
		password = Common_Register_Cookie.password;
		loginPage = homePage.clickLoginLink();
		loginPage.inputEmailTextbox(emailAdress);
		loginPage.inputPasswordTextbox(password);
		homePage = loginPage.clickLoginButton();
	}

	@Test
	public void User_01_Search_Relative() {	
	}
	
	@Test
	public void User_01_Search_Absolute() {
	}

	
	public int random() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}
	private String emailAdress;
	private String password;
}
