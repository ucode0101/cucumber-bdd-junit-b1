@google
Feature: Google search functionality

  Background:
    When User is on the google search page


  Scenario: Google search verification
    And User searches for "java"
    Then User should be able to sea "java" in the title

  @outline
  Scenario Outline: Verify search with multiple inputs
    And User searches for an "<item>"
    Then User should see "<itemName>" in page title
    Examples:
      | item     | itemName |
      | java     | java     |
      | selenium | selenium |
      | TestNG   | TestNG   |
      | JUnit    | JUnit    |

