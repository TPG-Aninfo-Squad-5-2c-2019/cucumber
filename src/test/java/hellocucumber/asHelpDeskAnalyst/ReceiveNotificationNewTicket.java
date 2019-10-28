package hellocucumber.asHelpDeskAnalyst;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

class Assignment{
	public static String assignment(String value) {
		return value.equals("assigned")?"shows_me":"doesn't_show_me";
	}
}

public class ReceiveNotificationNewTicket {
	
	String result;
	
	@Given("that I am located in my workspace")
	public void that_I_am_located_in_my_workspace() {}
	
	@When("I am {string} a new task")
	public void I_am_value_a_new_task (String value) {
		this.result = Assignment.assignment(value);
	}
	
	@Then("the system {string} : new task assigned")
	public void the_system_result_new_task_assigned(String result){
		assertEquals(result,this.result);
	}
}
