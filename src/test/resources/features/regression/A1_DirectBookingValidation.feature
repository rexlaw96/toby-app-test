Feature: Direct Booking Questionnaire

  Scenario: Direct Booking Questionnaire
    Given I select the "HOME" category on the landing page
    Then I shall see below components :
    | Daily Cleaning |
    | Deep Cleaning  |
    | New Home       |
    When I click CTA Button on Home Service Onboarding Page
    Then I shall direct to Home Service Questionnaire Page
