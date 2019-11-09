package hellocucumber.asProjectManager;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modules.ShowSelection;

public class CheckProjectHours {
	
	String result;

	@Given("that I open a project")
	public void that_I_open_a_project () {}
	
	@When("I {string} the hours consumed in a project")
	public void I_action_the_hours_consumed_in_a_project(String action) {
		result = ShowSelection.show_selection(action);
	}
	
	@Then("the system {string} hours consumed versus estimated hours")
	public void the_system_result_hours_consumed_versus_estimated_hours (String result) {
		assertEquals(result,this.result);
	}
}


