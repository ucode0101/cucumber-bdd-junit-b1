Feature: Google search functionality

  @outline
  Scenario Outline: Verify search with multiple inputs
    When User is on the google search page
    And User searches for an "<item>"
    Then User should see "<itemName>" in page title
    Examples:
      | item     | itemName |
      | java     | java     |
      | selenium | selenium |
      | TestNG   | TestNG   |
      | JUnit    | JUnit    |

