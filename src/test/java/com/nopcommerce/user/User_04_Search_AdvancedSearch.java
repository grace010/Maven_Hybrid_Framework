package com.nopcommerce.user;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class User_04_Search_AdvancedSearch {
 String projectPath = System.getProperty("user.dir");
 WebDriver driver;
 WebDriverWait explicitWait;
 

 @BeforeClass
 public void beforeClass() { 
 
  System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
  driver = new FirefoxDriver();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  
  
 }
 @Test
 public void TC_03() {
  driver.get("https://demo.nopcommerce.com/login");
  driver.findElement(By.xpath("//input[@id = 'Email']")).sendKeys("tranyen261@gmail.com");
  driver.findElement(By.xpath("//input[@id = 'Password']")).sendKeys("123456");
  driver.findElement(By.xpath("//button[@class = 'button-1 login-button']")).click();
  driver.findElement(By.xpath("//a[text()='Search']")).click();
  driver.findElement(By.xpath("//input[@class = 'search-text']")).sendKeys("lenovo");
  driver.findElement(By.xpath("//button[@class = 'button-1 search-button']")).click();
  
  List<WebElement> searchResults = driver.findElements(By.xpath("//h2[@class ='product-title']"));
  
  for (WebElement searchItem : searchResults) {
   System.out.println(searchItem.getText());
 
   Assert.assertTrue(searchItem.getText().contains("Lenovo"));
  }
 }
  
 @Test
 public void TC_04() { 
  
  driver.get("https://demo.nopcommerce.com/login");
  driver.findElement(By.xpath("//input[@id = 'Email']")).sendKeys("tranyen261@gmail.com");
  driver.findElement(By.xpath("//input[@id = 'Password']")).sendKeys("123456");
  driver.findElement(By.xpath("//button[@class = 'button-1 login-button']")).click();
  driver.findElement(By.xpath("//a[text()='Search']")).click();
  driver.findElement(By.xpath("//input[@class = 'search-text']")).sendKeys("Thinkpad X1 Carbon");
  driver.findElement(By.xpath("//button[@class = 'button-1 search-button']")).click();
  
  List<WebElement> searchResults = driver.findElements(By.xpath("//h2[@class ='product-title']"));
  
  for (WebElement searchItem : searchResults) {
   System.out.println(searchItem.getText());
 
   Assert.assertTrue(searchItem.getText().contains("Thinkpad X1 Carbon"));
  }
  

 }

 @AfterClass
 public void afterClass() {
  //driver.quit();
 }
}
