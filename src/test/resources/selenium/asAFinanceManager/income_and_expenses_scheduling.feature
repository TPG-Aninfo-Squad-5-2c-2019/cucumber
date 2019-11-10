Feature: Income and expenses scheduling
  As a finance manager, i want to be able to schedule incomes and expenses

  Scenario: Navigation to income & expenses page
    Given i am authenticated
    And i am on the home page
    When i click on the schedule button
    Then i am on the income & expenses page

  Scenario: Company areas menu
    Given i am authenticated
    And i navigate to the income & expenses page
    Then i see a calendar in the actual month

  Scenario: Navigation between months
    Given i am authenticated
    And i navigate to the billings page
    When i click on the previous button
    Then i see a calendar in the previous month

  Scenario: Go to today
    Given i am authenticated
    And i navigate to the billings page
    When i click on the go to today button
    Then i see a calendar in the actual month
