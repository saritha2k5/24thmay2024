Feature: feature to test login functionality of orangehrm

  Scenario: check login successful with valid credentials
    Given launch the browser
    And Navigate to the URL
    When enter the username and password
    And clickon submit button
    Then Home page should be displayed
    And Close the browser
