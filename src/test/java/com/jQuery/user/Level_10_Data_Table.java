package com.jQuery.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.jQuery.DataTable.HomePageObject;
import pageObject.jQuery.DataTable.PageGeneratorManager;

public class Level_10_Data_Table{
	String projectPath = System.getProperty("user.dir");
	WebDriver driver;
	HomePageObject homePage;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		//driver.get("https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/");
		driver.get("https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

//	@Test
	public void TC01_Open_Paging_By_Number() {
		homePage.openPagingByNumber("10");
		homePage.isPagingNumberActive("10");
		
		homePage.openPagingByNumber("18");
		homePage.isPagingNumberActive("18");
		
		homePage.openPagingByNumber("20");	
		homePage.isPagingNumberActive("20");
	}
	
//	@Test
	public void TC02_SearchByLableName() {
		homePage.refreshCurrentPage(driver);
		homePage.searchByNameToHeader("Females","384187");
		homePage.searchByNameToHeader("Country","Afghanistan");
		homePage.searchByNameToHeader("Males","651");
		homePage.searchByNameToHeader("Total","791312");
		
	}
	
	//@Test
	public void TC04_clickToAllPagingNumber() {
		homePage.clickToAllPagingNumber();
	}
	
	@Test 
	public void TC_05_inputDataIntoRow() {
		homePage.inputToTextBox("Album","1", "Yen0");
		sleepInSection(1);
		homePage.inputToTextBox("Artist","1", "Yen1");
		sleepInSection(1);
		homePage.inputToTextBox("Year","1", "Yen1");
		sleepInSection(1);
		homePage.inputToTextBox("Price","1", "Yen1");
		sleepInSection(1);
		homePage.selectItemInDropDown("Origin","1", "Japan");
		sleepInSection(1);
		homePage.clickToCheckbox("With Poster?","1");
	}
	
	
	public void sleepInSection(long timeInSection){
        try {
            Thread.sleep(timeInSection*1000);
       }catch(InterruptedException e)
        {
            e.printStackTrace();
        }    
    }
	
	@AfterClass
	public void afterClass() {
		// driver.quit();
	}
}
