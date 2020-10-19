package steps;

import constants.Language;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
import pages.SearchResultsPage;

import static sessionVariables.SessionVariables.*;

public class SearchResultsSteps extends ScenarioSteps {

    SearchResultsPage searchResultsPage;

    @Step
    public void verifySearchResultsLanguage() {
        String expectedLanguage = Serenity.sessionVariableCalled(SEARCHLANGUAGE);
        String actualLanguage = searchResultsPage.getPageLanguage();
        Assert.assertTrue("Search results are not returned in the expected language "+expectedLanguage, actualLanguage.equalsIgnoreCase(expectedLanguage));
   }

    @Step
    public void verifySearchResultsContent() {
        String expectedContent = Serenity.sessionVariableCalled(SEARCHSTRING);
        String actualContent = searchResultsPage.getPageHeading();
        Assert.assertTrue("Search did not return results for " +expectedContent, actualContent.equalsIgnoreCase(expectedContent));
    }

    @Step
    public void verifyIfLanguagesSectionIsDisplayed() {
        Assert.assertTrue("Languages section is not available", searchResultsPage.isLanguagesSectionDisplayed());
    }

    @Step
    public void selectLanguageToViewContent(String language) {
        String languageCode = Language.getLanguageCode(language).name();
        searchResultsPage.selectLanguageToView(languageCode);
        Serenity.setSessionVariable(SEARCHLANGUAGE).to(languageCode);
    }

    public void verifyIfLanguageLinkIsDisplayed(String language) {
        String languageCode = Language.getLanguageCode(language).name();
        Assert.assertTrue("Languages link is not available for " +language , searchResultsPage.isLanguagesLinkDisplayed(languageCode));
        System.out.print("Link for "  + language + " is displayed");
    }
}
