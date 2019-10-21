Feature: Can i continue editing a finished task?
	As a developer I want to know if I can edit a finished task

  Scenario Outline: I can or can not continue editing a completed task
    Given task is "<status>"
    When I select edit task
    Then I should show me "<answer>"

    Examples:
      | status      | answer |
      | Not_started | Yes    |
      | In_process  | Yes    |
      | Completed   | No	   |
