package codes.pom.testngcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import codes.pom.base.BaseMain;
import codes.pom.pages.NopComCustomerPage;
import codes.pom.pages.NopComHomePage;
import codes.pom.pages.NopComLoginPage;

public class TestNopHomePage extends BaseMain{
	
	NopComLoginPage loginPage;
	NopComHomePage homePage;
	NopComCustomerPage customerPage;
	
	public TestNopHomePage() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialisation();
		loginPage = new NopComLoginPage();
		homePage = loginPage.login("admin@yourstore.com", "admin");
	}
	
	@Test
	public void testClickOnCustomerSubMenu() {
		customerPage = homePage.clickOnCustomerList();
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}

}
