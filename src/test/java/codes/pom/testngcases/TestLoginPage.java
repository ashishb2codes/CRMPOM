package codes.pom.testngcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import codes.pom.base.BaseMain;
import codes.pom.pages.HomePage;
import codes.pom.pages.LoginPage;

public class TestLoginPage extends BaseMain{
	LoginPage loginPage;
	HomePage homePage;
	
	public TestLoginPage() {
		super();
	}
	
	@BeforeMethod
	public void initSetup() {
		initialisation();
		loginPage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void testLoginPageTitle() {
		String pageTitle = loginPage.verifyLoginPageTitle();
		Assert.assertEquals(pageTitle, "Cogmento CRM");
	}
	
	public void testCRMLogo() {
		boolean flag = loginPage.verifyCRMLogo();
		Assert.assertTrue(flag);
		System.out.println("Login Successful..!");
	}
	
	@Test(priority = 2)
	public void testLogin() throws InterruptedException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(4000);
		testCRMLogo();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
