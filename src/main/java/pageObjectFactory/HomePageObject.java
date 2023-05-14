package pageObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class HomePageObject extends BasePageFactory {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(how =How.XPATH, using = "//a[@class ='ico-register']")// cach1
	private WebElement registerLink;
	@FindBy(xpath = "//a[@class= 'ico-login']")//cach2
	private WebElement loginLink;

	public void clickRegisterLink() {
		waitForAllElemetClickable(driver, registerLink);
		clickToElement(driver, registerLink);
	}

	public void clickLoginLink() {
		waitForAllElemetClickable(driver, loginLink);
		clickToElement(driver, loginLink);
	}

}