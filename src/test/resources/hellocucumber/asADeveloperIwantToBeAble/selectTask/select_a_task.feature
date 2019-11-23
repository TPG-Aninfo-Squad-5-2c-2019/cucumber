
Feature: Select a task
  As a developer I want to be able to select a task to see the status of it

  Scenario Outline: Can I or can't I see the status of a task?
    Given that I am on the board
    When I "<action>" a task
    Then  the system "<result>" title, status and description of the task

    Examples: 
      | action  		 | result				   |  
      | select			 | shows_me			   | 
      | don't select | doesn't_show_me |
