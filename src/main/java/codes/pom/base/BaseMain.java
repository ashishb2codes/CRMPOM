package codes.pom.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import codes.pom.util.EventListener;

public class BaseMain {
	
	protected static WebDriver driver;		// Only the Child class will access
	protected static Properties prop;
	protected static WebDriverWait wait;
	protected static EventFiringWebDriver eventFireDriver;
	protected static EventListener eventListener;
	
	public BaseMain() {
		try {
			prop = new Properties();
			FileInputStream input = new FileInputStream("..\\CRMPOM\\src\\main\\java\\codes\\pom\\util\\config.properties");
			prop.load(input);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialisation() {
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("CHROME_DRIVER"));
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("FF_DRIVER"));
			driver = new FirefoxDriver();
		}
		
		eventFireDriver = new EventFiringWebDriver(driver);
		//Register eventListener with eventFireDriver
		eventListener = new EventListener();
		eventFireDriver.register(eventListener);
		driver = eventFireDriver;
		
		wait = new WebDriverWait(driver, 30);
		
		int PAGELOAD_TIME = new Integer (prop.getProperty("PAGE_LOAD_TIME"));
		int IMPLICITWAIT_TIME = Integer.parseInt((prop.getProperty("IMPLICIT_WAIT_TIME")));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(PAGELOAD_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(IMPLICITWAIT_TIME, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("testURL"));
	}

}
