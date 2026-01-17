Feature: Budget Priority Update

  Scenario: Update budget category priority
    Given browser is open for priority
    And user is logged in for priority
    When user navigates to budget page for priority
    Then user clicks on edit priority
    When user selects new priority
    And user saves the changes
    Then priority should be updated successfully
    And close browser for priority