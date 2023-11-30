@parallel
Feature: Add Remove WebElement verification




  Scenario: Verify add remove web element functionality
    Given User is on the internet home page
    When User clicks on addRemove element button
    And User clicks on Added element button
    Then A new button should be displayed
    And User click on Delete button
    Then Element should be deleted
