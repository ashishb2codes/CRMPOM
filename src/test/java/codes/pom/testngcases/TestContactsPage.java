package codes.pom.testngcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import codes.pom.base.BaseMain;
import codes.pom.pages.ContactsPage;
import codes.pom.pages.HomePage;
import codes.pom.pages.LoginPage;
import codes.pom.util.Util;

public class TestContactsPage extends BaseMain{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	String sheet = "ContactList";
	
	
	public TestContactsPage() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialisation();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContacts();
	}
	
	@Test(priority = 1)
	public void testVerifyContactsPage() {
		Assert.assertTrue(contactsPage.verifyContactsPage(), "This is not required Contacts page.");
	}
	
	@Test(priority = 2)
	public void testSelectContact(){
		contactsPage.selectContactName("Jassy Test");
	}
	
	@DataProvider
	public Object[][] getTestDataFromExcel() {
		Object data[][] = Util.getTestData(sheet);
		return data;
	}
	
	//@Test(priority = 3, dataProvider = "getTestDataFromExcel")
	@Test
	//public void testCreateNewContact(String fName, String lName, String company, String category) {
	public void testCreateNewContact() {
		contactsPage.createNewContact("Harry", "Potter", "Hogwarts", "Lead");
		//contactsPage.createNewContact(fName, lName, company, company);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
