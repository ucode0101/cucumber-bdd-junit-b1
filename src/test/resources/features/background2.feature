@parallel
Feature: Login feature with multiple users

  # Three repeated steps in both scenarios, we added in Background
  Background:
    Given User is on the login page
    When User enters username "Tester" and password "test"
    And User Clicks on login button


  Scenario: Verify login functionality
    Then User should be logged in successfully


  Scenario: Verify order
    Then User sees all orders
