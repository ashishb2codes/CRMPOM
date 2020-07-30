package codes.pom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import codes.pom.base.BaseMain;

public class NopComHomePage extends BaseMain{
		
	//@FindBy(xpath = "//span[text()='Customers']")
	@FindBy(linkText = "Customers")
	WebElement customerMain;
	
	@FindBy(xpath = "//span[text()='Customers' and @class='menu-item-title']")
	WebElement customerList;
	
	//Initialize Elements
	public NopComHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public NopComCustomerPage clickOnCustomerList() {
		customerMain.click();
		customerList.click();
		return new NopComCustomerPage();
	}

}
