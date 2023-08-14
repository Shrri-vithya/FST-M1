package StepDefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class GoogleSearchSteps {
    WebDriverWait wait;
    WebDriver driver;
    @Given("^User is on Google Home Page$")
    public void user_is_on_Home_Page()  throws Throwable{
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
       // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
    }

    @When("^User types in Cheese and hits ENTER$")
    public void userTypesCheese() throws Throwable {
        driver.findElement(By.id("APjFqb")).sendKeys("Cheese", Keys.RETURN);
    }

    @Then("^Show how many search results were shown$")
    public void show_how_many_search_results_were_shown() throws Throwable {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result-stats")));
        System.out.println(driver.findElement(By.id("result-stats")).getText());
    }
    @And("^Close the browser$")
    public void closeBrowser() throws Throwable{
        driver.quit();
    }

}
