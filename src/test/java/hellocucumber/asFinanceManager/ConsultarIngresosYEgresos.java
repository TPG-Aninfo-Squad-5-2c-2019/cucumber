package hellocucumber.asFinanceManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ConsultarIngresosYEgresos {
	
    WebDriver driver;
   
    public ConsultarIngresosYEgresos () {
        final ChromeOptions chromeOptions = new ChromeOptions();
    	chromeOptions.setBinary("/usr/bin/google-chrome-stable");
		chromeOptions.addArguments("--headless");
		chromeOptions.addArguments("--disable-gpu");

		driver = new ChromeDriver(chromeOptions);
		
        driver.manage().window().maximize();
    }
    
    
    @Given("que estoy situado en finanzas")
    public void aa () {
        driver.get("https://tpg-aninfo-squad5-2c2019.herokuapp.com/finanzas");
    }
    
    @When("selecciono calendario de ingresos y egresos")
    public void bb () {
        driver.findElement(By.name("btn_calendario_ingresos_egresos")).click();
    }

    @Then("el sistema me muestra las fechas para consultar ingresos y egresos")
    public void cc () {
        assertEquals("Detalles del 01/11/2019", driver.findElement(By.name("btn_details")).getText());
        driver.close();
    }

    @Given("que estoy situado en el calendario de ingresos y egresos")
    public void a () {
        driver.get("https://tpg-aninfo-squad5-2c2019.herokuapp.com/calendario_ingresos_egresos");
    }
    
    @When("selecciono ver detalles de un dia")
    public void b () {
        driver.findElement(By.name("btn_details")).click();
    }

    @Then("el sistema me informa: TIPO,EMPRESA,CONCEPTO, IMPORTE")
    public void c () {
        List<WebElement> ingresos_y_egresos = driver.findElements(By.cssSelector("#tabla_ingresos_y_egresos > tbody > tr"));
        assertTrue(ingresos_y_egresos.size() == 2);
        assertEquals(ingresos_y_egresos.get(0).getText(), "Egreso Edesur Pago de Servicios 50.000");
        assertEquals(ingresos_y_egresos.get(1).getText(), "Ingreso Coca-Colas Cobro de Contratos de Soporte 150.000");
        driver.close();
    }
    
}