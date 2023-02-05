package com.jQuery.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.jQuery.UploadFile.HomePageObject;
import pageObject.jQuery.UploadFile.PageGeneratorManager;



public class Level_11_Upload_Files{
	String projectPath = System.getProperty("user.dir");
	WebDriver driver;
	HomePageObject homePage;
	String image1 = "george-dagerotip-6bpoqWiTosw-unsplash.jpg";
	String image2 = "graham-mansfield-H3PMkHn-DNY-unsplash.jpg";
	String image3 = "natalya-letunova-HEFTxQx07Yw-unsplash.jpg";
	
	String[] multipleFiles = {image1, image2, image3};
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void TC_01_Upload_One_File() {
		homePage.uploadMutipleFiles(driver, image1);
		Assert.assertTrue(homePage.VerifyFileUpload(image1));
		homePage.clickToStartButton();
		Assert.assertTrue(homePage.VerifyFileUploadedLink(image1));
		Assert.assertTrue(homePage.VerifyFileUploadedImage(image1));
	}
	
	@Test 
	public void TC_02_Upload_Multiple_Files() {
		homePage.uploadMutipleFiles(driver, multipleFiles);
		Assert.assertTrue(homePage.VerifyFileUpload(multipleFiles));
		homePage.clickToStartButton();
		Assert.assertTrue(homePage.VerifyFileUploadedLink(multipleFiles));
		Assert.assertTrue(homePage.VerifyFileUploadedImage(multipleFiles));	
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
