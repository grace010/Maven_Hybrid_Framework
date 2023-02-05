package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.By;
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

public class User_02_Login {
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
	  //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	 }

	 @Test
	 public void Login_TC_01_EmptyData() { 
	  driver.findElement(By.xpath("//a[@class= 'ico-login']")).click();
	  driver.findElement(By.xpath("//button[@class= 'button-1 login-button']")).click();
	  Assert.assertEquals(driver.findElement(By.xpath("//span[@id= 'Email-error']")).getText(), "Please enter your email");

	 }
	 
	 @Test
	 public void Login_TC_02_InvalidEmail() {
	  driver.findElement(By.xpath("//input[@id = 'Email']")).sendKeys("1234");
	  explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id ='Email-error']")));
	  Assert.assertEquals(driver.findElement(By.xpath("//span[@id ='Email-error']")).getText(), "Wrong email");

	 }
	 @Test
	 public void Login_TC_03_EmailNotRegister() {
	  WebElement emailAddress = driver.findElement(By.xpath("//input[@id = 'Email']"));
	  emailAddress.clear();
	  emailAddress.sendKeys("1234@gmail.com");
	  driver.findElement(By.xpath("//button[@class= 'button-1 login-button']")).click();
	  explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'message-error validation-summary-errors']")));
	  Assert.assertEquals(driver.findElement(By.xpath("//div[@class = 'message-error validation-summary-errors']")).getText(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");


	 }
	 @Test
	 public void Login_TC_04_BlankPassword() {
	  WebElement emailAddress = driver.findElement(By.xpath("//input[@id = 'Email']"));
	  emailAddress.clear();
	  emailAddress.sendKeys("tranyen261@gmail.com");
	  driver.findElement(By.xpath("//button[@class= 'button-1 login-button']")).click();
	  explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'message-error validation-summary-errors']")));
	  Assert.assertEquals(driver.findElement(By.xpath("//div[@class = 'message-error validation-summary-errors']")).getText(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	 }
	 
	 @Test
	 public void Login_TC_05_WrongPassword() {
	  WebElement emailAddress = driver.findElement(By.xpath("//input[@id = 'Email']"));
	  emailAddress.clear();
	  emailAddress.sendKeys("tranyen261@gmail.com");
	  driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("12345");
	  driver.findElement(By.xpath("//button[@class= 'button-1 login-button']")).click();
	  explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'message-error validation-summary-errors']")));
	  Assert.assertEquals(driver.findElement(By.xpath("//div[@class = 'message-error validation-summary-errors']")).getText(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	 }
	 
	 @Test
	 public void Login_TC_06_LoginSuccess() {
	  WebElement emailAddress = driver.findElement(By.xpath("//input[@id = 'Email']"));
	  emailAddress.clear();
	  emailAddress.sendKeys("tranyen261@gmail.com");
	  driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456");
	  driver.findElement(By.xpath("//button[@class= 'button-1 login-button']")).click();
	  Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/");
	 }
	 
	 
	 
	 public int random() {
	  Random rand = new Random();
	  return rand.nextInt(99999);
	 }

	 
	 @AfterClass
	 public void afterClass() {
	  //driver.quit();
	 }
}
