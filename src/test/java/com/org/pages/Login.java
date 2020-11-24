package com.org.pages;

import static com.org.hooks.hooks.driver;
import static com.org.hooks.hooks.log;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.WebElement;
import com.org.commonmethods.CommonMethod;
import com.org.uistore.LoginPageUi;
import com.org.utlity.FileReader;

public class Login {
	
		
	public static void navigateToUrl(String env) {
		
		String url = null;
		if(env.equalsIgnoreCase(FileReader.getEnv())) {
			url = FileReader.getQaUrl();
		} else if(env.equalsIgnoreCase(FileReader.getEnv())){
			url = FileReader.getDevUrl();
		}
		CommonMethod.navigateToUrl(driver, url, log);
	}

	public static void enterUserNameAndPassword(String username, String password) {
      	WebElement txtUserName = CommonMethod.getElement(LoginPageUi.userName, driver);	
      	txtUserName.clear();
      	CommonMethod.sendElement(username, txtUserName);
    	WebElement txtPwd = CommonMethod.getElement(LoginPageUi.password, driver);	
    	txtPwd.clear();
      	CommonMethod.sendElement(password, txtPwd);
	}

	public static void clkOnLoginBtn() {
	 	WebElement btnLogin = CommonMethod.getElement(LoginPageUi.btnLogin, driver);
	 	CommonMethod.click(btnLogin);
	}

	public static void verifyDashboardPage(String url) throws InterruptedException {
		String dashboard = driver.findElement(LoginPageUi.dashBoard).getText();
		Thread.sleep(2000);
        assertEquals(dashboard,url);	
	}

	public static void verifyErrorMsg(String errMsg) {
		String errMessage = driver.findElement(LoginPageUi.errMsg).getText();
        assertEquals(errMessage,errMsg);
	}

}
