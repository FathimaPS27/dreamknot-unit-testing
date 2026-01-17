Feature: Feedback Form Submission

  Scenario: Submit feedback for a service
    Given browser is openx
    And user is on login pagex
    When user enters username and passwordx
    And user clicks on loginx
    Then user navigates to feedback form
    When user submits feedback
    Then feedback submission should be successful
    And close browserx