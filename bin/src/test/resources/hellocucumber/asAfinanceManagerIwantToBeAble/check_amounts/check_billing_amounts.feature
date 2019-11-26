Feature: Check billing amounts
  As a finance manager I want to be able to see the billing amounts coming from the development area

  Scenario Outline: Can I or cannot see the billing amounts?
    Given that I am placed on billing
		When I "<action>" development costs
		Then the system "<result>" the amount of each amount to be billed and a field indicating if it refers to the level of effort costs or non-human resources used

    Examples: 
      | action  			| result 				   | 
      | select 				| lists_me  		   | 
      | don't_select 	| doesn't_list_me  | 