Feature: Wedding Budget Form

  Scenario: User can create a wedding budget plan
    Given browser is open for budget
    And user is logged in for budget
    When user navigates to budget optimization page
    Then user should see the budget form
    When user fills in the budget form
    And user submits the budget form
    