Feature: Invitation

  Scenario: User logs in and sends an invitation
    Given browser is openss
    And user is on login pagess
    When user enters username and passwordss
    And user clicks on loginss
    Then user clicks on Planning
    And user clicks on Invitation
    When user enters event name, event date, event time, venue, venue address, phone number, location link,guestname,guestemail, and event description
    And user clicks on send invitation