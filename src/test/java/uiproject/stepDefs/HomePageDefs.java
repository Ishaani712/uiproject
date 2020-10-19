package uiproject.stepDefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.HomePageSteps;

public class HomePageDefs {

    @Steps
    HomePageSteps homePageSteps;

    @Given("^I am on Wikipedia$")
    public void iAmOnWikipedia() {
        homePageSteps.openHomePage();
    }

    @And("^I search for \"([^\"]*)\"$")
    public void iSearchFor(String searchString) throws Throwable {
        homePageSteps.searchFor(searchString);
    }

    @And("^The default language is \"([^\"]*)\"$")
    public void theDefaultLanguageIs(String defautLanguage) throws Throwable {
        homePageSteps.checkDefaultLanguage(defautLanguage);
    }
}
