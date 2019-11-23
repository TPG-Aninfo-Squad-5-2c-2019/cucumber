package hellocucumber.asDeveloper;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modules.ShowSelection;

public class SelectTask {
	
	String result ;
	
	@Given("that I am on the board")
	public void that_I_am_on_the_board() {}
	
	@When("I {string} a task")
	public void i_action_a_task(String action) {
		this.result = ShowSelection.show_selection(action);
	}
	
	@Then("the system {string} title, status and description of the task")
	public void the_system_result_title_state_and_description_of_the_task(String result) {
		assertEquals(result,this.result);
	}

}
