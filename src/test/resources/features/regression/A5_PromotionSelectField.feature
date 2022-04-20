Feature: Promotion Select Field

  Scenario: Promotion Select Field
#    Given I click Promotion Code Select Field
#    Then I shall see below components on Promotion Code Select Field :
#      | Close Button             |
##      | Can Reuse Promotion Code |
#      | Add Promotion Code       |
#      | No Use Promotion Code    |
    When I click Add Promotion Code Field
    Then I can input Promotion Code
    When I input invalid Promotion Code
    Then I shall see Promotion Code invalid Error Pop Up
    When I input valid Promotion Code
    Then I shall see inputted Promotion Code display on Promotion Code Select Field