package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "Feature.feature",
        glue = "stepDefinitions",
        monochrome = true,
        plugin = { "pretty", "html:target/cucumber-reports.html" }

)

public class TestRunner {
}
