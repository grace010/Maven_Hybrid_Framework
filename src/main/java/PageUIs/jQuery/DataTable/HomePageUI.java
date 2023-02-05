package PageUIs.jQuery.DataTable;

public class HomePageUI {
	public static final String DYNAMIC_PAGING_BY_NUMBER_LOCATOR = "xpath=//ul[@class='qgrd-pagination-ul']//a[text()='%s']";
	public static final String DYNAMIC_SEARCH_INPUT = "xpath=//div[text()='%s']/parent::div//following-sibling::input";
	public static final String DYNAMIC_PAGING_BY_NUMBER_IS_ACTIVE = "xpath=//ul[@class='qgrd-pagination-ul']//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String LIST_PAGING_NUMBER = "xpath=//li[@class='qgrd-pagination-page']";
	public static final String PAGING_PAGE_INDEX = "xpath=//li[@class='qgrd-pagination-page'][%s]/a";
	public static final String ROW_EACH_PAGE_INDEX = "xpath=//tbody//tr";
	
	public static final String COLUMN_INDEX = "xpath=//td[text()='%s']/preceding-sibling::td";
	public static final String COLUMN_ROW_INDEX_TEXTBOX = "xpath=//tbody/tr[%s]/td[%s]/input";
	
	public static final String DROP_DOWN_BUTTON = "xpath=//select[@id='tblAppendGrid_Origin_1']";
	public static final String COLUMN_ROW_INDEX_DROPDOWN = "xpath=//tbody/tr[%s]/td[%s]/select";
	
	public static final String CHECKBOX_BUTTON = "xpath=//input[@id='tblAppendGrid_Poster_1']";

}
