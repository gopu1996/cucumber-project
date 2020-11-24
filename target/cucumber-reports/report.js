$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:features/login.feature");
formatter.feature({
  "name": "Login into orangeHRM website",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@tag"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I should able to visit \"https://opensource-demo.orangehrmlive.com/index.php/auth/login\" login of website",
  "keyword": "Given "
});
formatter.match({
  "location": "com.org.steps.LoginSteps.i_should_able_to_visit_login_of_website(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Login with valid credentials",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@tag"
    },
    {
      "name": "@LoginWithValidCredentials"
    }
  ]
});
formatter.step({
  "name": "I should able to enter username \"Admin\" and password \"admin123\"",
  "keyword": "Given "
});
formatter.match({
  "location": "com.org.steps.LoginSteps.i_should_able_to_enter_username_and_password(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should able to click on login button",
  "keyword": "When "
});
formatter.match({
  "location": "com.org.steps.LoginSteps.i_should_able_to_click_on_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should able to see dashboard page \"Dashboard\"",
  "keyword": "Then "
});
formatter.match({
  "location": "com.org.steps.LoginSteps.i_should_able_to_see_dashboard_page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});