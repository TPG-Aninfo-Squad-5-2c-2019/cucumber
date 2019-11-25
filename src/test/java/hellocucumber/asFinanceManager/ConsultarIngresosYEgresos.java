package hellocucumber.asFinanceManager;

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
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver  = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    
    @Given("i am at the finanzas page")
    public void that_I_am_at_the_finanzas_page () {
        driver.get("https://squad5-2c-2019.herokuapp.com/finanzas");
    }
    
    @When("i select balance button")
    public void i_select_balance_button () {
        driver.findElement(By.name("btn_balance")).click();
    }

    @Then("i am at the balance page")
    public void i_am_at_the_balance_page () {
        assertEquals("Balance", driver.getTitle());
        driver.close();
    }

    @Given("that I am placed on the balance")
    public void a () {
        driver.get("https://squad5-2c-2019.herokuapp.com/balance");
    }
    
    @When("i click details button")
    public void b () {
        driver.findElement(By.name("btn_details")).click();
    }

    @Then("I see the balance details")
    public void c () {
        assertEquals("BalanceDetails", driver.getTitle());
        driver.close();
    }
    
}