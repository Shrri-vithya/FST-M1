package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
    public static void main(String[] args) {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net");
        System.out.println("The title of page: "+driver.getTitle());

        WebElement aboutUs = driver.findElement(By.id("about-link"));
        aboutUs.click();

        System.out.println("The title of page: "+driver.getTitle());

        driver.quit();
    }
}
