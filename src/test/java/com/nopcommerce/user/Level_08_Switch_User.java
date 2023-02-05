package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.Nopcommerce.admin.AdminDashboardPageObject;
import pageObjects.Nopcommerce.admin.AdminLoginPageObject;
import pageObjects.Nopcommerce.portal.UserHomePageObject;
import pageObjects.Nopcommerce.portal.UserLoginPageObject;
import pageObjects.Nopcommerce.portal.UserRegisterPageObject;

public class Level_08_Switch_User{
	String projectPath = System.getProperty("user.dir");
	WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage; 
	private UserRegisterPageObject userRegisterPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminHomePage;
	private String adminLoginEmailAdress = "admin@yourstore.com";
	private String adminLoginPassword = "admin";

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
		userHomePage = PageGeneratorManager.getHomePage(driver);

		userRegisterPage = userHomePage.clickRegisterLink();
		userRegisterPage.inputFirstNameTextBox("grace");

		userRegisterPage.inputLastNameTextBox("tran");

		userRegisterPage.inputEmailTextBox(emailAdressFake);

		userRegisterPage.inputPasswordTextBox("123456");

		userRegisterPage.inputConfirmPasswordTextBox("123456");

		userRegisterPage.clickRegisterButton();

		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");
		userHomePage = userRegisterPage.clickToLogoutLink();
	}

	@Test
	public void User_02_Login() {
		userLoginPage = userHomePage.clickLoginLink();
		userHomePage = userLoginPage.loginAsUser(emailAdressFake, "123456");
		//Assert.assertEquals(loginPage.getLoginUrl(),"https://demo.nopcommerce.com/");
	}
	
	@Test
	public void User_04_Switch_To_Admin() {
		userHomePage.openPageURL(driver, GlobalConstants.ADMIN_PAGE_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		adminHomePage = adminLoginPage.loginAsAdmin(adminLoginEmailAdress, adminLoginPassword);

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
