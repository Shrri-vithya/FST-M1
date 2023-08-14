package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"StepDefinitions"},
        tags = "@SmokeTest",
        //plugin={"pretty"},
        monochrome = true,
        plugin={"html:test-reports/test-report.html"}
        //plugin = {"json: test-reports/json-report.json"}
)

public class TestRunner {
    //Nothing is written here
}
