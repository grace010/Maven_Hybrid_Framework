package com.facebook.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.facebook.LoginPageObject;
import pageObject.facebook.PageGeneratorManager;

public class Level_13_Verify_Element_Undisplayed extends BaseTest{
	String projectPath = System.getProperty("user.dir");
	WebDriver driver;
	LoginPageObject loginPage;
	
	@Parameters({"browser","url"})
	@BeforeClass 
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
	}

	@Test
	public void TC_01_Verify_Element_isDisplayed() {
		loginPage.clickToCreateNewAccount();
		loginPage.sleepInSection(2);
		verifyTrue(loginPage.verifyEmailAddressIsDisplayed());
			
	}

	@Test
	public void TC_02_Verify_Element_unDisplayed_In_Dom() {
//		loginPage.inputEmailAdress("abc@gmail.com");
//		loginPage.sleepInSection(2);
//		verifyFalse(loginPage.verifyConfirmEmailAddressUnDisplayed());
		loginPage.inputEmailAdress("");
		loginPage.sleepInSection(2);
		verifyTrue(loginPage.verifyConfirmEmailAddressUnDisplayed());
	}
	
	@Test
	public void TC_03_Verify_Element_unDisplay_Not_In_Dom() {
		loginPage.clickCloseIconAtRegisterForm();
		loginPage.sleepInSection(3);
		verifyTrue(loginPage.verifyConfirmEmailAddressUnDisplayed());
	}
	
	public void sleepInSection(long timeInSection) {
		try {
			Thread.sleep(timeInSection * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}
}
