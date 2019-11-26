Feature: Change state to a task
  As a developer I want to be able to change the state to a task

  Scenario Outline: Can I or can't I change the state of a task?
  	Given that I select a task 
  	When I try to change it from the "<old_state>" to a "<new_state>" 
  	Then the system shows how the state "<result>" changed

    Examples: 
      | old_state   | new_state  | result |
      | uninitiated | in_process | was    |
      | in_process  | finished   | was    |
      | in_process	|	uninitiated| wasn't |
      | finished		|	uninitiated| wasn't |
			| finished		|	in_process | wasn't |