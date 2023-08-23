package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
    WebDriver driver;
    @BeforeClass
    public void createinstance(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/");
        System.out.println("This is before class method in activity1");
    }
    @Test
    public void testmethod1(){
        System.out.println("The title of the page is:" + driver.getTitle());
        String actual = driver.getTitle();
        Assert.assertEquals(actual,"Training Support");

        driver.findElement(By.id("about-link")).click();
        System.out.println("The title of the new page is:" + driver.getTitle());
        String actual1 = driver.getTitle();
        Assert.assertEquals(actual1,"About Training Support");
    }

    @AfterTest
    public void closebrowser(){
        driver.close();
        System.out.println("The browser is closed");
    }
}
