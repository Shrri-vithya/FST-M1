package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;
    @BeforeClass
    public void createinstance(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");
        System.out.println("This is before class method in activity2");
    }
    @Test
    public void testmethod1(){
        System.out.println("The title of the page is:" + driver.getTitle());
        String actual = driver.getTitle();
        Assert.assertEquals(actual,"Target Practice");
    }
    @Test
    public void test2() throws Exception{
       WebElement balckbutton= driver.findElement(By.xpath("//button[@class='ui black button']"));
        Assert.assertFalse(balckbutton.isDisplayed());

    }
    @Test(enabled = false)
    public void testmethod3(){
        System.out.println("This is skipped method");
    }
    @Test
    public void testmethod4() throws SkipException{
        System.out.println("this is skipped method using exceptions");

    }

    @AfterTest
    public void closebrowser(){
        driver.close();
        System.out.println("The browser is closed");
    }
}
