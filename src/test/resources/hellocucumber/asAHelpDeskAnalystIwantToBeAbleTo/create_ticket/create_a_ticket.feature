Feature: Create a ticket 
  As a help desk analyst I want to be able to create a ticket

  Scenario Outline: Can I or can't I create a ticket?
    Given that I select to create a ticket 
    When I "<action1>" description and "<action2>" the priority 
    Then the system "<result>" the ticket

    Examples: 
      | action1  			 | action2 			 | result  				 |
      | complete 			 | select  			 | creates 				 |
      | don't_complete | don't_select	 | doesn't_create  |
      | don't_complete | select				 | doesn't_create  |
      | complete			 | don't_select	 | doesn't_create  |