package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity7 {
    WebDriver driver;
    @BeforeClass
    public void createinstance() throws InterruptedException {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("http://alchemy.hguy.co/orangehrm");
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        System.out.println("Logged in");
        Thread.sleep(5000);
    }
    @Test
    public void testmethod() throws InterruptedException {
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("//ul[@id='sidenav']/li[9]/a")));
        WebElement a=driver.findElement(By.xpath("//ul[@id='sidenav']/li[9]/a"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",a);
        js.executeScript("arguments[0].click();",a);
       Thread.sleep(5000);
        driver.findElement(By.id("addWorkExperience")).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("experience_employer")));
        driver.findElement(By.id("experience_employer")).sendKeys("ABC");
        driver.findElement(By.id("experience_jobtitle")).sendKeys("Tester");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnWorkExpSave")));
        driver.findElement(By.id("btnWorkExpSave")).click();

        Boolean actual=driver.findElement(By.cssSelector(".message.success.fadable")).isDisplayed();
        if(actual==true){
            System.out.println("Successfully saved");
        }
    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
