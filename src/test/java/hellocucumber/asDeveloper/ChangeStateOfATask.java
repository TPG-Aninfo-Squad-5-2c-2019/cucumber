package hellocucumber.asDeveloper;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

class ChangeState{
	public static String changeFromTo(String old_state,String new_state) {
		if(old_state.equals("uninitiated")){
			return new_state.equals("in_process")?"was":"wasn't";
		}else
			if(old_state.equals("in_process")) {
				return new_state.equals("finished")?"was":"wasn't";
			}
		return "wasn't";
	}
}

public class ChangeStateOfATask {
	
	private String result;
	
    @Given("that I select a task")
    public void that_I_select_a_task() {}

    @When("I try to change it from the {string} to a {string}")
    public void i_try_to_change_it_from_the_old_state_to_a_new_state
    							(String old_state,String new_state){
    	this.result = ChangeState.changeFromTo(old_state,new_state);
    }

    @Then("the system shows how the state {string} changed")
    public void the_system_shows_how_the_state_result_changed(String result){
        assertEquals(this.result, result);
    }
}



