package hellocucumber.asDeveloper;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

class Check_load_of_hours{
	public static String is_task_assigned(String status) {
		return status.equals("assigned")? "allows":"doesn't_allow";
	}
}

public class ChargeHours {
	
	private String status;
	private String isAllowed;
	
    @Given("that the task is {string} to me")
    public void that_the_task_is_to_me(String status) {
        this.status = status;
    }

    @When("I try to modify the estimated hours of development")
    public void i_try_to_modify_the_estimated_hours_of_development () {
    	isAllowed = Check_load_of_hours.is_task_assigned(status);
    }

    @Then("the system {string} me to modify the charge "
    		+ "of estimated hours that I will contemplate to develop it")
    public void the_system_permission_me_to_modify_the_charge_of_estimated_hours (String expected_permit) {
        assertEquals(expected_permit, isAllowed);
    }
}
