Feature: testing of Homepage https://healable-acptfront.herokuapp.com/#/home

  Scenario Outline: 2. Negative Login
    Given Login Page is opened
    When Login entered as <email>
    And Password entered as <password>
    And Login Page Login button is clicked
    Then Error message "Invalid login. Please try again." is displayed

    Examples:
      | user@user.com  | 12345    |
      | user2@user.com | 678910   |
