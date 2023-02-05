package com.nopcommerce.user;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.SauceLab.LoginPageObject;
import pageObject.SauceLab.PageGeneratorManger;
import pageObject.SauceLab.ProductPageObject;

public class Level_19_Sort_ASC_DESC extends BaseTest {
	private LoginPageObject loginPage;
	private ProductPageObject productPage;

	@Parameters({ "browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl) {
		driver = getBrowserDriver(browserName, adminUrl);
		loginPage = PageGeneratorManger.getLoginPage(driver);
		loginPage.enterUserName("standard_user");
		loginPage.enterPassword("secret_sauce");
		productPage=loginPage.clickToLoginButton();
		
	}
	
	@Test
	public void Sort_01_Name_ASC() {
		productPage.Sort_ASC("Name (A to Z)");
		sleepInSection(3);
	}
	
	@Test
	public void Sort_03_Price_ASC() {	
		productPage.Sort_DESC("Name (Z to A)");
		sleepInSection(3);
	}
	
	@Test
	public void Sort_04_Price_DESC() {
		productPage.Sort_ASC("Name (A to Z)");
		sleepInSection(3);
	}
	
	@Test
	public void Sort_02_Name_DESC() {	
		productPage.Sort_DESC("Name (Z to A)");
		sleepInSection(3);
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}
	
}
