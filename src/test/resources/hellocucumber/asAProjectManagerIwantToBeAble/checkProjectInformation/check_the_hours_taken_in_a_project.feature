Feature: Check the hours taken in a project
  As a project manager I want to be able to check the hours worked on a project

  Scenario Outline: Can I or can't I check the hours worked on a project?
   Given that I open a project 
   When I "<action>" the hours consumed in a project 
   Then the system "<result>" hours consumed versus estimated hours

    Examples: 
      | action		   | result					 | 
      | select 			 | shows_me 			 | 
      | don't_select | doesn't_show_me | 