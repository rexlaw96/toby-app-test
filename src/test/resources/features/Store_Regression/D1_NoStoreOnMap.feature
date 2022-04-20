Feature: No Store on Map

  Scenario: No Store on Map
    Given I am on Store Map Page
    When I search location
    Then no Store on Map
    And I shall see this area have no Store Overlay