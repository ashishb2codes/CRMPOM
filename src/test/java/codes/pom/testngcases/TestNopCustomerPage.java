package codes.pom.testngcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import codes.pom.base.BaseMain;
import codes.pom.pages.NopComCustomerPage;
import codes.pom.pages.NopComHomePage;
import codes.pom.pages.NopComLoginPage;
import codes.pom.util.Util;

public class TestNopCustomerPage extends BaseMain{
	
	NopComLoginPage nopLogin;
	NopComHomePage nopHome;
	NopComCustomerPage nopCustomer;
	
	String sheetName = "CustomerList";
	
	
	public TestNopCustomerPage() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialisation();
		nopCustomer = new NopComCustomerPage();
		nopLogin = new NopComLoginPage();
		nopHome = nopLogin.login(prop.getProperty("nopUser"), prop.getProperty("nopPassword"));
		nopCustomer = nopHome.clickOnCustomerList();
		
	}
	
	@Test(priority = 1)
	public void testSelectContact() {
		nopCustomer.selectCustomer("Victoria");
		nopCustomer.selectCustomer("Pan");
	}
	
	@Test(priority = 2)
	public void testSearchCustomer() {
		nopCustomer.searchCustomer();
	}
	
	@DataProvider
	public Object[][] getDataFromExcel() {
		Object testData[][] = Util.getTestData(sheetName);
		return testData;
	}
	@Test(priority = 3, dataProvider ="getDataFromExcel")
	public void testAddNewCustomer(String emailID, String firstname, String lastname, String vendorID, String gender) {
		//nopCustomer.addNewCustomer("raj@b2codes.code", "Raj", "Denver", "Vendor 2", 'M');
		nopCustomer.addNewCustomer(emailID, firstname, lastname, vendorID, gender); 
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
