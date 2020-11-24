package com.org.pages;

import static com.org.hooks.hooks.driver;
import static com.org.hooks.hooks.log;
import static org.junit.Assert.assertEquals;

import com.org.commonmethods.CommonMethod;
import com.org.uistore.AdminPageUi;
import com.org.uistore.LoginPageUi;

public class Admin {

	public static void clkOnAddButton() {
		CommonMethod.click(CommonMethod.getElement(AdminPageUi.btnAdd, driver));
	}

	public static void enterMandatoryDetails(String empName, String username, String pwdAndCpwd) {
		CommonMethod.sendElement(empName, CommonMethod.getElement(AdminPageUi.empName, driver));
		CommonMethod.sendElement(username, CommonMethod.getElement(AdminPageUi.userName, driver));
		CommonMethod.sendElement(pwdAndCpwd, CommonMethod.getElement(AdminPageUi.password, driver));
		CommonMethod.sendElement(pwdAndCpwd, CommonMethod.getElement(AdminPageUi.cnfPassword, driver));
	}

	public static void clkOnSaveButton() {
		CommonMethod.click(CommonMethod.getElement(AdminPageUi.btnSave, driver));
	}

	public static void searchAndVerifyUser(String username) {
		CommonMethod.sendElement(username, CommonMethod.getElement(AdminPageUi.txtSearch, driver));
		CommonMethod.click(CommonMethod.getElement(AdminPageUi.btnSearch, driver));
		String verifyUser = driver.findElement(AdminPageUi.verifyUser).getText();
		assertEquals(verifyUser, username);

	}

}
