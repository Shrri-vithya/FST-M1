package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity4 {
    WebDriver driver;
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
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("btnAdd")).click();
        driver.findElement(By.id("firstName")).sendKeys("Shrri");
        driver.findElement(By.id("lastName")).sendKeys("Vithya");
        driver.findElement(By.id("btnSave")).click();
        System.out.println("User added");
        Thread.sleep(5000);
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("Shrri");
        driver.findElement(By.id("searchBtn")).click();
        Thread.sleep(5000);
        //Boolean table=driver.findElement(By.id("tableWrapper")).isDisplayed();

        String actual=driver.findElement(By.xpath("//tbody/tr[1]/td[3]/a")).getText();
        Assert.assertEquals(actual,"Shrri");
    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
