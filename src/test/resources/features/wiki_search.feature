@wiki
Feature: Wikipedia search
  As a User I want to have search functionality in wiki page so I can search

  Scenario Outline: Verify wiki search functionality with multiple input
    Given User is on wiki home page
    And User types "<value>" in search box
    Then User sees "<expTitle>" in the title
    Then User sees "<expHeader>" in the main header
    Then User sees "<expImage>" in the image header

    Examples:
      | value        | expTitle     | expHeader    | expImage     |
      | Steve Jobs   | Steve Jobs   | Steve Jobs   | Steve Jobs   |
      | Steve Jobs   | Steve Jobs   | Steve Jobs   | Steve Jobs   |
      | Steve Jobs   | Steve Jobs   | Steve Jobs   | Steve Jobs   |


