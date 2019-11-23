Feature: Authenticate
  As an unauthenticated user, i want to be able to authenticate

  Scenario: Can i authenticate to the system?
    Given i am at the sign in page
    When i enter my username and password
    And i hit submit
    Then i am on the home page