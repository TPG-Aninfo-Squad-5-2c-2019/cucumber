Feature: Consult clients product version
  As a marketing manager, i want to be able to consult what product version clients are using

  Scenario: Navigation to clients page
    Given i am authenticated
    And i am on the home page
    When i click on the clients button
    Then i am on the clients page

  Scenario: Consult all campaigns
    Given i am authenticated
    And i navigate to the clients page
    Then i see a list of all clients
    And a description and products button for each client

  Scenario Outline: Consult clients details
    Given i am authenticated
    And i navigate to the clients page
    When i click on the "<detail>" button
    Then the client "<detail>" appears

    Examples:
      | detail      |
      | description |
      | products    |