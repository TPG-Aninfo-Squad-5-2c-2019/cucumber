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

public class ConsultAssignedFounds {
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

    @When("i click on the campaign button")
    public void i_click_on_the_campaign_button () {
        WebElement campaign = driver.findElement(By.name("campaign"));
        campaign_select = new Select(campaign);
    }

    @Then("a menu appears with create or consult options")
    public void a_menu_appears_with_create_or_consult_options () {
        List<WebElement> options = campaign_select.getOptions();
        WebElement create_option = driver.findElement(By.id("create-campaign"));
        WebElement consult_option = driver.findElement(By.id("consult-campaign"));
        assertTrue(options.contains(create_option));
        assertTrue(options.contains(consult_option));
    }

    @And("i have clicked on the campaign button")
    public void i_have_clicked_on_the_campaign_button () {
        WebElement campaign = driver.findElement(By.name("campaign"));
        campaign_select = new Select(campaign);
    }

    @When("i click on consult option")
    public void i_click_on_consult_option () {
        WebElement consult_option = driver.findElement(By.id("consult-campaign"));
        consult_option.click();
    }

    @Then("i am on the campaign page")
    public void i_am_on_the_campaign_page () {
        // Thread.sleep(5000);
        assertEquals(driver.getTitle(), "Campaign");
        driver.quit();
    }

    @And("i navigate to the campaign page")
    public void i_navigate_to_the_campaign_page () {
        driver.get("/campaign");
    }

    @Then("i see a list of all campaigns")
    public void i_see_a_list_of_all_campaigns () {
        List<WebElement> campaigns = driver.findElements(By.className("campaign"));
        assertTrue(campaigns.size() > 0);
    }

    @And("i have permissions for the campaign \"<campaign_name>\"")
    public void i_have_permissions_for_the_campaign (String campaign_name) {

    }

    @When("i click on the consult button of the campaign \"<clicked_campaign>\"")
    public void i_click_on_the_consult_button_of_the_campaign (String clicked_campaign) {
        WebElement campaign = driver.findElement(By.id(clicked_campaign));
        campaign.click();
    }

    @Then("\"<result>\" appear")
    public void result_appear (String result) {
        if (result.equals("the assigned founds")) {
            WebElement assigned_founds = driver.findElement(By.className("campaign-founds"));
            assertTrue(Integer.parseInt(assigned_founds.getText()) > 0);
        } else {
            WebElement error_message = driver.findElement(By.className("error-message"));
            assertEquals(error_message.getText(), "No tiene los permisos necesarios para ver esta seccion");
        }
    }
}
