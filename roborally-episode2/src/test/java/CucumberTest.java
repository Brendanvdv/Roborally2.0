import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = {"src/test/resources/newFeatureFiles"}, 
	plugin = {"pretty"},
	publish = true)

public class CucumberTest {

}
