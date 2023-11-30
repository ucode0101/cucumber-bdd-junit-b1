@xyz
@parallel
Feature: Search feature
  As a user, I want to be able to search when I am on the google search page


  Scenario: Google search verification
    When User is on the google search page
    And User searches for "java"
    Then User should be able to sea "java" in the title


