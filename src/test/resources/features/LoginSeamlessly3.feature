Feature: Login functionality tests

  @validLogin
  Scenario: Login with valid credential
    Given the user is on the log in page
    When the user enter valid username
    And the user enter valid password
    And the user clicks the log in button
    Then the user should be able to log in


  @validLoginWithParams
  Scenario: Login with valid credential
    Given the user is on the log in page
    When the user enters username "Employee61"
    And the user enters password "Employee123"
    And the user clicks the log in button
    Then the user should be able to log in


  @invalidLoginWithParams
  Scenario: Login with valid credential
    Given the user is on the log in page
    When the user enters username "Employee61"
    And the user enters password "Employee1234"
    And the user clicks the log in button
    Then the user should not be able to log in

  @invalidLoginWithParams
  Scenario: Login with valid credential
    Given the user is on the log in page
    When the user enters username "Employee614"
    And the user enters password "Employee123"
    And the user clicks the log in button
    Then the user should not be able to log in

  @invalidLoginWithParams
  Scenario: Login with valid credential
    Given the user is on the log in page
    When the user enters username "Employee614"
    And the user enters password "Employee1234"
    And the user clicks the log in button
    Then the user should not be able to log in


  @invalidLoginWithParamsSceOutLine
  Scenario Outline: Login with valid credential
    Given the user is on the log in page
    When the user enters username "<username>"
    And the user enters password "<password>"
    And the user clicks the log in button
    Then the user should not be able to log in

    Examples:
      | username      | password      |
      | Employee61    | WrongPassword |
   #   | WrongUsername | Employee123   |
      | WrongUsername | WrongPassword |
    #  | empty         | empty         |