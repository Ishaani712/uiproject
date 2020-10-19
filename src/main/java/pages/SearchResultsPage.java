package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

public class SearchResultsPage extends PageObject {

    @FindBy(tagName = "html")
    WebElementFacade searchResultsLanguage;

    @FindBy(id = "firstHeading")
    WebElementFacade pageHeading;

    @FindBy(css = "nav#p-lang")
    WebElementFacade languagesSection;

    private String languageLink = "li.interwiki-%s a";

    public String getPageLanguage() {
        String languageCode = searchResultsLanguage.getAttribute("lang");
        System.out.print("Search results are displayed in " +languageCode);
        return languageCode;
    }

    public String getPageHeading() {
        return pageHeading.getText();
    }

    public boolean isLanguagesSectionDisplayed() {
        scrollIntoView(languagesSection);
        return languagesSection.isDisplayed();
    }

    public void selectLanguageToView(String languageCode) {
        WebElementFacade languageLink = getLanguageLink(languageCode);
        scrollIntoView(languageLink);
        languageLink.click();
    }

    public boolean isLanguagesLinkDisplayed(String languageCode) {
        WebElementFacade languageLink = getLanguageLink(languageCode);
        scrollIntoView(languageLink);
        return languagesSection.isDisplayed();
    }

    public void scrollIntoView(WebElementFacade webElementFacade) {
        evaluateJavascript("javascript:window.scrollBy(250,350)");
        evaluateJavascript("arguments[0].scrollIntoView();", webElementFacade);
    }

    public WebElementFacade getLanguageLink(String languageCode) {
        WebElementFacade languageLink = find(By.cssSelector(String.format(this.languageLink, languageCode)));
        return languageLink;
    }
}
