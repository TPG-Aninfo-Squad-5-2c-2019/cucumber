package hellocucumber;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

class DetermineField{
	
	public static Boolean isCharged(String dateAndTime){
		return dateAndTime.equals("charged")? true :false;
	}
	
	public static Boolean isSelected(String status) {
		return status.equals("selected")? true :false;
	}
	
	public static Boolean areFilled(String comments) {
		return true;
	}
}

public class CreateTask{
	
	private String hours, start_date, priority, status;
	private String isCreated;

    @Given("that I select to create a new task assigned to me")
    public void that_I_select_to_create_a_new_task_assigned_to_me () {}

    @When("I {string} the load of estimated hours")
    public void I_charge_estimated_hours(String hours_action) {
    	this.hours = hours_action;
    }
    
    @And("I {string} start date of the task")
    public void I_start_date_action_start_date_of_the_task(String start_date_action) {
    	this.start_date = start_date_action;
    }
    
    @And("I {string} the priority of the task")
    public void I_priority_action_the_priority_of_the_task(String priority_action) {
    	this.priority = priority_action;
    }
    
    @And("I {string} the current status of the task")
    public void I_priority_action_the_current_status_of_the_task(String status_action) {
    	this.status = status_action;
    }
    
    @And("I {string} the comments_section of the tasks")
    public void I_comments_action_the_comments_section_of_the_task(String comments_action){
    
    	if(DetermineField.isCharged(hours) && DetermineField.isCharged(start_date) && 
    	   DetermineField.isSelected(priority) && DetermineField.isSelected(status)) {
    		isCreated = "created";
    	}else{
    		isCreated = "not_created";
    	}
    }
    
    @Then("the system shows me {string}")
    public void i_should_show_me(String expectedAnswer) {
        assertEquals(expectedAnswer, isCreated);
    }

}