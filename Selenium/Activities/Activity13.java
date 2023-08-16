package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity13 {
    public static void main(String[] args) {
             System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
            // Setup the Firefox driver(GeckoDriver)
            WebDriverManager.firefoxdriver().setup();

            // Create a new instance of the Firefox driver
            WebDriver driver = new FirefoxDriver();

            driver.navigate().to("https://v1.training-support.net/selenium/tables");
            System.out.println("Title is:" +driver.getTitle());
            List<WebElement> rows= driver.findElements(By.xpath("//table[@class='ui celled striped table']/tbody/tr"));
            System.out.println("Number of rows in first table:"+rows.size());
            List<WebElement> cols= driver.findElements(By.xpath("//table[@class='ui celled striped table']/tbody/tr[1]/td"));
             System.out.println("Number of cols in first table:"+cols.size());
             System.out.println("The value in Third row cols are");
             List<WebElement> colsdatathirdrow= driver.findElements(By.xpath("//table[@class='ui celled striped table']/tbody/tr[3]/td"));
             for(WebElement cell : colsdatathirdrow)
                  System.out.println(cell.getText());
        System.out.println("The value in second row second cols is");
            WebElement secrowseccol= driver.findElement(By.xpath("//table[@class='ui celled striped table']/tbody/tr[2]/td[2]"));
            System.out.println(secrowseccol.getText());
            driver.quit();

    }
}
