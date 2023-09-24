Feature: Creating a new checking account with low amount

  Scenario: Create a new standard checking account with low amount
    Given the user logged in as "johndoe@yahoo.com" with a password "John12345$$"
    When the user creates a new checking account with the following data
      | checkingAccountType | accountOwnership | accountName              | initialDepositAmount |
      | Standard Checking   | Individual       | John Doe Second Checking | 10.00                |
    Then you should see an error message "The initial deposit ($10.00) entered does not meet the minimum amount ($25.00) required. Please enter a valid deposit amount."
