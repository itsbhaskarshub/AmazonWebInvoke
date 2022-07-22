package cartTestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "/resources/UserFeatures/AddtoCart.feature",
		glue = {"stepDefination"}
		)

public class TestRunner {

}
