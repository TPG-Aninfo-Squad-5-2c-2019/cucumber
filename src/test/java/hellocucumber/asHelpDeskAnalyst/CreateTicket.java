package hellocucumber.asHelpDeskAnalyst;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

class SolveTicketCreation{
	public static String solve_ticket_creation(String action, String action2) {
		return (action.contentEquals("complete") && 
			action2.contentEquals("select"))? "creates":"doesn't_create";
	}
}

public class CreateTicket {
	String result;
	
	@Given("that I select to create a ticket")
	public void that_I_select_to_create_a_ticket(){}
	
	@When("I {string} description and {string} the priority")
	public void I_action1_description_and_action2_the_priority
	(String action1,String action2) {
		result = SolveTicketCreation.solve_ticket_creation(action1,action2);
	}
	
	@Then("the system {string} the ticket")
	public void the_system_result_the_ticket(String result){
		assertEquals(result,this.result);
	}
}
