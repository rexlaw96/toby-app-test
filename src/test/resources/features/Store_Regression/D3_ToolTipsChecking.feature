Feature: Tool Tips checking

  Scenario: Tool Tips checking
    Given I click Tool Tips Button
    Then I shall see Tool Tips Overlay
    When I click Close Button on Tool Tips Overlay
    Then I shall see Tool Tips dismiss