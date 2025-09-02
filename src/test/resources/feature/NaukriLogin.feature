Feature: Naukri Login Functionality
  Scenario: Valid login
    Given I am on the Naukri login page
    When I enter naukri username "your_email@example.com"
    And I enter naukri password "your_password"
    And I click on the Naukri login button
    Then I should be logged in successfully