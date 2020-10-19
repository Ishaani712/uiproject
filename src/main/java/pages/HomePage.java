package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageObject {

    @Managed(driver = "chrome")
    WebDriver driver;

    @FindBy(id = "searchInput")
    WebElementFacade searchInputField;

    @FindBy(id = "jsLangLabel")
    WebElementFacade searchLanguageField;

    @FindBy(css = "button[class*='pure-button-primary'] > i")
    WebElementFacade searchButton;

    public void navigateToWikipedia() {
        openAt("https://www.wikipedia.org/");
        getDriver().manage().window().maximize();
    }

    public String getDefaultSearchLanguage() {
        String defaultLanguage = searchLanguageField.getText();
        System.out.print("Default language is " +defaultLanguage);
        return defaultLanguage;
    }

    public void enterSearchString(String searchString) {
        searchInputField.type(searchString);
        System.out.print("Entered " +searchString+ " in search field" );
    }

    public void clickSearchButton() {
        searchButton.click();
    }
}
