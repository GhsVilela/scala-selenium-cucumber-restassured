Feature: Sign up without felling all necessary fields

  Scenario Outline:
    Given that registration page is opened
    And a username <username> field is filled
    And a email <email> field is filled
    When click on sign up button
    Then a required field message is displayed

    Examples:
      |username|email|
      |"test1"|"test1@test.com"|
      |"test2"|"test2@test.com"|