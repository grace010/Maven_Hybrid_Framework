package pageObject.SauceLab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import PageUIs.saucelab.ProductPageUI;
import commons.BasePage;

public class ProductPageObject extends BasePage {
	WebDriver driver;
	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean Sort_ASC(String dropDownValue) {
		ArrayList<String> sortListBefore = new ArrayList<String>();
		ArrayList<String> sortUIExpected = new ArrayList<String>();
		waitforElementVisible(driver, ProductPageUI.PRODUCT_DROP_DOWN);
		selectItembyDefaultDropdown(driver, ProductPageUI.PRODUCT_DROP_DOWN, dropDownValue);
		List<WebElement> elements = getListWebElement(driver, ProductPageUI.PRODUCT_NAME_LIST);
		for (WebElement text : elements) {
			String listItem = text.getText();
			sortListBefore.add(listItem);
			sortUIExpected.add(listItem);
			System.out.println(listItem);
		}
		Collections.sort(sortUIExpected);
		
		for (String sortlist : sortUIExpected) {
			System.out.println(sortlist);
			
		}
		return sortListBefore.equals(sortUIExpected);
	}
	
	public boolean Sort_DESC(String dropDownValue) {
		ArrayList<String> sortListBefore = new ArrayList<String>();
		ArrayList<String> sortUIExpected = new ArrayList<String>();
		waitforElementVisible(driver, ProductPageUI.PRODUCT_DROP_DOWN);
		selectItembyDefaultDropdown(driver, ProductPageUI.PRODUCT_DROP_DOWN, dropDownValue);
		List<WebElement> elements = getListWebElement(driver, ProductPageUI.PRODUCT_NAME_LIST);
		for (WebElement text : elements) {
			String listItem = text.getText();
			sortListBefore.add(listItem);
			sortUIExpected.add(listItem);
			System.out.println(listItem);
		}
		Collections.sort(sortUIExpected, Collections.reverseOrder());
		
		for (String sortlist : sortUIExpected) {
			System.out.println(sortlist);
			
		}
		return sortListBefore.equals(sortUIExpected);
	}
	
}
