Feature: Sorting Filter Button

  Scenario: Sorting Filter Button
    Given I click Sorting Filter Button
    Then I shall see Sorting Filter Overlay display
    And I shall see below components on Sorting Filter Overlay :
      | Close Button   |
      | Back to Preset |
      | Sorting Button |
      | CTA Button     |
    When I click CTA Button on Sorting Filter Overlay
    Then I shall see Sorting Filter Button enable