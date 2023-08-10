package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.PriorityQueue;

public class Activity3 {
    AndroidDriver driver;
    WebDriverWait wait;
    String res;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options =new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.calculator2");
        options.setAppActivity(".Calculator");
        options.noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver=new AndroidDriver(serverURL,options);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(priority =0)
    public void addTest() {
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("plus")).click();
        driver.findElement(AppiumBy.id("digit_9")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
        res = driver.findElement(AppiumBy.id("result")).getText();
        System.out.println("5+9= " + res);
        Assert.assertEquals(res, "14");
    }
    @Test(priority=1)
    public void subtractTest() {
            driver.findElement(AppiumBy.id("digit_1")).click();
            driver.findElement(AppiumBy.id("digit_0")).click();
            driver.findElement(AppiumBy.accessibilityId("minus")).click();
            driver.findElement(AppiumBy.id("digit_5")).click();
            driver.findElement(AppiumBy.accessibilityId("equals")).click();
            res = driver.findElement(AppiumBy.id("result")).getText();
            System.out.println("10-5 = " + res);
            Assert.assertEquals(res, "5");
        }

        @Test(priority=2)
        public void multiplyTest() {
            driver.findElement(AppiumBy.id("digit_5")).click();
            driver.findElement(AppiumBy.accessibilityId("multiply")).click();
            driver.findElement(AppiumBy.id("digit_1")).click();
            driver.findElement(AppiumBy.id("digit_0")).click();
            driver.findElement(AppiumBy.id("digit_0")).click();
            driver.findElement(AppiumBy.accessibilityId("equals")).click();
            res = driver.findElement(AppiumBy.id("result")).getText();
            System.out.println("5*100 = " + res);
            Assert.assertEquals(res, "500");
        }
        @Test(priority=3)
         public void divisionTest() {
            driver.findElement(AppiumBy.id("digit_5")).click();
            driver.findElement(AppiumBy.id("digit_0")).click();
            driver.findElement(AppiumBy.accessibilityId("divide")).click();
            driver.findElement(AppiumBy.id("digit_2")).click();
            driver.findElement(AppiumBy.accessibilityId("equals")).click();
            res = driver.findElement(AppiumBy.id("result")).getText();
            System.out.println("50/2 = "+res);
            Assert.assertEquals(res, "25");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();

    }
}
