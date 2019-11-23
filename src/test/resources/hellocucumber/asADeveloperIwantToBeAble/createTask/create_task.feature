Feature: Create a task
  As a developer I want to be able to create tasks

  Scenario Outline: As a developer, can I or cannot create tasks?
    Given that I select to create a new task assigned to me
    When I "<hours_action>" the load of estimated hours
    And  I "<date_action>" start date of the task
    And  I "<priority_action>" the priority of the task
    And  I "<status>" the current status of the task
    And  I "<comments>" the comments_section of the tasks
    Then the system shows me "<task_result>" 

    Examples: 
      | hours_action | date_action | priority_action | status       | comments | task_result |
      | charged	     | charged	   | selected		     | selected 	  | filled 	 | created	   |
      | not_charged  | charged		 | selected		     | selected 	  | filled 	 | not_created |	
      | not_charged  | charged		 | not_selected    | selected 	  | filled   | not_created |
      | not_charged  | charged		 | not_selected    | not_selected | filled 	 | not_created |					
      | not_charged  | charged		 | not_selected    | not_selected | empty    | not_created |
      | charged	     | not_charged | selected		     | selected	    | filled 	 | not_created |
      | not_charged  | not_charged | selected		     | selected	    | filled 	 | not_created |
      | not_charged  | not_charged | selected		     | not_selected | filled   | not_created | 		
      | not_charged  | not_charged | selected		     | not_selected | empty    | not_created | 		
      | charged	     | charged		 | not_selected	   | selected 	  | filled 	 | not_created |
      | not_charged  | charged		 | not_selected	   | selected 	  | filled 	 | not_created |
      | not_charged  | not_charged | not_selected	   | selected	    | filled 	 | not_created |
      | not_charged  | not_charged | not_selected	   | selected 	  | empty 	 | not_created |
      | charged	     | charged		 | selected		     | not_selected | filled 	 | not_created |
      | not_charged  | charged		 | selected		     | not_selected | filled 	 | not_created |
      | not_charged  | not_charged | selected		     | not_selected | filled 	 | not_created |
      | not_charged  | not_charged | not_selected	   | not_selected | filled 	 | not_created |
      | charged	     | charged		 | selected		     | selected	    | empty 	 | created 	   |
      | not_charged  | charged		 | selected		     | selected	    | empty 	 | not_created |
      |	not_charged  | not_charged | selected		     | selected	    | empty    | not_created |
      | not_charged  | not_charged | not_selected	   | selected	    | empty 	 | not_created |
      | not_charged  | not_charged | not_selected	   | not_selected | empty 	 | not_created | 
     
