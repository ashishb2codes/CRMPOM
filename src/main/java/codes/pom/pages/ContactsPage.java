package codes.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import codes.pom.base.BaseMain;

public class ContactsPage extends BaseMain{
	
	// ContactsPage Objects
	@FindBy(xpath = "//div[text()='Contacts']")
	WebElement lblContacts;
	
	@FindBy(how = How.XPATH, using = "//button[@class='ui linkedin button' and text()='New']")
	WebElement newContact;
	
	@FindBy(how = How.NAME, using = "first_name")
	WebElement firstName;
	
	@FindBy(name = "last_name")
	WebElement lastName;
	
	@FindBy(name = "company")
	WebElement company;
	
	//@FindBy(name = "category") WebElement category;
	
	@FindBy(xpath = "//div[@class='item']//child::button[@class='ui linkedin button']")
	WebElement btnSaveContact;
	
	
	//Initialize objects
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Page Actions
	public boolean verifyContactsPage() {
		return lblContacts.isDisplayed();
	}
	
	public void selectContactName(String contactName) {
		
		//Not loading Contact Name, thus skipped for sometime and will try later
		//driver.findElement(By.xpath("//input[@type='checkbox']//following::td[text()='" + contactName + "']")).click();
		driver.findElement(By.xpath("//div[@class='ui fitted read-only checkbox']")).click();
	}
	
	public void createNewContact(String firstName, String lastName, String company, String category) {
		Actions action = new Actions(driver);
		action.moveToElement(newContact).build().perform();
		action.click();
		//newContact.click();			// We can perform this activity just by clicking on newContact. Because this is not mousehover
		
		WebElement dropdownCategory = driver.findElement(By.name("category"));
		wait.until(ExpectedConditions.visibilityOf(dropdownCategory));
		wait.until(ExpectedConditions.elementToBeClickable(dropdownCategory));
		Select select = new Select(dropdownCategory);
		select.selectByVisibleText(category);
		
		this.firstName.sendKeys(firstName);
		this.lastName.sendKeys(lastName);
		this.company.sendKeys(company);
		
		btnSaveContact.click();
	}
}
