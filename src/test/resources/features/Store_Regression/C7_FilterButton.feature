Feature: Filter Button

  Scenario: Filter Button
    Given I click Filter Button
    Then I shall see Filter Overlay display
    And I shall see below components on Filter Overlay
      | Back Button      |
      | Clean All Button |
      | Filter Button    |
      | CTA Button       |
    When I click CTA Button on Filter Overlay
    Then I shall see Filter Button enable