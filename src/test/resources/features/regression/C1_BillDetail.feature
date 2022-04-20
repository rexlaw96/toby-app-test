Feature: Bill Detail

  Scenario: Bill Detail
    Given I click Back To Bill Detail Button
    Then I shall direct to MyService Page
    And I shall see Progress Select Tab
#  Note :
#  If Status = Waiting for Pay
    Then I shall see Pay Now Button display on Service Card
#  If Status = Waiting for Review
#    Then I shall see Review Button display on Service Card