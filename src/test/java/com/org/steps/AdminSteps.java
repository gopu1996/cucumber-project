package com.org.steps;

import com.org.pages.Admin;

import io.cucumber.java.en.Then;

public class AdminSteps {
	
	@Then("I should able to Click on add button under user management")
	public void i_should_able_to_Click_on_add_button_under_user_management() {
	      Admin.clkOnAddButton();
	}
	
	@Then("I should able to enter {string} , {string}, {string} mandatory details on add user form")
	public void i_should_able_to_enter_mandatory_details_on_add_user_form(String empName, String username, String pwdAndCpwd) {
	     Admin.enterMandatoryDetails(empName ,username ,pwdAndCpwd);
	}

	@Then("I should able to click on save button")
	public void i_should_able_to_click_on_save_button() {
	    Admin.clkOnSaveButton();
	}

	@Then("I should able to Verify that {string} user is successfully added in the user management table by search")
	public void i_should_able_to_Verify_that_user_is_successfully_added_in_the_user_management_table_by_search(String username) {
	    Admin.searchAndVerifyUser(username); 
	}


}
