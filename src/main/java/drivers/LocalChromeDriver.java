package drivers;

import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocalChromeDriver implements DriverSource {
    public WebDriver newDriver() {
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public boolean takesScreenshots() {
        return false;
    }
}
