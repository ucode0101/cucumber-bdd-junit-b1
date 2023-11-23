@background
Feature: Login feature with multiple users

#  One repeated step in both scenarios, we added in Background
  Background:
    Given User is on the login page


  Scenario: Verify login functionality
      When User enters username "Tester" and password "test"
      And User Clicks on login button
      Then User should be logged in successfully


  Scenario: Verify order
    When User enters username "Tester" and password "test"
    And User Clicks on login button
    Then User sees all orders

