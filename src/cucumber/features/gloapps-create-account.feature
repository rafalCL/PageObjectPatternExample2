Feature: Create account
  Scenario: Successfull create account
    Given Opened webpage: https://hotel-testlab.coderslab.pl/en/login
    When Valid email provided "create account email" input box
    And Click "Create an account" button
    And Is Personal Information form displayed
    And Is email input populated with previous email
    And Fill valid user data
    And Click "Register" button
    Then Confirmed registration success
    And Browser quit
