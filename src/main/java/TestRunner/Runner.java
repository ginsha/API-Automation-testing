package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty", features = "src/test/resources", glue = {
		"src/main/java/RatesAPI" }, monochrome = true, strict = true)
public class Runner {

}
