package uiproject.stepDefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.SearchResultsSteps;

public class SearchResultsDefs {

    @Steps
    SearchResultsSteps searchResultsSteps;

    @And("^There is languages section displayed$")
    public void thereIsLanguagesSectionDisplayed() {
        searchResultsSteps.verifyIfLanguagesSectionIsDisplayed();
    }

    @When("^I select \"([^\"]*)\"$")
    public void iSelect(String language) throws Throwable {
       searchResultsSteps.selectLanguageToViewContent(language);
    }

    @Then("^Search results are displayed in the chosen language$")
    public void searchResultsAreDisplayedInTheChosenLanguage() {
        searchResultsSteps.verifySearchResultsLanguage();
    }

    @And("^I see an option to view results in \"([^\"]*)\"$")
    public void iSeeAnOptionToViewResultsIn(String language) throws Throwable {
        searchResultsSteps.verifyIfLanguageLinkIsDisplayed(language);
    }

    @Then("^Relevant content is displayed$")
    public void relevantContentIsDisplayed() {
        searchResultsSteps.verifySearchResultsLanguage();
        searchResultsSteps.verifySearchResultsContent();
    }
}
