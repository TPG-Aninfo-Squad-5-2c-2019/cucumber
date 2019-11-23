package hellocucumber.asFinanceManager;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

class Permission{
	static String givePermission(String action) {
		return action.contentEquals("select") ? "allows_me" : "doesn't_allow_me";
	}
}

public class ScheduleIncomeAndExpenses {
	
	private String permission;
	
	@Given("that I am located on the calendar")
	public void that_I_am_located_on_the_calendar() {}
	
	@When("I {string} a date")
	public void i_action_a_date(String action) {
		this.permission = Permission.givePermission(action);
	}
	
	@Then("the system {string} to enter TYPE, COMPANY, CONCEPT, TOTALS")
	public void the_system_permission_to_enter_type_company_concept_totals (String permission){
		assertEquals(permission,this.permission);
	}

}
