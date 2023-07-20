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

public class Activity2 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options =new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver=new AndroidDriver(serverURL,options);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    public void addNotes(){

        driver.findElement(AppiumBy.accessibilityId("New text note")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("editable_title")));
        driver.findElement(AppiumBy.id("editable_title")).sendKeys("Title for Notes");
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("edit_note_text")));
        driver.findElement(AppiumBy.id("edit_note_text")).sendKeys("Description for Notes");
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();

        Boolean notes=driver.findElement(AppiumBy.id("com.google.android.keep:id/browse_note_interior_content")).isDisplayed();
        Assert.assertEquals(notes,true);
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
