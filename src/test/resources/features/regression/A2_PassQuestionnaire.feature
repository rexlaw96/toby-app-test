Feature: Pass Questionnaire

  Scenario: Pass Questionnaire
    Given I go to Questionnaire
    Then I shall direct to Questionnaire
    And  I shall see CTA Button dimmed by default
    When I select answer
    Then I shall see CTA Button enable
