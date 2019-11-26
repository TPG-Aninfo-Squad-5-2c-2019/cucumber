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
        assertEquals("Ver ingresos y egresos del 01/11/2019", driver.findElement(By.name("btn_diario_ingresos_egresos")).getText());
        driver.close();
    }

    @Given("que estoy situado sobre el calendario de ingresos y egresos")
    public void a () {
        driver.get("https://tpg-aninfo-squad5-2c2019.herokuapp.com/calendario_ingresos_egresos");
    }
    
    @When("selecciono una fecha")
    public void b () {
        driver.findElement(By.name("btn_diario_ingresos_egresos")).click();
    }

    @Then("el sistema me muestra todos los importes de los ingresos y egresos de la fecha")
    public void c () {
        driver.close();
    }

    @Given("que estoy situado sobre los montos de los ingresos y egresos de una fecha")
    public void aaa () {
        driver.get("https://tpg-aninfo-squad5-2c2019.herokuapp.com/diario_ingresos_egresos");
    }
    
    @When("selecciono ver detalles")
    public void bbb () {
        driver.findElement(By.name("btn_detalles_ingreso_egreso")).click();
    }

    @Then("el sistema me informa por cada ingreso y egreso: TIPO,EMPRESA,CONCEPTO, IMPORTE")
    public void ccc () {
        List<WebElement> ingresos_y_egresos = driver.findElements(By.cssSelector("#tabla_ingresos_y_egresos > tbody > tr"));
        assertTrue(ingresos_y_egresos.size() > 0);
        for (WebElement element : ingresos_y_egresos) {
            assertTrue(element.findElement(By.id("tipo"))!= null);
        }
        driver.close();
    }
    
}