package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Activity9 {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void createinstance() throws InterruptedException {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        System.out.println("Logged in");
        Thread.sleep(5000);
    }
    @Test
    public void testmethod() throws InterruptedException {
        wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        driver.findElement(By.xpath("//ul[@id='sidenav']/li[3]/a")).click();
        List<WebElement> number= driver.findElements(By.xpath("//table[@id='emgcontact_list']/tbody/tr/td[5]"));
        System.out.println("The emergence contact numbers are:");
        for(WebElement s:number){
            System.out.println(s.getText());
        }

    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
