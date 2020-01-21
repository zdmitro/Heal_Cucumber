Feature: testing of Homepage https://healable-acptfront.herokuapp.com/#/home

  Scenario: 1. Login Page opens successfully
    Given Home Page is opened
    When Login button is clicked
    Then Assert Login page is opened