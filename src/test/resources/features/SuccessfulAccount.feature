Feature: Confirming a new checking account

  Scenario: Create a standard individual checking account

    Given the user logged in as "yurapro02@gmail.com" "Yura1234"
    When the user creates a new checking account with the following data
      | checkingAccountType | accountOwnership | accountName  | initialDepositAmount |
      | Standard Checking   | Individual       | Main Account | 30.0                 |
    Then the user should see the green "Successfully created new Standard Checking account named Main Account" message