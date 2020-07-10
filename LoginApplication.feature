

Feature: Verifying Login Feature

 
   Scenario Outline:  Login Page
    Given user is on homepage
    When user navigates to Login Page
    Then user enter username "<UserName>" and User enter password "<Password>"
    Then Close the browser

    Examples: 
      | UserName            | Password      |
      | abc                 | 123456789$ |
      | gafz@chevrom.com.qa | Mukti123456789$ |
