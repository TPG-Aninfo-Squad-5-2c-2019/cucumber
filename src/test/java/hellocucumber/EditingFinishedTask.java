package hellocucumber;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

//Si esta finalizada ---> No la podes editar
class IsFinished {
    static String isFinished(String status) {
        return "Completed".equals(status) ? "No" : "Yes";
    }
}

public class EditingFinishedTask {
	private String status;
    private String isCompleted;

    @Given("task is {string}")
    public void task_is(String status) {
        this.status = status;
    }

    @When("I select edit task")
    public void i_select_edit_task() {
        this.isCompleted = IsFinished.isFinished(status);
    }

    @Then("I should show me {string}")
    public void i_should_show_me(String expectedAnswer) {
        assertEquals(expectedAnswer, isCompleted);
    }
}