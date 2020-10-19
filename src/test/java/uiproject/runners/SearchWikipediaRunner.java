package uiproject.runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"classpath:features"},
        glue = {"uiproject.stepDefs"},
        strict = true,
        monochrome = true)
public class SearchWikipediaRunner {
}
