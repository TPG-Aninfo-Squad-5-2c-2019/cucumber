package hellocucumber.asFinanceManager;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistrarIngresoEgreso {

    WebDriver driver;
   
    public RegistrarIngresoEgreso () {
        final ChromeOptions chromeOptions = new ChromeOptions();
    	chromeOptions.setBinary("/usr/bin/google-chrome-stable");
		chromeOptions.addArguments("--headless");
		chromeOptions.addArguments("--disable-gpu");

		driver = new ChromeDriver(chromeOptions);
		
        driver.manage().window().maximize();
    }

    @Given("que estoy situado sobre calendario de ingresos y egresos")
    public void a () {
        driver.get("https://tpg-aninfo-squad5-2c2019.herokuapp.com/calendario_ingresos_egresos");
    }

    @When("selecciono agregar un ingreso o egreso para una fecha en particular")
    public void b () {
        driver.findElement(By.name("btn_registra_ingreso_egreso")).click();
    }

    @Then("el sistema me pide que complete los campos: TIPO,EMPRESA,CONCEPTO,IMPORTE")
    public void c () {
        assertTrue(driver.findElement(By.id("tipo")) != null);
        assertTrue(driver.findElement(By.id("empresa")) != null);
        assertTrue(driver.findElement(By.id("concepto")) != null);
        assertTrue(driver.findElement(By.id("monto")) != null);
    }

}