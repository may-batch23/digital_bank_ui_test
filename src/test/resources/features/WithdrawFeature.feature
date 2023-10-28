Feature: Withdraw

  Scenario Outline: Withdraw money from checking account positive test case
    Given the user enters with "<email>" and password "<password>"
    When the user withdraws "<amount>" dollars from the checking account
    Then the difference in money should be equal to the amount withdrawn "<amount>"
    Examples:
      | email                      | password     | amount |
      | nurkenalimbek125@gmail.com | Nubmaster#69 | 50     |