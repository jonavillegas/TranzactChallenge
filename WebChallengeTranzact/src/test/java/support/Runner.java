package support;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources/features/placeOrderE2E.feature", glue = "definitions",
        tags="@placeOrder", plugin = {"json:target/cucumber-report/cucumber.json"})

public class Runner {

}