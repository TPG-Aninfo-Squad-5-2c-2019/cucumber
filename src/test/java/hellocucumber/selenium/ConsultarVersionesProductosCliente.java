package hellocucumber.selenium;
import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;		

import cucumber.api.java.en.Given;		
import cucumber.api.java.en.Then;		
import cucumber.api.java.en.When;		

public class ConsultarVersionesProductosCliente {
	
 	WebDriver driver;
 	
	String cliente;
	
    @Given("estoy en la seccion de clientes")					
    public void estoy_en_la_seccion_de_clientes() throws Throwable							
    {
    	driver  = new ChromeDriver();
    	System.setProperty("webdriver.chrome.driver", "/home/jonathan/Desktop/cucumber/chromedriver");					
        driver.manage().window().maximize();
        driver.get("file:///home/jonathan/Desktop/cucumber/src/test/resources/views/ClienteTest/ClienteTestPepsiCo.html");		
    }		

    @When("selecciono {string}")			
    public void selecciono_el_nombre_del_cliente(String nombre_cliente) throws Throwable 							
    {		
       cliente = nombre_cliente;									
    }		

    @Then("los productos asociados al cliente se listan")					
    public void	los_productos_asociados_al_cliente_se_listan() throws Throwable 							
    {			
    	driver.findElement(By.name(cliente)).click();
    	try{
		   Thread.sleep(3000);
    	}catch(InterruptedException e){}
    	driver.findElement(By.name("ir_a_PepsiCo_info")).click();
    	try{
 		   Thread.sleep(3000);
     	}catch(InterruptedException e){}
    	driver.findElement(By.name("ir_a_Coca_info")).click();
    }	
}