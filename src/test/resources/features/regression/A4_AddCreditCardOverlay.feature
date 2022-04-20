Feature: Add Credit Card Overlay

  Scenario: Add Credit Card Overlay
    Given I click Add Credit Card Select Field
    Then I shall see Add Credit Card Overlay display
#    And I shall see below components Add Credit Card Overlay :
#      | Close Button            |
#      | Credit Card Input Field |
#      | Expiry date Input Field |
#      | CVV Input Field         |
#      | CTA Button              |
    When I input invalid Credit Card Number
    Then I shall see inline error display on Add Credit Card Overlay
    When I input invalid Expiry Date
    Then I shall see inline error
    When I input valid Credit Card Number
    Then I click CTA Button on Add Credit Card Overlay
    And I shall see Credit Card Number and Expiry Date display on Payment Method Select Field