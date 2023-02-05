package com.nopcommerce.user;

import java.util.Random;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;

public class Level_18_Pattern_Object extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		
	}
	
	@Test
	public void Post_01_Create_New_Post() {	
	}
	
	@Test
	public void Post_02_Search_Post() {	
	}
	
	
	@Test
	public void Post_02_View_Post() {	
	}
	
	@Test
	public void Post_04_Edit_Post() {	
	}
	
	
	public int random() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}
	
}
