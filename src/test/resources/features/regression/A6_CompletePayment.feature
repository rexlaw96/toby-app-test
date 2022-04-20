Feature: Complete Payment

  Scenario: Complete Payment
    Given I selected Payment Method on Payment Overlay
    When I click CTA Button on Confirmation Page
    Then I direct to Thank You Your Booking Page
