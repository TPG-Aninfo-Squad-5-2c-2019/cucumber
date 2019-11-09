package hellocucumber.asAMarketingManager;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ConsultClientsProductVersion {
    WebDriver driver;
    Select campaign_select;

    @Given("i am authenticated")
    public void i_am_authenticated () {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("/signin");
        WebElement username_input = driver.findElement(By.name("username"));
        username_input.sendKeys("myusername");
        WebElement password_input = driver.findElement(By.name("password"));
        username_input.sendKeys("password");
        username_input.submit();
    }

    @And("i am on the home page")
    public void i_am_on_the_home_page () {
        driver.get("/home");
    }

    @When("i click on the clients button")
    public void i_click_on_the_clients_button () {
        WebElement clients = driver.findElement(By.name("clients"));
        clients.click();
    }

    @Then("i am on the clients page")
    public void i_am_on_the_clients_page () {
        // Thread.sleep(5000);
        assertEquals(driver.getTitle(), "Clients");
        driver.quit();
    }

    @And("i navigate to the clients page")
    public void i_navigate_to_the_clients_page () {
        driver.get("/clients");
    }

    @Then("i see a list of all clients")
    public void i_see_a_list_of_all_clients () {
        List<WebElement> clients = driver.findElements(By.className("client"));
        assertTrue(clients.size() > 0);
    }

    @And("a description and products button for each client")
    public void a_description_and_products_button_for_each_client () {
        List<WebElement> clients = driver.findElements(By.className("client"));
        for (WebElement client : clients) {
            assertEquals(1, client.findElements(By.className("products-button")).size());
            assertEquals(1, client.findElements(By.className("products-button")).size());
        }
    }

    @When("i click on the \"<detail>\" button")
    public void i_click_on_the_detail_button (String detail) {
        WebElement button = driver.findElement(By.name(detail + "button"));
        button.click();
    }

    @Then("the client \"<detail>\" appears")
    public void result_appear (String detail) {
        List<WebElement> panel = driver.findElements(By.className(detail + "panel"));
        assertEquals(1, panel.size());
    }
}
