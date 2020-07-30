package codes.pom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import codes.pom.base.BaseMain;

public class LoginPage extends BaseMain{
	
	//Object Repository using Page Factory
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(id="top-header-menu")
	WebElement crmLOGO;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement btnLogin;
	
	//Initialize Objects using Constructor
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Page Actions to perform
	public String verifyLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCRMLogo() {
		return crmLOGO.isDisplayed();
	}
	
	public HomePage login(String usrName, String pswd) {
		username.sendKeys(usrName);
		password.sendKeys(pswd);
		btnLogin.click();
		
		return new HomePage();
	}
	
}
