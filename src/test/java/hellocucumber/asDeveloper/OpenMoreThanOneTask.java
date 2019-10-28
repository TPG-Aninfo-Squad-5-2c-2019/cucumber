package hellocucumber.asDeveloper;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

//Devuelve el numero ordinal (segun orden de los parametros) de la tarea mas prioritaria 
class ComparePriority {
  static String Is_it_more_prioritized_than(String priority, String another_priority) {
	  String ordinal_number_of_open_task = "first";
      if(priority.equals("medium")) {
		  if(another_priority.equals("high")){
			  ordinal_number_of_open_task = "second";
		  }
	 }else
		  if(priority.equals("low") && !another_priority.equals("low")){
			  ordinal_number_of_open_task = "second";
		  }
      return ordinal_number_of_open_task;
  }
}

public class OpenMoreThanOneTask {
	
	private String priority;
	private String ordinal_number_of_open_task;

    @Given("that I opened a task with {string}")
    public void that_I_opened_a_task_with(String priority) {
        this.priority = priority;
    }

    @When("I try to open another {string} task")
    public void i_try_to_open_another_task(String another_priority) {
        this.ordinal_number_of_open_task = ComparePriority.
        					Is_it_more_prioritized_than(priority, another_priority);
    }

    @Then("the system keeps the {string} task open")
    public void system_keeps_the_highest_priority_task_open(String expectedAnswer) {
        assertEquals(expectedAnswer, ordinal_number_of_open_task);
    }
}



