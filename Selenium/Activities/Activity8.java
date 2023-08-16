package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity8 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        driver.navigate().to("https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println("The title of page"+driver.getTitle());

        WebElement checkbox= driver.findElement(By.id("dynamicCheckbox"));

        driver.findElement(By.id("toggleCheckbox")).click();
        wait.until(ExpectedConditions.invisibilityOf(checkbox));
        System.out.println("checkbox appears?"+checkbox.isDisplayed());

        driver.findElement(By.id("toggleCheckbox")).click();
        wait.until(ExpectedConditions.visibilityOf(checkbox));
        System.out.println("checkbox appears?"+checkbox.isDisplayed());

        driver.close();

    }
}
