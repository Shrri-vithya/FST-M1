package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;
    @BeforeClass
    public void createInstance() {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
    }
    @Test
    public void testmethod() throws InterruptedException {
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        System.out.println("URL of homepage title");
        System.out.println(driver.findElement(By.xpath("(//a)[1]")).getAttribute("href"));
        Thread.sleep(2000);
    }
    @AfterClass
    public void closeBrowser(){
            driver.quit();
    }
}
