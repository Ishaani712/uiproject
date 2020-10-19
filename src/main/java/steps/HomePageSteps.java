package steps;

import constants.Language;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
import pages.HomePage;

import static sessionVariables.SessionVariables.SEARCHLANGUAGE;
import static sessionVariables.SessionVariables.SEARCHSTRING;

public class HomePageSteps extends ScenarioSteps {

    HomePage homePage;

    @Step
    public void openHomePage() {
        homePage.navigateToWikipedia();
    }

    @Step
    public void checkDefaultLanguage(String language) {
        String languageCode = Language.getLanguageCode(language).name();
        Assert.assertTrue("Default Language is not English on Wikipedia", homePage.getDefaultSearchLanguage().equalsIgnoreCase(languageCode));
        Serenity.setSessionVariable(SEARCHLANGUAGE).to(languageCode);
    }

    @Step
    public void searchFor(String searchString) {
        homePage.enterSearchString(searchString);
        homePage.clickSearchButton();
        Serenity.setSessionVariable(SEARCHSTRING).to(searchString);
    }
}
