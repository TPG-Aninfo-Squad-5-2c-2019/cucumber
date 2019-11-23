Feature: Schedule income and expenses
  As a finance manager I want to be able to schedule income and expenses

  Scenario Outline: Can I or can't I schedule income and/or expenses?
    Given that I am located on the calendar 
    When I "<action>" a date 
    Then the system "<permission>" to enter TYPE, COMPANY, CONCEPT, TOTALS

    Examples: 
      | action  			| permission 			 | 
      | select			 	|	allows_me				 |
      | don't_select 	|	doesn't_allow_me | 
