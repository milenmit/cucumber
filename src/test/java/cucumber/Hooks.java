package cucumber;

import Utils.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks extends Browser {


    @Before
    public static void setupBrowser()  {
        initializeDriver("chrome");
    }

    public WebDriver getDriver() {
        return driver;
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
