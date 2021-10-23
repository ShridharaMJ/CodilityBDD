package runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/java/resource/feature/TestScenario.feature"}, 
glue= {"stepDefinations"},
monochrome=true,tags= {},
plugin= {"pretty","html:target-report/html","json:targer/cucumber.json"}
		)
public class MainRunner  {

}
