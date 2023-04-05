package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", 
                 glue = { "stepdefinition" }, 
                 plugin = { "pretty","html:target/reports.html"})

public class TestRunner {

}