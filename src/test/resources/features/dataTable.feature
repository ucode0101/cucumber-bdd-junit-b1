Feature: google search functionality

  @dataTable
  Scenario: verify search with multiple inputs
    When User is on the google search page
    Then User searches for
       |keyword|
       |java   |
       |selenium|
       |JUnit   |
       |TestNG  |

