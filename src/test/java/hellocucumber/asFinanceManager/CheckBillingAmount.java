package hellocucumber.asFinanceManager;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

class CheckSelection{
	public static String check_selection(String selection) {
		return selection.contentEquals("select") ? "lists_me" : "doesn't_list_me";
	}
}

public class CheckBillingAmount {
	String result ;
	
	@Given("that I am placed on billing")
	public void that_I_am_placed_on_billing () {}
	
	@When("I {string} development costs")
	public void I_action_development_costs (String action) {
		this.result = CheckSelection.check_selection(action);
	}
	
	@Then("the system {string} the amount of each amount to be billed "
			+ "and a field indicating "
			+ "if it refers to the level of "
			+ "effort costs or non-human resources used")
	public void the_system_result_string_the_amount_of_each_amount_to_be_billed (String result) {
		assertEquals(result,this.result);
	}
}
