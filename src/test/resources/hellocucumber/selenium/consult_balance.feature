Feature: Consult balance
  As a finance manager I want to be able to see the income and expenses

  Scenario: Go to balance page
    Given i am at the home page
    When i select balance link
    Then i am at the balance page

  Scenario: Consult the balance details
    Given that I am placed on the balance calendar
    When i click details button
	  Then I see the balance details