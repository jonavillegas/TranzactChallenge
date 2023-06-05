@placeOrder
Feature: The user wants to generate an order on the web (End to End)

  Background:
    Given the url is available
    And the user clicks on login
    When the user enters the "jonavillegas260@gmail.com", "12345678"
    And the user clicks on SIGN IN

  @order
  Scenario Outline: Validate the creation of a new place order
    Given The user searches in the Men category
    And the user selects <quantity> products with different amounts per item
    And the user clicks on Cart
    And the user clicks on Checkout option
    When the user fill the shipping address
    And the user selects a shipping method
    And the user clicks on Continue to payment
    And the user selects a Payment Method
    And the user clicks on Place Order
    Then the order is generated for the logged in user
    Examples:
      | quantity |
      | 5        |


