package codes.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import codes.pom.base.BaseMain;

public class NopComCustomerPage extends BaseMain{

	//Page Objects - Customer List

	@FindBy(id = "SearchFirstName") WebElement firstName;

	@FindBy(id = "SearchLastName") WebElement lastName;

	@FindBy(id = "search-customers") WebElement btnSearch;
	
	// Page Objects - New Customer Creation
	@FindBy(linkText = "Add new") WebElement nlinkAddNewCustomer;
	@FindBy(id = "Email") WebElement nEmail;
	@FindBy(id = "FirstName") WebElement nFirstName;
	@FindBy(id = "LastName") WebElement nLastName;
	@FindBy(id = "VendorId") WebElement nVendorID;
	@FindBy(xpath = "//input[@name='Gender' and @value='M']") WebElement nGenderMale;
	@FindBy(xpath = "//input[@name='Gender' and @value='F']") WebElement nGenderFemale;
	@FindBy(name = "save") WebElement nbtnSave;
	@FindBy(name = "save-continue") WebElement nbtnSaveContinue;

	//Initialize elements
	public NopComCustomerPage() {
		PageFactory.initElements(driver, this);
	}

	//Actions
	public void selectCustomer(String customerName) {
		WebElement custCheckbox = driver.findElement(By.xpath("//td[contains(text(),'" + customerName + "')]//preceding-sibling::td//input[@name='checkbox_customers']"));
		custCheckbox.click();
		Assert.assertTrue(custCheckbox.isSelected(), "Checkbox not found");
	}

	public void searchCustomer() {
		btnSearch.click();
	}
	
	public void addNewCustomer(String email, String fname, String lname, String vendor, String gender) {
		nlinkAddNewCustomer.click();
		nEmail.sendKeys(email);
		nFirstName.sendKeys(fname);
		nLastName.sendKeys(lname);
		
		if(gender=="M") {
			nGenderMale.click();
		} else if (gender=="F") {
			nGenderFemale.click();
		}
		
		Select select = new Select(nVendorID);
		select.selectByVisibleText(vendor);
		nbtnSave.click();
	}

}
