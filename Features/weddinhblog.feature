Feature: Wedding Blogs Page Functionality

  Scenario: User can view and interact with wedding blogs page
    Given browser is openzz
    And user is logged inz
    When user navigates to wedding blogs page
    Then user should see the wedding blog banner
    When user clicks on a category pill
    Then filtered results should be displayed
    When user clicks on a blog post
    Then blog post details should be displayed