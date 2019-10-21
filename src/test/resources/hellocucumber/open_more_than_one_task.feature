Feature: I can open more than one task?
  As a developer I want to be able to work on one task at a time

  Scenario Outline: As a developer I can or can not more than one task at the same time
    Given that I opened a task with "<priority>"
    When I try to open another "<another_priority>" task
    Then the system keeps the "<ordinal_number_of_open_task>" task open 

    Examples: 
      | priority  | another_priority | ordinal_number_of_open_task |
      | high		  |     high				 | first		 									 |		
      | high  		|     medium 			 | first								   	   |
      | high		  |     low					 | first                       |
      | medium		|     high				 | second                      |
      | medium		|     medium			 | first                       |
      | medium	  |     low					 | first                       |
      | low	      |     high				 | second                      |
      | low	      |     medium			 | second                      |
      | low    	  |     low					 | first                       |
