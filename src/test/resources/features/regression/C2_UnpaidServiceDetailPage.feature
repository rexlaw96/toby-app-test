Feature: Unpaid Service Detail Page

  Scenario: Unpaid Service Detail Page
    Given I click Service Card - Unpaid
    Then I shall direct to Service Detail Page - Unpaid
##    And I shall see below components on Service Detail Page - Unpaid:
#      | Back Button                         |
#      | Contact CS                          |
#      | Bill Number                         |
#      | Bill Status - Unpaid                |
#      | Service Detail with Collapse Button |
#      | Service Type                        |
##      | Office Area                         |
##      | Service Hours                       |
##      | Service Plan                        |
##      | Location                            |
##      | Service Date                        |
##      | Service Address                     |
#      | Payment Method                      |
#      | Payment Information Button          |
#      | Amount                              |
#      | Amount Detail                       |
#      | Upload Receipt Button               |
#      | Cancel Service Button               |
#      | Total Amount                        |
#      | CTA Button                          |
    And I shall see CTA Button dimmed