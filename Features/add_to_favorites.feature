Feature: User Management and Favorites

  Scenario: User logs in and adds a service to favorites
    Given browser is opens
    And user is on login pages
    When user enters username and passwords
    And user clicks on logins

   Then user clicks on view details
   And user clicks on addToFavorite
   Then user clicks on account
   And user clicks on favorite list