package codes.pom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import codes.pom.base.BaseMain;

public class HomePage extends BaseMain{
	
	//HomePage Objects
	@FindBy(xpath = "//span[@class='user-display' and contains(text(),'Ashish B')]")
	WebElement loggedUser;
	
	@FindBy(xpath = "//a[@href='/calendar']")
	WebElement linkCalender;
	
	@FindBy(xpath = "//a[@href='/deals']")
	WebElement linkDeals;
	
	@FindBy(xpath = "//a[@href='/tasks']")
	WebElement linkTasks;
	
	@FindBy(xpath = "//a[@href='/contacts']")
	WebElement linkContacts;
	
	
	//Initialize Home page elements
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Page Actions
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyUserName() {
		return loggedUser.isDisplayed();
	}
	
	public CalendarPage clickOnCalender() {
		linkCalender.click();
		return new CalendarPage();
	}
	
	public DealsPage clickOnDeals() {
		linkDeals.click();
		return new DealsPage();
	}
	
	public ContactsPage clickOnContacts() {
		linkContacts.click();
		return new ContactsPage();
	}
	
	public TasksPage clickOnTasks() {
		linkTasks.click();
		return new TasksPage();
	}
	
}
