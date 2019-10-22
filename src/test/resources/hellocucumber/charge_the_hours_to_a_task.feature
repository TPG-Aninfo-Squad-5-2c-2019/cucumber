Feature: Load the hours to a task 
  As a developer I want to be able to load the estimated hours 
  of completion to a task of a particular project.

  Scenario Outline: Can I or cannot load the estimated hours to a task?
    Given that the task is "<status>" to me 
    When I try to modify the estimated hours of development
    Then the system "<permission>" me to modify the charge of estimated hours that I will contemplate to develop it

    Examples: 
      | status       | permission   |
		  | assigned     | allow			  |
      | not_assigned | don't_allow	|

		