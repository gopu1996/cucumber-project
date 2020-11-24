package com.org.steps;

import static com.org.hooks.hooks.log;
import com.org.pages.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	@Given("I should able to visit orangeHRM website login into it in {string} env")
	public void i_should_able_to_visit_orangeHRM_website_login_into_it_in_env(String env) {
		Login.navigateToUrl(env);
	}

	@Given("I should able to enter username {string} and password {string}")
	public void i_should_able_to_enter_username_and_password(String username, String password) {
		System.out.println(username  +  "  ghhh  "+password ); 
		Login.enterUserNameAndPassword(username, password);
	}

	@When("I should able to click on login button")
	public void i_should_able_to_click_on_login_button() {
		Login.clkOnLoginBtn();

	}

	@Then("I should able to see dashboard page {string}")
	public void i_should_able_to_see_dashboard_page(String txt) {
		try {
			Login.verifyDashboardPage(txt);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Then("I should able to see error message {string}")
	public void i_should_able_to_see_error_message(String errMsg) {
	   Login.verifyErrorMsg(errMsg);
	}

}
