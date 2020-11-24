package com.org.pages;


import static com.org.hooks.hooks.driver;
import static com.org.hooks.hooks.log;

import com.org.commonmethods.CommonMethod;
import com.org.uistore.DashboardPageUi;

public class Dashboard {

	public static void clkOnAdminTab() {
			CommonMethod.click(CommonMethod.getElement(DashboardPageUi.adminTab, driver));
	}
}
