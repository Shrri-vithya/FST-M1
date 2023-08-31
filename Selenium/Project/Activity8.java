package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class Activity8 {
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
        wait= new WebDriverWait(driver,Duration.ofSeconds(5));
        driver.findElement(By.xpath("//tbody/tr[1]/td[4]/div/a")).click();
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='applyleave_txtLeaveType']"));
        Select s= new Select(dropdown);
        s.selectByValue("1");
        driver.findElement(By.id("applyleave_txtFromDate")).clear();
        driver.findElement(By.id("applyleave_txtFromDate")).sendKeys("2023-07-04");
        driver.findElement(By.id("applyleave_txtToDate")).clear();
        driver.findElement(By.id("applyleave_txtToDate")).sendKeys("2023-07-04");
        driver.findElement(By.id("applyBtn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_leave_viewLeaveModule")));
        driver.findElement(By.id("menu_leave_viewLeaveModule")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_leave_viewMyLeaveList")));
        driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
        String status= driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[1]/td[6]/a")).getText();
        if(status.contains("Pending Approval")){
            System.out.println("Status matched");
        }else{
            System.out.println("Status not matched");
        }
    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
