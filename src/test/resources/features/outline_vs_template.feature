Feature: Testing Scenario Outline vs Scenario Template

  Scenario Outline: verify search functionality
    When user is on the search page
    And User enters "<itemName>"
    And User sees "<nameItem>" displayed

    Examples:
      | itemName | nameItem |

  Scenario Template: verify search functionality
    When user is on the search page
    And User enters "<itemName>"
    And User sees "<nameItem>" displayed
    Examples:
      | itemName | nameItem |


#    Scenario Template and Scenario Outline both are exactly the same
 # The only difference is one uses Template, and the other one uses Outline