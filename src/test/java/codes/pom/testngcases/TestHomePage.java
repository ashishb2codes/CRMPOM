package codes.pom.testngcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import codes.pom.base.BaseMain;
import codes.pom.pages.ContactsPage;
import codes.pom.pages.HomePage;
import codes.pom.pages.LoginPage;

public class TestHomePage extends BaseMain{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public TestHomePage() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialisation();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void testHomePageTitle() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM", "Home page title not matched.");
	}
	
	@Test(priority = 2)
	public void testVerifyUserName() {
		Assert.assertTrue(homePage.verifyUserName());
	}
	
	@Test(priority = 3)
	public void testClickOnContacts() throws InterruptedException {
		contactsPage = homePage.clickOnContacts();
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
