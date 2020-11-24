package com.org.hooks;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.org.BaseClass.TestBase;
import com.org.utlity.Log;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class hooks {

	public static WebDriver driver;
	public static Logger log;

	@Before
	public void beforeScenario() {
		driver = TestBase.beforeScenario();
		log = TestBase.getLogger();
		

		System.out.println("This will run before the Scenario");
	}

	@SuppressWarnings("deprecation")
	@After
	public void afterScenario(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png"); // stick it in the report
			Log.info("Screen shot taken", log);
		}
		if(driver != null){
	    	driver.quit(); 
		}
	}
	
}
