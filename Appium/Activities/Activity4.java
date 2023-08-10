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

public class Activity4 {
    AndroidDriver driver;
    WebDriverWait wait;
    String res;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options =new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.dialer");
        options.setAppActivity(".extensions.GoogleDialtactsActivity");
        options.noReset();
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver=new AndroidDriver(serverURL,options);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test(priority =0)
    public void addContact() throws InterruptedException {
        driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[3]/android.widget.TextView")).click();
        wait.until(ExpectedConditions.elementToBeClickable( AppiumBy.id("com.google.android.dialer:id/contact_name")));
        driver.findElement(AppiumBy.id("com.google.android.dialer:id/contact_name")).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@text='First name']")));
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='First name']")).sendKeys("Shrri");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Last name']" )).sendKeys("Vithya");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Phone']" )).sendKeys("9998887770");
        Thread.sleep(3000);
        driver.findElement(AppiumBy.id("com.android.contacts:id/editor_menu_save_button")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.android.contacts:id/large_title")));

        String contactCreated= driver.findElement(AppiumBy.id("com.android.contacts:id/large_title")).getText();
        Assert.assertEquals("Shrri Vithya",contactCreated);
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
