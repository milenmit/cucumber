package LoginPage;

import Base.BasePage;
import Utils.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class LoginPage extends BasePage {

    private static final String URL = "https://www.saucedemo.com/";
    private static final By LOC_USERNAME = By.id("user-name");
    private static final By LOC_PASSWORD = By.id("password");
    private static final By LOC_SUBMIT = By.id("login-button");
    private static final By LOC_MENU = By.id("react-burger-menu-btn");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    final Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);

    public void openDemoPage() {
        driver.get(URL);
        LOGGER.info("Page {} is opened", URL);
    }

    public void login(String username, String password) {
        writeText(LOC_USERNAME, username);
        writeText(LOC_PASSWORD, password);
        click(LOC_SUBMIT);
    }

    public void verifyUserIsLoggedIn(boolean loggedIn) {

        Assert.assertEquals(getElement(LOC_MENU).isDisplayed(), loggedIn);
        LOGGER.info("User is logged in");
    }
}
