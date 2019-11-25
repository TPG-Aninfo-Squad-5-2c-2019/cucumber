package hellocucumber.selenium.asMarketingManager;
import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;		
import cucumber.api.java.en.Then;		
import cucumber.api.java.en.When;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class ConsultVersionsOfClientsProducts {
	
 	WebDriver driver;
	String cliente;
	
	public ConsultVersionsOfClientsProducts () {
		System.setProperty("webdriver.chrome.driver", "/home/travis/build/TPG-Aninfo-Squad-5-2c-2019/cucumber/chromedriver_travis/chromedriver");
		driver  = new ChromeDriver();
        driver.manage().window().maximize();
	}
	
	@Given("i navigate to the home page")
	public void i_navigate_to_the_home_page () {
		driver.get("https://squad5-2c-2019.herokuapp.com/");
	}
	
	@When("i select clients link")
	public void i_select_clients_link () {
		driver.findElement(By.id("clients-link")).click();
	}

	@Then("i am at the clients page")
	public void i_am_at_the_clients_page () {
		assertEquals("Clientes", driver.getTitle());
		driver.close();
	}

	@Given("i navigate to the clients page")
	public void i_navigate_to_the_clients_page () {
		driver.get("https://squad5-2c-2019.herokuapp.com/clients");
	}

	@Then("i see a list of all the clients")
	public void i_see_a_list_of_all_the_clients () {
        List<WebElement> clients = driver.findElements(By.cssSelector("#tabla_clientes > tbody > tr"));
        assertTrue(clients.size() > 0);
		driver.close();
	}
}