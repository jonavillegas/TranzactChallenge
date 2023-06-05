@SignIn
Feature: The user wants to access his account on the web

  @register
  Scenario Outline: Validate the creation of a new account
    Given the url is available
    And the user clicks on login
    And the user clicks on Create an account
    When the user enters the "<fullName>", "<email>", "<password>"
    And the user clicks on SIGN UP
    And the user clicks on login option
    Then the user email "<email>" is displayed
    Examples:
      | fullName          | email                     | password |
      | Jonathan Villegas | jonavillegas300@gmail.com | 12345678 |


  @login
  Scenario Outline: Validate a user login
    Given the url is available
    And the user clicks on login
    When the user enters the "<email>", "<password>"
    And the user clicks on SIGN IN
    And the user clicks on login option
    Then the user email "<email>" is displayed
    Examples:
      | email                     | password |
      | jonavillegas300@gmail.com | 12345678 |