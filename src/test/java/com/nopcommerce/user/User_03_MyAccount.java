package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class User_03_MyAccount {
 
  
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
	  explicitWait = new WebDriverWait(driver, 10);
	  driver.get("https://demo.nopcommerce.com/");
	  
	  
	 }

	 @Test
	 public void Login_TC_01_CustomerUpdate() { 
	  driver.findElement(By.xpath("//a[@class ='ico-login']")).click();
	  WebElement emailAddress = driver.findElement(By.xpath("//input[@id = 'Email']"));
	  emailAddress.clear();
	  emailAddress.sendKeys("automationfc.vn@gmail.com");
	  driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456");
	  driver.findElement(By.xpath("//button[@class= 'button-1 login-button']")).click();
	  driver.findElement(By.xpath("//a[@class = 'ico-account']")).click();
	  driver.findElement(By.xpath("//input[@id='gender-female']")).click();
	  WebElement editFirstname =driver.findElement(By.xpath("//input[@id='FirstName']"));
	  editFirstname.clear();
	  editFirstname.sendKeys("Automation");
	  WebElement editLastname =driver.findElement(By.xpath("//input[@id='LastName']"));
	  editLastname.clear();
	  editLastname.sendKeys("FC");
	  select =new Select(driver.findElement(By.xpath("//select[@name ='DateOfBirthDay']")));
	  select.selectByVisibleText("1");
	  select =new Select(driver.findElement(By.xpath("//select[@name ='DateOfBirthMonth']")));
	  select.selectByVisibleText("January");
	  select =new Select(driver.findElement(By.xpath("//select[@name ='DateOfBirthYear']")));
	  select.selectByVisibleText("1999");
	  WebElement editEmailAddress =driver.findElement(By.xpath("//input[@id='Email']"));
	  editEmailAddress.clear();
	  editEmailAddress.sendKeys("automationfc.vn@gmail.com");
	  WebElement editCompany =driver.findElement(By.xpath("//input[@id='Company']"));
	  editCompany.clear();
	  editCompany.sendKeys("Automation FC");
	  driver.findElement(By.xpath("//button[@id='save-info-button']")).click();
	  
	  
	  Assert.assertEquals(driver.findElement(By.xpath("//input[@id='FirstName']")).getAttribute("value"),"Automation");
	  Assert.assertEquals(driver.findElement(By.xpath("//input[@id='LastName']")).getAttribute("value"), "FC");
	  
	  select = new Select(driver.findElement(By.xpath("//select[@name ='DateOfBirthDay']")));
	  Assert.assertEquals(select.getFirstSelectedOption().getText(),"1");
	  
	  select = new Select(driver.findElement(By.xpath("//select[@name ='DateOfBirthMonth']")));
	  Assert.assertEquals(select.getFirstSelectedOption().getText(),"January");
	  
	  select = new Select(driver.findElement(By.xpath("//select[@name ='DateOfBirthYear']")));
	  Assert.assertEquals(select.getFirstSelectedOption().getText(),"1999");
	  
	  Assert.assertEquals(driver.findElement(By.xpath("//input[@id='Email']")).getAttribute("value"), "automationfc.vn@gmail.com");
	  Assert.assertEquals(driver.findElement(By.xpath("//input[@id='Company']")).getAttribute("value"), "Automation FC");

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
