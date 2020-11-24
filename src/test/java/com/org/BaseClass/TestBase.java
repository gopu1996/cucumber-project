package com.org.BaseClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.org.utlity.Log;
import com.org.utlity.FileReader;
import com.org.utlity.WebEventListener;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * Hello world!
 *
 */
public class TestBase {
	public static WebDriver driver;
	public static Logger log;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public static WebDriver beforeScenario() {

		String browserName = FileReader.browser();

		if (browserName.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", FileReader.getCromeDriver());
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();


		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", FileReader.getFireFoxDriver());

			driver = new FirefoxDriver();
			driver.manage().window().maximize();


		} else if (browserName.equals("ie")) {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("nativeEvents", false);
			cap.setCapability("unexpectedAlertBehaviour", "accept");
			cap.setCapability("ignoreProtectedModeSettings", true);
			cap.setCapability("disable-popup-blocking", true);
			cap.setCapability("enablePersistentHover", true);
			cap.setCapability("ignoreZoomSetting", true);
			cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			InternetExplorerOptions options = new InternetExplorerOptions();
			options.merge(cap);
			driver = new InternetExplorerDriver(options);
			driver.manage().window().maximize();

		} else if (browserName.contains("edge")) {
			driver = new EdgeDriver();
		} else if(browserName.contains("appium")) {
			  DesiredCapabilities cap = new DesiredCapabilities();
		       cap.setCapability(MobileCapabilityType.NO_RESET , true );
		       cap.setCapability(MobileCapabilityType.FULL_RESET , false);
		       cap.setCapability(MobileCapabilityType.DEVICE_NAME , "ANDROID EMULATOR");
		       cap.setCapability(MobileCapabilityType.PLATFORM_NAME , "Android");
		       cap.setCapability(MobileCapabilityType.PLATFORM_VERSION , "8.0");
		       cap.setCapability(MobileCapabilityType.BROWSER_NAME , "Chrome");
		       URL url;
			try {
				url = new URL("http://127.0.0.1:4723/wd/hub");
				   driver= new AppiumDriver<WebElement>(url , cap);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		    
		} else {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", FileReader.getCromeDriver());
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();

		}
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	public static Logger getLogger() {
		log = Log.logg(TestBase.class);
		PropertyConfigurator.configure("Log4j.properties");
		Log.LogFunc(log);
		return log;
	}

}
