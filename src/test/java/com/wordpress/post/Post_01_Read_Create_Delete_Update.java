package com.wordpress.post;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.Wordpress.AdminDashboardPO;
import pageObjects.Wordpress.AdminLoginPO;
import pageObjects.Wordpress.AdminPostSeachPO;
import pageObjects.Wordpress.PageGeneratorManager;

public class Post_01_Read_Create_Delete_Update extends BaseTest{
	private String adminUsername = "automationfc";
	private String adminPassword = "Yen12345!";
	private String SearchValue = "Blackpink";
	private String SearchPostUrl;
	private AdminLoginPO AdminLoginPage;
	private AdminDashboardPO AdminDashboardPage;
	private AdminPostSeachPO AdminPostSeachPage;
	
	


	@Parameters({ "browser", "url"})
	@BeforeClass 
	public void beforeClass(String browserName, String adminUrl) {
		driver = getBrowserDriver(browserName, adminUrl);
		log.info("Pre - Step_01: Input username into Admin login page");
		AdminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		AdminLoginPage.inputAdminUserName(adminUsername);
		
		log.info("Pre - Step_02: Input password into Admin login page");
		AdminLoginPage.inputAdminPassword(adminPassword);
		
		log.info("Pre - Step_03: Click to into Admin login page");
		AdminDashboardPage = AdminLoginPage.clickToLoginButton();
	}

	@Test
	public void Post_01_Search() {
		log.info("Click to Post menu link" );
		AdminPostSeachPage = AdminDashboardPage.clickToPostMenuLink();
		
//		log.info("Open Post Search Page " );
//		SearchPostUrl = AdminPostSeachPage.getCurrentUrl(driver);
		
		log.info("Input value into Post Search box " );
		AdminPostSeachPage.inputSearchValue(SearchValue);
		
		log.info("Click to Search Posts button " );
		AdminPostSeachPage.clickToSearchPostButton();
		
		log.info("Verify title and list search in search page " );
		verifyTrue(AdminPostSeachPage.getSearchTitle(SearchValue));
		
	}
	
	
	@Test
	public void Post_02_Delete_One_Post() {
		
		
	}
	
	@Test
	public void Post_03_Delete_Multi_Post() {
		
		
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}


}
