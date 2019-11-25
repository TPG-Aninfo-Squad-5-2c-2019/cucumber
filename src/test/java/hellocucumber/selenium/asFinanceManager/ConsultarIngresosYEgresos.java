package hellocucumber.selenium.asFinanceManager;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ConsultarIngresosYEgresos {
	
    WebDriver driver;
   
    public ConsultarIngresosYEgresos () {
        System.setProperty("webdriver.chrome.driver", "/home/santiagoaj/Documentos/Aninfo Cucumber/cucumber/chromedriver");
        driver  = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    
    @Given("i am at the home page")
    public void that_I_am_placed_on_billing () {
        driver.get("localhost:8080");
    }
    
    @When("i select balance link")
    public void i_select_clients_link () {
        driver.findElement(By.id("btn_finance_balance")).click();
    }

    @Then("i am at the balance page")
    public void i_am_at_the_clients_page () {
        assertEquals("Ingresos y egresos", driver.getTitle());
        driver.close();
    }

    @Given("that I am placed on the balance calendar")
    public void a () {
        driver.get("localhost:8080/balance");
    }
    
    @When("i click details button")
    public void b () {
        driver.findElement(By.id("btn_balance_details")).click();
    }

    @Then("I see the balance details")
    public void c () {
        assertEquals("Ingresos y egresos", driver.getTitle());
        driver.close();
    }
    
}