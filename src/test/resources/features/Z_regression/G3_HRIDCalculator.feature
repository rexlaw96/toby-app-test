Feature: HRID Calculator

  Scenario: HRID Calculator
    Given I am on Renovation Calculator Page
    When I fill in all information
    When I click Project Item Select Box
    Then I shall see Item Select Overlay display
    When I selected item
    When I click CTA Button
    Then I shall direct to Renovation Calculator Result Page
    And I shall see selected item display on Project Item Select Box