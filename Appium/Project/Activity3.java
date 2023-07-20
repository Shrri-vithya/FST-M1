package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Activity3 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options =new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver=new AndroidDriver(serverURL,options);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    public void addToDoLists() throws InterruptedException {
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        driver.get("https://v1.training-support.net/selenium");
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[contains(@text,'Selenium')]")));
        driver.findElement(AppiumBy.xpath("//android.widget.Button[contains(@text,'Get Started!')]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[3]/android.view.View[1]/android.view.View")));
        Thread.sleep(2000);
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable+".flingForward()"));
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.view.View[contains(@text,'To-Do List')]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[@resource-id='tasksCard']")));
        //String[] tasks={"Add tasks to list","Get number of tasks","Clear the list"};
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']")).sendKeys("Add tasks to list");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[contains(@text,'Add Task')]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("(//android.view.View[@resource-id='tasksList']/android.view.View)[1]")));
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']")).sendKeys("Get number of tasks");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[contains(@text,'Add Task')]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("(//android.view.View[@resource-id='tasksList']/android.view.View)[1]")));
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']")).sendKeys("Clear the list");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[contains(@text,'Add Task')]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("(//android.view.View[@resource-id='tasksList']/android.view.View)[1]")));
        List<WebElement> tasks= driver.findElements(AppiumBy.xpath("//android.view.View[@resource-id='tasksList']/android.view.View"));
        System.out.println("Total number of tasks:" + tasks.size());

        driver.findElement(AppiumBy.xpath("(//android.view.View[@resource-id='tasksList']/android.view.View)[2]")).click();
        driver.findElement(AppiumBy.xpath("(//android.view.View[@resource-id='tasksList']/android.view.View)[3]")).click();
        driver.findElement(AppiumBy.xpath("(//android.view.View[@resource-id='tasksList']/android.view.View)[4]")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id='tasksCard']/android.view.View[3]")).click();

        Thread.sleep(2000);
       /* tasks= driver.findElements(AppiumBy.xpath("//android.view.View[@resource-id='tasksList']/android.view.View"));
        System.out.println("Total number of tasks:" + tasks.size());
        int a=tasks.size();*/
        //Boolean task=driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id='tasksCard']/android.view.View[3]")).isDisplayed();
        //Assert.assertFalse(driver.findElement(AppiumBy.xpath("(//android.view.View[@resource-id='tasksList']/android.view.View)[2]")).isDisplayed(),"false condition");
        //Assert.assertEquals(1,a);
        try{
            tasks= driver.findElements(AppiumBy.xpath("//android.view.View[@resource-id='tasksList']/android.view.View"));
            System.out.println("Total number of tasks:" + tasks.size());
            int a=tasks.size();
            Assert.assertEquals(0,a);
        }
        catch (NoSuchElementException ex){
        }
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
