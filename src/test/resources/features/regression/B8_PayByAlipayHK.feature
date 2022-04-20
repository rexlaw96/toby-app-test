Feature: Pay by Alipay HK

  Scenario: Pay by Alipay HK
    Given I go to Payment Method Select Overlay
    When I select Alipay HK Payment Method and click CTA Button
    Then I shall see Pay by Alipay HK Overlay
    And I shall see below components on Pay By Alipay HK Overlay :
      | Close Button              |
      | Pay with Alipay HK Button |
      | Completed Payment         |
