Feature: Receive notification of new assigned ticket
  As a help desk analyst I want to be notified when I am assigned a task

  Scenario Outline: Can I or cannot I be notified when I am assigned a new task?
    Given that I am located in my workspace 
    When I am "<value>" a new task 
    Then the system "<result>" : new task assigned

    Examples: 
     	| value 	 		 | result				     |
      | assigned 		 | shows_me 				 |
    	| not_assigned | doesn't_show_me  |
