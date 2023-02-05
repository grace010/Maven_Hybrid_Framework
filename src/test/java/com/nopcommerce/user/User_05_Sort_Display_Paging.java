package com.nopcommerce.user;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class User_05_Sort_Display_Paging {
 String projectPath = System.getProperty("user.dir");
 WebDriver driver;
 WebDriverWait explicitWait;
 Actions action;
 Select select;
 JavascriptExecutor jsExecutor;
 

 @BeforeClass
 public void beforeClass() {
 
  System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
  driver = new ChromeDriver();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  action = new Actions(driver);
  jsExecutor =  (JavascriptExecutor) driver;
  explicitWait = new WebDriverWait(driver, 10);
  
 }
 
// @Test
// public void TC_01_Sort_AtoZ() { 
//  driver.get("https://demo.nopcommerce.com/");
//  action.moveToElement(driver.findElement(By.xpath("//ul[@class = 'top-menu notmobile']//a[text()='Computers ']"))).perform();
//  driver.findElement(By.xpath("//ul[@class = 'top-menu notmobile']//a[text()='Notebooks ']")).click();
//  select = new Select(driver.findElement(By.xpath("//select[@id = 'products-orderby']")));
//  select.selectByVisibleText("Name: A to Z");
//  sleepInSection(2);
//  ArrayList<String> sortList = new ArrayList<String>();
//  ArrayList<String> sortExpected = new ArrayList<String>();
//
//  //explicitWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//h2[@class ='product-title']"))));
//  List<WebElement> sortItem = driver.findElements(By.xpath("//h2[@class ='product-title']//a"));
//  //System.out.println(sortItem.size());
//  for (WebElement webElementName : sortItem) {
//   String item = webElementName.getText();
//   sortList.add(item); 
//   sortExpected.add(item);
//  }
//  
//  Collections.sort(sortExpected);
//  Assert.assertEquals(sortList, sortExpected);
// }
// @Test
// public void TC_03_Sort_LowToHigh() { 
//  driver.get("https://demo.nopcommerce.com/");
//  action.moveToElement(driver.findElement(By.xpath("//ul[@class = 'top-menu notmobile']//a[text()='Computers ']"))).perform();
//  driver.findElement(By.xpath("//ul[@class = 'top-menu notmobile']//a[text()='Notebooks ']")).click();
//  select = new Select(driver.findElement(By.xpath("//select[@id = 'products-orderby']")));
//  select.selectByVisibleText("Price: Low to High");
//  sleepInSection(2);
//  ArrayList<String> sortList = new ArrayList<String>();
//  ArrayList<String> sortExpected = new ArrayList<String>();
//
//  //explicitWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//h2[@class ='product-title']"))));
//  List<WebElement> sortItem = driver.findElements(By.xpath("//span[@class ='price actual-price']"));
//  //System.out.println(sortItem.size());
//  for (WebElement webElementName : sortItem) {
//   String item = webElementName.getText();
//   sortList.add(item); 
//   sortExpected.add(item);
//  }
//  
//  Collections.sort(sortExpected);
//  Assert.assertEquals(sortList, sortExpected);
//  
// }
// @Test
// public void TC_04_Sort_HighToLow() {
//  driver.get("https://demo.nopcommerce.com/");
//  action.moveToElement(driver.findElement(By.xpath("//ul[@class = 'top-menu notmobile']//a[text()='Computers ']"))).perform();
//  driver.findElement(By.xpath("//ul[@class = 'top-menu notmobile']//a[text()='Notebooks ']")).click();
//  select = new Select(driver.findElement(By.xpath("//select[@id = 'products-orderby']")));
//  select.selectByVisibleText("Price: High to Low");
//  sleepInSection(2);
//  ArrayList<String> sortList = new ArrayList<String>();
//  ArrayList<String> sortExpected = new ArrayList<String>();
//
//  //explicitWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//h2[@class ='product-title']"))));
//  List<WebElement> sortItem = driver.findElements(By.xpath("//span[@class ='price actual-price']"));
//  //System.out.println(sortItem.size());
//  for (WebElement webElementName : sortItem) {
//   String item = webElementName.getText();
//   sortList.add(item); 
//   sortExpected.add(item);
//  }
//  
//  Collections.sort(sortExpected,Collections.reverseOrder());
//  Assert.assertEquals(sortList, sortExpected);
// }
// @Test
// public void TC_05_Sort_PagingWith_03_Item() {
//  driver.get("https://demo.nopcommerce.com/");
//  action.moveToElement(driver.findElement(By.xpath("//ul[@class = 'top-menu notmobile']//a[text()='Computers ']"))).perform();
//  driver.findElement(By.xpath("//ul[@class = 'top-menu notmobile']//a[text()='Notebooks ']")).click();
//  select = new Select(driver.findElement(By.xpath("//select[@id ='products-pagesize']")));
//  select.selectByVisibleText("3");
//  sleepInSection(2);
//  List<WebElement> sortItem = driver.findElements(By.xpath("//select[@id = 'products-pagesize']//option"));
//  int sizeNumber = sortItem.size();
//  //System.out.println(sortItem.size());
//  
//  Assert.assertTrue(sizeNumber <= 3);
//  Assert.assertEquals(driver.findElement(By.xpath("//li[@class='next-page']/a")).getText(), "Next");
//  driver.findElement(By.xpath("//a[text()='Next']")).click();
//  Assert.assertEquals(driver.findElement(By.xpath("//li[@class='previous-page']/a")).getText(), "Previous");
//
//  
// }
 
// @Test
// public void TC_06_Sort_PagingWith_03_Item() {
//  driver.get("https://demo.nopcommerce.com/");
//  action.moveToElement(driver.findElement(By.xpath("//ul[@class = 'top-menu notmobile']//a[text()='Computers ']"))).perform();
//  driver.findElement(By.xpath("//ul[@class = 'top-menu notmobile']//a[text()='Notebooks ']")).click();
//  select = new Select(driver.findElement(By.xpath("//select[@id ='products-pagesize']")));
//  select.selectByVisibleText("6");
//  sleepInSection(2);
//  List<WebElement> sortItem = driver.findElements(By.xpath("//select[@id = 'products-pagesize']//option"));
//  int sizeNumber = sortItem.size();
//  //System.out.println(sortItem.size());
//  
//  Assert.assertTrue(sizeNumber <= 6);
//  // Assert.assertFalse(driver.findElement(By.xpath("//div[@class='pager']")).isDisplayed());
//  explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='pager']")));
//  
// }
 
 @Test
 public void TC_07_Sort_PagingWith_03_Item() {
  driver.get("https://demo.nopcommerce.com/");
  action.moveToElement(driver.findElement(By.xpath("//ul[@class = 'top-menu notmobile']//a[text()='Computers ']"))).perform();
  driver.findElement(By.xpath("//ul[@class = 'top-menu notmobile']//a[text()='Notebooks ']")).click();
  select = new Select(driver.findElement(By.xpath("//select[@id ='products-pagesize']")));
  select.selectByVisibleText("9");
  sleepInSection(2);
  List<WebElement> sortItem = driver.findElements(By.xpath("//select[@id = 'products-pagesize']//option"));
  int sizeNumber = sortItem.size();
  //System.out.println(sortItem.size());
  Assert.assertTrue(sizeNumber <= 9);
  // Assert.assertFalse(driver.findElement(By.xpath("//div[@class='pager']")).isDisplayed());
  explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='pager']")));
  
 }
 
 @AfterClass
 public void afterClass() {
  driver.quit();
 }
  public void sleepInSection(long timeInSection){
         try {
             Thread.sleep(timeInSection*1000);
        }catch(InterruptedException e)
         {
             e.printStackTrace();
         }    
     }
}
