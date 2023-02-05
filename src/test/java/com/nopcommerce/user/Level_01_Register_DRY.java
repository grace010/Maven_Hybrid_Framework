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

public class Level_01_Register_DRY {
	String projectPath = System.getProperty("user.dir");
	WebDriver driver;
	WebDriverWait explicitWait;
	Select select;
	String emailAddress;
	int rand = random();

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/");
		explicitWait = new WebDriverWait(driver, 10);
		emailAddress = rand + "@gmail.com";
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void Register_TC_01_EmptyData() {
		
		driver.findElement(By.xpath("//a[@class ='ico-register']")).click();
		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("span#FirstName-error")).getText(),
				"First name is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#LastName-error")).getText(),
				"Last name is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Email is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(),
				"Password is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(),
				"Password is required.");
	}

	@Test
	public void Register_TC_02_InvalidEmail() {
		driver.findElement(By.xpath("//a[@class ='ico-register']")).click();
		WebElement emailInput = driver.findElement(By.cssSelector("input#Email"));
		emailInput.sendKeys("Email@@");
		emailInput.sendKeys(Keys.ENTER);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span#Email-error")));
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Wrong email");
	}

	@Test
	public void Register_TC_03_RegisterSuccess() {

		driver.findElement(By.xpath("//a[@class ='ico-register']")).click();
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Grace");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Tran");
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
		select.selectByVisibleText("26");
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
		select.selectByVisibleText("January");
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
		select.selectByVisibleText("1995");
		driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");
		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");
		driver.findElement(By.xpath("//a[@class ='ico-logout']")).click();

	}

	@Test
	public void Register_TC_04_RegisterEmailExist() {
		driver.findElement(By.xpath("//a[@class ='ico-register']")).click();
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Grace");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Tran");
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
		select.selectByVisibleText("26");
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
		select.selectByVisibleText("January");
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
		select.selectByVisibleText("1995");
		driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");
		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//li[text()='The specified email already exists']")).getText(),
				"The specified email already exists");

	}

	@Test
	public void Register_TC_05_PasswordInvalid() {
		driver.findElement(By.xpath("//a[@class ='ico-register']")).click();
		driver.findElement(By.cssSelector("input#Password")).sendKeys("1234");
		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id = 'Password-error']")).getText(),
				"Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void Register_TC_06_PasswordNotMatch() {
		driver.findElement(By.xpath("//a[@class ='ico-register']")).click();
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("12345");
		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(),
				"The password and confirmation password do not match.");

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


