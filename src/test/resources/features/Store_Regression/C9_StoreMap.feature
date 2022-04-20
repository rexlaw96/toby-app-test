Feature: Store Map

  Scenario: Store Map
    Given I click Map Button on Store Listing Page
    Then I shall direct to Store Map Page
    And I shall see below components on Store Map Page :
      | Back Button                |
      | Locate Button              |
      | Service Type Filter Button |
      | Filter Button              |
      | Store Icon                 |
      | Count of Store             |
    When I click Store Icon
    Then I shall see Store Card