@LoginPositiveAndNegative

Feature: Login functionality


  Background:
    Given User navigates to home page

  Scenario: Positive Login to the page


    When User enters user and password "standard_user" and "secret_sauce" for login

    Then Verify user is logged in

  Scenario: Negative Login to the page


    When User enters user and password "standard_user1" and "secret_sauce" for login

    Then Verify user is NOT logged in