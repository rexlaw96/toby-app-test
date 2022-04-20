Feature: Direct Booking Confirmation Page

  Scenario: Direct Booking Confirmation Page
    Given I click CTA Button on Questionnaire last Question
    Then I shall direct to Confirmation Page from Questionnaire
#    And I shall see below components on Confirmation Page Direct Boooking :
#      | Cancel Button                  |
#      | Service Detail Collapse Button |
#      | Service Type                   |
#      | Service Type Edit Button       |
#      | Office Area                    |
#      | Office Area Edit Button        |
#      | Service Hours                  |
#      | Service Hours Edit Button      |
#      | Service Plan                   |
#      | Service Plan Edit Button       |
#      | Location                       |
#      | Location Edit Button           |
#      | Service Date                   |
#      | Service Date Edit Button       |
#      | Service Address                |
#      | Service Address Edit Button    |
#      | Promotion Code Select Field    |
#      | Payment Method Select Field    |
#      | Fees Detail                    |
#      | Total Amount                   |
#      | CTA Button                     |
    And I shall see CTA Button enable by default