package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
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

public class Activity1 {
    AndroidDriver driver;
    WebDriverWait wait;
    String res;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options =new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver=new AndroidDriver(serverURL,options);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test(priority =0)
    public void addTasks() {
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Tasks");
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
    }
    @Test(priority = 1)
    public void secondTasks() {
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Keep");
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
    }
    @Test(priority = 2)
    public void thirdTasks() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete the second Activity Google Keep");
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
        Thread.sleep(2000);
        List<WebElement> taskCounts = driver.findElements(AppiumBy.id("com.google.android.apps.tasks:id/task_name"));
        int count=taskCounts.size();
        Assert.assertEquals(3,count);
    }



    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
