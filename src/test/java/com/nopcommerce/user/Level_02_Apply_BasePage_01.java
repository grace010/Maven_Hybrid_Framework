package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_Apply_BasePage_01 {
	String projectPath = System.getProperty("user.dir");
	WebDriver driver;
	WebDriverWait explicitWait;
	Select select;
	String emailAddress;
	int rand = random();
	BasePage basePage;

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/");
		explicitWait = new WebDriverWait(driver, 10);
		emailAddress = rand + "@gmail.com";
		basePage = new BasePage();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	@Test
	public void Register_TC_01_EmptyData() {
		basePage.waitForAllElementClickable(driver, "//a[@class ='ico-register']");
		basePage.clickToElement(driver, "//a[@class ='ico-register']");

		basePage.waitForAllElementClickable(driver, "//button[@id = 'register-button']");
		basePage.clickToElement(driver, "//button[@id ='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id = 'FirstName-error']"),
				"First name is required.");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id ='LastName-error']"),
				"Last name is required.");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id = 'Email-error']"), "Email is required.");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id = 'Password-error']"),
				"Password is required.");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id = 'ConfirmPassword-error']"),
				"Password is required.");

	}

	@Test
	public void Register_TC_02_InvalidEmail() {
		basePage.waitForAllElementClickable(driver, "//a[@class ='ico-register']");
		basePage.clickToElement(driver, "//a[@class ='ico-register']");
		basePage.sendkeyToElement(driver, "//input[@id='Email']", "Email@@");
		
	//	WebElement emailInput = driver.findElement(By.xpath("//input[@id='Email']"));
		
		WebElement emailInput = basePage.getWebElement(driver, "//input[@id='Email']");
		emailInput.sendKeys(Keys.ENTER);
		
		
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='Email-error']")));
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='Email-error']")).getText(), "Wrong email");
	}

	@Test
	public void Register_TC_03_RegisterSuccess() {

		basePage.waitForAllElementClickable(driver, "//a[@class ='ico-register']");
		basePage.clickToElement(driver, "//a[@class ='ico-register']");
		
		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Grace");
		
		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "Tran");
	
		basePage.selectItembyDefaultDropdown(driver, "//select[@name = 'DateOfBirthDay']","26");
		
		basePage.selectItembyDefaultDropdown(driver, "//select[@name='DateOfBirthMonth']","1");

		basePage.selectItembyDefaultDropdown(driver, "//select[@name='DateOfBirthYear']","1995");

		basePage.sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		basePage.sendkeyToElement(driver, "//input[@id='Password']", "123456");
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']","123456");
			
		basePage.clickToElement(driver, "//button[@id ='register-button']");
		//driver.findElement(By.xpath("//input[@id='register-button']")).click();
		Assert.assertEquals(basePage.getElementText(driver, "//div[@class= 'result']"),"Your registration completed");
		
		//Assert.assertEquals(driver.findElement(By.xpath("//div[@class= 'result']")).getText(), "Your registration completed");
		
		basePage.clickToElement(driver, "//a[@class ='ico-logout']");
		//driver.findElement(By.xpath("//a[@class ='ico-logout']")).click();

	}

	@Test
	public void Register_TC_04_RegisterEmailExist() {
		basePage.waitForAllElementClickable(driver, "//a[@class ='ico-register']");
		basePage.clickToElement(driver, "//a[@class ='ico-register']");
		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Grace");
		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "Tran");
		basePage.selectItembyDefaultDropdown(driver, "//select[@name='DateOfBirthDay']", "26");
		basePage.selectItembyDefaultDropdown(driver, "//select[@name='DateOfBirthMonth']", "1");
		basePage.selectItembyDefaultDropdown(driver, "//select[@name='DateOfBirthYear']", "1995");
		basePage.sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		basePage.sendkeyToElement(driver, "//input[@id='Password']", "123456");
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		basePage.clickToElement(driver, "//button[@id ='register-button']");
		
		basePage.waitforElementVisible(driver, "//div[@class = 'message-error validation-summary-errors']//li");
		Assert.assertEquals(basePage.getElementText(driver, "//div[@class = 'message-error validation-summary-errors']//li"),"The specified email already exists");
	}

	@Test
	public void Register_TC_05_PasswordInvalid() {
		basePage.waitForAllElementClickable(driver, "//a[@class ='ico-register']");
		basePage.clickToElement(driver, "//a[@class ='ico-register']");
		basePage.sendkeyToElement(driver, "//input[@id='Password']", "1234");
		basePage.clickToElement(driver, "//button[@id ='register-button']");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id = 'Password-error']"),"Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void Register_TC_06_PasswordNotMatch() {
		
		basePage.waitForAllElementClickable(driver, "//a[@class ='ico-register']");
		basePage.clickToElement(driver, "//a[@class ='ico-register']");	
		basePage.sendkeyToElement(driver, "//input[@id='Password']", "123456");
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "12345");
		basePage.clickToElement(driver, "//button[@id ='register-button']");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"),"The password and confirmation password do not match.");

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
