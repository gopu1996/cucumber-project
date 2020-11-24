package com.org.steps;

import com.org.pages.Dashboard;
import com.org.pages.Login;

import io.cucumber.java.en.Then;

public class DashboardSteps {

	@Then("I should able to click on admin menu tab")
	public void i_should_able_to_click_on_admin_menu_tab() {
	  Dashboard.clkOnAdminTab();
	}
	
}
