Feature: Consult assigned founds
  As a marketing manager, i want to be able to consult assigned founds for campaigns

  Scenario: Create or consult menu
    Given i am authenticated
    And i am on the home page
    When i click on the campaign button
    Then a menu appears with create or consult options

  Scenario: Navigation to consult page
    Given i am authenticated
    And i am on the home page
    And i have clicked on the campaign button
    When i click on consult option
    Then i am on the campaign page

  Scenario: Consult all campaigns
    Given i am authenticated
    And i navigate to the campaign page
    Then i see a list of all campaigns

  Scenario Outline: Consult assigned founds
    Given i am authenticated
    And i am on the campaign page
    And i have permissions for the campaign "<campaign_name>"
    When i click on the consult button of the campaign "<clicked_campaign>"
    Then "<result>" appear

    Examples:
      | campaign_name | clicked_campaign  | result              |
      | campaign 1    | campaign 1        | the assigned founds |
      | campaign 1    | campaign 2        | an error message    |
      | campaign 2    | campaign 1        | an error message    |
      | campaign 2    | campaign 2        | the assigned founds |