package com.nopcommerce.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class execise {
	String projectPath = System.getProperty("user.dir");
	WebDriver driver;
	WebDriverWait explicitWait;
	Select select;
	String emailAddress;
	BasePage basePage;

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/");
		explicitWait = new WebDriverWait(driver, 10);
		basePage = new BasePage();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public WebElement findElement(WebDriver driver, String locator) {
		 return driver.findElement(By.xpath(locator));
	}
	 
	public By findElement(String locator) {
		return By.xpath(locator);
	}

	public void clickToElement(WebDriver driver, String locator) {
		findElement(driver, locator).click();
	}






}
