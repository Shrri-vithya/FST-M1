package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
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
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver=new AndroidDriver(serverURL,options);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testMethod() throws InterruptedException {
        driver.get("https://v1.training-support.net/");
        Thread.sleep(3000);
                String pageTitle = driver.findElement(AppiumBy.xpath(
                "//android.view.View[@text='Training Support']")).getText();
        System.out.println("Heading: " + pageTitle);
        String aboutUsHeading = driver.findElement(AppiumBy.xpath(
                "//android.view.View[@text='About Us']")).getText();
        System.out.println(aboutUsHeading);
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
