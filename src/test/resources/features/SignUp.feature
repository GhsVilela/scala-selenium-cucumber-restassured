Feature: Sign up

  Scenario Outline: Without filling all necessary fields
    Given that registration page is opened
    And username <username> field is filled
    And email <email> field is filled
    When user clicks on sign up button
    Then sign up is not completed due to missing required field

    Examples:
      |username|email|
      |"test1"|"test1@test.com"|
      |"test2"|"test2@test.com"|

  Scenario Outline: Filling all necessary fields
    Given that registration page is opened
    And username <username> field is filled
    And email <email> field is filled
    And password field is filled
    When user clicks on sign up button
    Then sign up is completed successfully

    Examples:
      |username|email|
      |"test3"|"test3@test.com"|
      |"test4"|"test4@test.com"|
