Feature: Consult versions of client's products
  As a marketing manager i want to be able to consult the versions of client's products

  Scenario: Go to clients page
    Given i navigate to the home page
    When i select clients link
    Then i am at the clients page

  Scenario: Go to clients page
    Given i navigate to the clients page
    Then i see a list of all the clients