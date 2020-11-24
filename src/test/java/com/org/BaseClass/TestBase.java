package com.org.BaseClass;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
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

		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", FileReader.getFireFoxDriver());

			driver = new FirefoxDriver();

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
		} else if (browserName.contains("edge")) {
			driver = new EdgeDriver();
		} else {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", FileReader.getCromeDriver());
			driver = new ChromeDriver(options);

		}
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		driver.manage().window().maximize();
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
