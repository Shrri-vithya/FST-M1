package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Activity3 {
    WebDriver driver;
    @BeforeClass(alwaysRun = true)
    public void createinstance(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
    }
    @Test
    public void testmethod(){
        System.out.println("The title of the page is:" + driver.getTitle());
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
        driver.findElement(By.xpath("//button[@class='ui button']")).click();
        String expected = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals("Welcome Back, admin",expected);

    }
    @AfterTest(alwaysRun = true)
    public void closebrowser(){
        driver.close();
        System.out.println("The browser is closed");
    }

}
