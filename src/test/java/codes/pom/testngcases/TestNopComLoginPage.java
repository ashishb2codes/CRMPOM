package codes.pom.testngcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import codes.pom.base.BaseMain;
import codes.pom.pages.NopComLoginPage;

public class TestNopComLoginPage extends BaseMain{
	
	NopComLoginPage nopLoginPage;
	
	public TestNopComLoginPage() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialisation();
		nopLoginPage = new NopComLoginPage();
	}
	
	@Test
	public void testLogin() {
		nopLoginPage.login(prop.getProperty("nopUser"), prop.getProperty("nopPassword"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
