package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity5 {
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
    public void testmethod() {
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        driver.findElement(By.id("btnSave")).click();
        System.out.println("edit btn clicked");
        driver.findElement(By.id("personal_txtEmpFirstName")).clear();
        driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("Shrri");
        driver.findElement(By.id("personal_txtEmpLastName")).clear();
        driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("Vithya");
        driver.findElement(By.id("personal_optGender_2")).click();
        WebElement dropdown= driver.findElement(By.xpath("//select[@id='personal_cmbNation']"));
        Select s=new Select(dropdown);
        s.selectByVisibleText("Indian");
        driver.findElement(By.id("personal_DOB")).clear();
        driver.findElement(By.id("personal_DOB")).sendKeys("1995-01-01");
        driver.findElement(By.id("btnSave")).click();
        System.out.println("Data saved");
    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
