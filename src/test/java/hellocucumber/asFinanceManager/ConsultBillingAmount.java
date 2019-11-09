package hellocucumber.asFinanceManager;

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

public class ConsultBillingAmount {
    WebDriver driver;
    Select select_box;

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

    @When("i click on the selection box")
    public void i_click_on_the_selection_box () {
        WebElement selection_box = driver.findElement(By.tagName("select"));
        select_box = new Select(selection_box);
    }

    @Then("a menu appears with billings and project options")
    public void a_menu_appears_with_billings_and_project_options () {
        List<WebElement> options = select_box.getOptions();
        WebElement projects = driver.findElement(By.id("projects"));
        WebElement billings = driver.findElement(By.id("billings"));
        assertTrue(options.contains(projects));
        assertTrue(options.contains(billings));
    }

    @And("i have clicked on the selection box")
    public void i_have_clicked_on_the_selection_box () {
        WebElement selection_box = driver.findElement(By.tagName("select"));
        select_box = new Select(selection_box);
    }

    @When("i click on billings option")
    public void i_click_on_billings_option () {
        WebElement billings = driver.findElement(By.id("billings"));
        billings.click();
    }

    @Then("i am on the billings page")
    public void i_am_on_the_campaign_page () {
        // Thread.sleep(5000);
        assertEquals(driver.getTitle(), "Billings");
        driver.quit();
    }

    @And("i navigate to the billings page")
    public void i_navigate_to_the_billings_page () {
        driver.get("/billings");
    }

    @Then("a menu appears with all the company areas")
    public void a_menu_appears_with_all_the_company_areas () {
        List<WebElement> areas = driver.findElements(By.className("areas"));

        WebElement develop = driver.findElement(By.id("develop"));
        WebElement management_director = driver.findElement(By.id("management director"));
        WebElement marketing = driver.findElement(By.id("marketing"));
        WebElement help_desk = driver.findElement(By.id("help desk"));
        WebElement finance = driver.findElement(By.id("finance"));
        WebElement projects = driver.findElement(By.id("projects"));

        assertTrue(areas.contains(develop));
        assertTrue(areas.contains(management_director));
        assertTrue(areas.contains(marketing));
        assertTrue(areas.contains(help_desk));
        assertTrue(areas.contains(finance));
        assertTrue(areas.contains(projects));
    }

    @And("i click on the \"<area>\" option")
    public void i_click_on_the_area_option (String area) {
        WebElement area_option = driver.findElement(By.id(area));
        area_option.click();
    }

    @When("i click on the consult button of the campaign \"<clicked_area>\"")
    public void i_click_on_the_consult_button_of_the_campaign (String area) {
        WebElement campaign = driver.findElement(By.id(area));
        campaign.click();
    }

    @Then("i am on the \"<area>\" billing page")
    public void i_am_on_the_area_billing_page (String area) {
        assertEquals(driver.getTitle(), "Billings for " + area);
    }
}
