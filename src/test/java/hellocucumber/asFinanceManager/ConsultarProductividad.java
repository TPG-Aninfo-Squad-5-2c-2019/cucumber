package hellocucumber.asFinanceManager;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ConsultarProductividad {

    WebDriver driver;
   
    public ConsultarProductividad () {
        final ChromeOptions chromeOptions = new ChromeOptions();
    	chromeOptions.setBinary("/usr/bin/google-chrome-stable");
		chromeOptions.addArguments("--headless");
		chromeOptions.addArguments("--disable-gpu");

		driver = new ChromeDriver(chromeOptions);
		
        driver.manage().window().maximize();
    }

    @Given("que estoy situado mi espacio de trabajo")
    public void a () {
        driver.get("https://tpg-aninfo-squad5-2c2019.herokuapp.com/");
    }

    @When("selecciono la sección de Empleados")
    public void b () {
        driver.findElement(By.id("btn-employees")).click();
    }
    
    @And("selecciono Desarrolladores")
    public void bb() {
    	driver.findElement(By.name("btn_productividad_desarroladores")).click();
    }

    @Then("el sistema me muestra un porcentaje de 0 a 100 indicando el nivel de esfuerzo realizado por cada desarrolador en cada proyecto")
    public void c () {
        assertTrue(driver.findElement(By.id("nombreDesarrollador")) != null);
        assertTrue(driver.findElement(By.id("nombreProyecto")) != null);
        assertTrue(driver.findElement(By.id("nivelEsfuerzo")) != null);
    }

}