package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity22 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        Actions builder = new Actions(driver);
        driver.navigate().to("https://www.training-support.net/selenium/popups");
        System.out.println("The title of page"+driver.getTitle());
        WebElement signIn = driver.findElement(By.cssSelector("button[class*='orange button']"));
        builder.moveToElement(signIn).build().perform();
        System.out.println("The tooltip msg is:" +signIn.getAttribute("data-tooltip"));

        signIn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dynamic-attributes-form")));

        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        Thread.sleep(2000);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui.green.button")));
        driver.findElement(By.xpath("(//button[@class='ui green button'])[2]")).click();
        //driver.findElement(By.xpath("//button[text()='Log in']")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.id("action-confirmation")).getText());

        driver.quit();

    }
}
