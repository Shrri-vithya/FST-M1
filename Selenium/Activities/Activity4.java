package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
    public static void main(String[] args) {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/target-practice");
        System.out.println("The title of page: "+driver.getTitle());
        System.out.println("the third header text is "+driver.findElement(By.xpath("//h3[@id='third-header']")).getText());
        System.out.println("the Fifth header text color is "+driver.findElement(By.xpath("//h5[@class='ui green header']")).getCssValue("color"));

        System.out.println("the violet color class name is "+driver.findElement(By.xpath("//button[contains(text(),'Violet')]")).getAttribute("class"));
        System.out.println("the grey color box text is "+driver.findElement(By.xpath("//button[contains(text(),'Grey')]")).getText());

        driver.quit();
    }
}
