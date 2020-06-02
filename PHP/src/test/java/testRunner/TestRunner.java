package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\features", glue = "src\\test\\java\\stepDefinitions", tags = "@Test", plugin = {
		"html:target/cucumber-html-report", "pretty:target/cucumber-pretty.txt" })
//		plugin = "pretty")
public class TestRunner {

}
