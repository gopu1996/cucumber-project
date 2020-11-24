
@tag
Feature: Login into orangeHRM website

  Background: 
    Given I should able to visit orangeHRM website login into it in "qa" env 
   
   
    @LoginWithValidCredentials
    Scenario: Login with valid credentials
    Given I should able to enter username "Admin" and password "admin123"
    When I should able to click on login button
    Then I should able to see dashboard page "Dashboard"

    @LoginWithInvalidCredentials
    Scenario: Login with invalid credentials
    Given I should able to enter username "Admins" and password "admin1234"
    When I should able to click on login button
    Then I should able to see error message "Invalid credentials"
   
    @AddingAndVerifyUser
    Scenario Outline: Adding and verifying a user
    Given I should able to enter username "Admin" and password "admin123"
    When I should able to click on login button
    Then I should able to see dashboard page "Dashboard"
    And  I should able to click on admin menu tab
    And  I should able to Click on add button under user management
    And  I should able to enter "<Emp_Name>" , "<Username>", "<Password>" mandatory details on add user form
    And  I should able to click on save button
    Then I should able to Verify that "<Username>" user is successfully added in the user management table by search 
    
     Examples: 
      |Emp_Name      |Username   |Password     |                  
      |Goutam ganesh |Ganesh_123 |Ganesh@12345 |  
      |Garry White   |White_123  |White@12345  | 
      |Charlie Carter|Carter_123 |Carter@12345 |
      |Kiyara Hu     |Kiyara_123 |Kiyara@12345 |
      |Fiona Grace   |Grace_123  |Grace@12345  |
   
   

