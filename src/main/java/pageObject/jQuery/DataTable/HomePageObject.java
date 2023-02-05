package pageObject.jQuery.DataTable;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageUIs.jQuery.DataTable.HomePageUI;
import commons.BasePage;


public class HomePageObject extends BasePage{
	private WebDriver driver;
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void openPagingByNumber(String pageName) {
		waitForAllElementClickable(driver, HomePageUI.DYNAMIC_PAGING_BY_NUMBER_LOCATOR, pageName );
		clickToElement(driver, HomePageUI.DYNAMIC_PAGING_BY_NUMBER_LOCATOR, pageName);
	}
	
	public void searchByNameToHeader(String headerName, String value) {
		waitForAllElementClickable(driver, HomePageUI.DYNAMIC_SEARCH_INPUT,headerName);
		sendkeyToElement(driver, HomePageUI.DYNAMIC_SEARCH_INPUT, value, headerName);
		pressKeyToElement(driver, HomePageUI.DYNAMIC_SEARCH_INPUT, Keys.ENTER, headerName);
	}
	
	public int getListPagingbyNumber() {
		waitForAllElementClickable(driver, HomePageUI.LIST_PAGING_NUMBER);
		return getElementSize(driver, HomePageUI.LIST_PAGING_NUMBER);
	}
	
	public void clickToAllPagingNumber() {
		List<String> listDataByEachPage = new ArrayList<String>();
		for (int i = 1; i <= getListPagingbyNumber(); i++) {
			clickToElement(driver, HomePageUI.PAGING_PAGE_INDEX, String.valueOf(i));
			List<WebElement> allRowElementEachPage = getListWebElement(driver, HomePageUI.ROW_EACH_PAGE_INDEX);
			for (WebElement eachRow : allRowElementEachPage) {
				listDataByEachPage.add(eachRow.getText());
			}
		}
		
		for (String value : listDataByEachPage) {
			System.out.println(value);
		}
	}
		
	
	public boolean isPagingNumberActive(String pageName) {
		waitforElementVisible(driver,HomePageUI.DYNAMIC_PAGING_BY_NUMBER_LOCATOR, pageName);
		return isElementDisplay(driver,HomePageUI.DYNAMIC_PAGING_BY_NUMBER_LOCATOR, pageName);
	}
	
	public void inputToTextBox(String ColumnName, String RowIndex, String valueIntoTextBox) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX, ColumnName) + 1;
		waitForAllElementVisible(driver, HomePageUI.COLUMN_ROW_INDEX_TEXTBOX, RowIndex,String.valueOf(columnIndex));
		sendkeyToElement(driver, HomePageUI.COLUMN_ROW_INDEX_TEXTBOX, valueIntoTextBox, RowIndex,String.valueOf(columnIndex));
	}
	
	public void selectItemInDropDown(String ColumnName, String RowIndex, String dropDownValue) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX, ColumnName) + 1;
		waitForAllElementClickable(driver, HomePageUI.COLUMN_ROW_INDEX_DROPDOWN, RowIndex, String.valueOf(columnIndex));
		selectItembyDefaultDropdown(driver, HomePageUI.COLUMN_ROW_INDEX_DROPDOWN, dropDownValue, RowIndex, String.valueOf(columnIndex));
	}
	
	public void clickToCheckbox(String ColumnName, String RowIndex) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX, ColumnName) + 1;
		waitForAllElementClickable(driver, HomePageUI.COLUMN_ROW_INDEX_TEXTBOX, RowIndex,String.valueOf(columnIndex));
		checkTodefaultCheckbox(driver, HomePageUI.COLUMN_ROW_INDEX_TEXTBOX, RowIndex,String.valueOf(columnIndex));
	}

	
} 
