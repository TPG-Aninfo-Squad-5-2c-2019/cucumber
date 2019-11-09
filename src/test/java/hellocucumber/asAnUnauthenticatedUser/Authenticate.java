package hellocucumber.asAnUnauthenticatedUser;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class Authenticate {

    WebDriver driver;

    @Given("i am at the sign in page")
    public void i_am_at_the_sign_in_page () {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("/signin");
    }

    @When("i enter my username and password")
    public void i_enter_my_username_and_password () {
        WebElement username_input = driver.findElement(By.name("username"));
        username_input.sendKeys("myusername");
        WebElement password_input = driver.findElement(By.name("password"));
        username_input.sendKeys("password");
    }

    @And("i hit submit")
    public void i_hit_submit () {
        WebElement username_input = driver.findElement(By.name("username"));
        username_input.submit();
    }

    @Then("i am on the home page")
    public void i_am_on_the_home_page () {
        // Thread.sleep(5000);
        assertEquals(driver.getTitle(), "Home");
        driver.quit();
    }
}
