package hellocucumber.asFinanceManager;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class IncomeAndExpensesScheduling {
    WebDriver driver;

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

    @When("i click on the schedule button")
    public void i_click_on_the_schedule_button () {
        WebElement schedule_button = driver.findElement(By.name("schedule"));
        schedule_button.click();
    }

    @Then("i am on the income & expenses page")
    public void i_am_on_the_income_and_expenses_page () {
        // Thread.sleep(5000);
        assertEquals(driver.getTitle(), "Income & expenses");
        driver.quit();
    }

    @And("i navigate to the income & expenses page")
    public void i_navigate_to_the_billings_page () {
        driver.get("/income&expenses");
    }

    @Then("i see a calendar in the actual month")
    public void i_see_a_calendar_in_the_actual_month () {
        WebElement calendar = driver.findElement(By.className("calendar"));
        WebElement actualMonth = calendar.findElement(By.className("month"));

        // Getting current month name
        String[] monthName = {"January", "February",
                "March", "April", "May", "June", "July",
                "August", "September", "October", "November",
                "December"};

        Calendar cal = Calendar.getInstance();
        String expectedMonth = monthName[cal.get(Calendar.MONTH)];

        assertEquals(expectedMonth, actualMonth.getText());
    }

    @And("i click on the previous button")
    public void i_click_on_the_previous_button () {
        WebElement previous_button = driver.findElement(By.id("previous-month"));
        previous_button.click();
    }

    @Then("i see a calendar in the previous month")
    public void i_see_a_calendar_in_the_previous_month () {
        WebElement calendar = driver.findElement(By.className("calendar"));
        WebElement actualMonth = calendar.findElement(By.className("month"));

        // Getting current month name
        String[] monthName = {"January", "February",
                "March", "April", "May", "June", "July",
                "August", "September", "October", "November",
                "December"};

        Calendar cal = Calendar.getInstance();
        String expectedMonth = monthName[cal.get(Calendar.MONTH) - 1];

        assertEquals(expectedMonth, actualMonth.getText());
    }

    @When("i click on the go to today button")
    public void i_click_on_the_go_to_today_button () {
        WebElement today_button = driver.findElement(By.id("go-to-today"));
        today_button.click();
    }
}
