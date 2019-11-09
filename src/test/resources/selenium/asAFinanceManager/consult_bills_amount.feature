Feature: Consult billing amount
  As a finance manager, i want to be able to consult billing amount

  Scenario: billing or projects menu
    Given i am authenticated
    And i am on the home page
    When i click on the selection box
    Then a menu appears with billings and project options

  Scenario: Navigation to consult page
    Given i am authenticated
    And i am on the home page
    And i have clicked on the selection box
    When i click on billings option
    Then i am on the billings page

  Scenario: Company areas menu
    Given i am authenticated
    And i navigate to the billings page
    When i click on the selection box
    Then a menu appears with all the company areas

  Scenario Outline: Navigation to area billings page
    Given i am authenticated
    And i navigate to the billings page
    And i have clicked on the selection box
    When i click on the "<area>" option
    Then i am on the "<area>" billing page

    Examples:
      | area                |
      | develop             |
      | management director |
      | marketing           |
      | help desk           |
      | finance             |
      | projects            |