package codes.pom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import codes.pom.base.BaseMain;

public class NopComLoginPage extends BaseMain{
	
	@FindBy(id = "Email") 
	@CacheLookup
	WebElement username;
	
	@FindBy(id = "Password") WebElement password;
	@FindBy(xpath = "//input[@type='submit' and @value='Log in']") WebElement btnLogin;
	
	public NopComLoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public NopComHomePage login(String userName, String passWord) {
		username.clear();
		username.sendKeys(userName);
		password.clear();
		password.sendKeys(passWord);
		btnLogin.click();
		
		return new NopComHomePage();
	}
	
}
