Feature: Creating new Checking Account with missing info

  Background:
    Given user is on "https://dbank-qa.wedevx.co/bank/signup"

  Scenario: Trying to create a new account with no specifying account type
    When the user enters login "1234567@gmail.com" and password "Valia1996"
    Then the user clicks on "Checking" and chooses "New Checking" account
    And user clicks on "Submit" button
    Then the user should get an error message "Please select one of these options."

