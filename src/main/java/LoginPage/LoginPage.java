package LoginPage;

import Base.BasePage;
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
    private static final By LOC_ERROR = By.tagName("h3");
    private static final String afterLoginUrl = "https://www.saucedemo.com/inventory.html";
    private static final String beforeLoginUrl = "https://www.saucedemo.com/";


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    final Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);

    public void openDemoPage() {
        driver.get(URL);
        LOGGER.info("Page {} is opened", URL);
    }

    public void login(String username, String password)  {
        writeText(LOC_USERNAME, username);
        writeText(LOC_PASSWORD, password);
        click(LOC_SUBMIT);
        LOGGER.info("User tries to login in {}", URL);
    }

    public void verifyUserIsLoggedIn() {
        Assert.assertEquals(getUrl(), afterLoginUrl, "User is not LOGGED IN");
        LOGGER.info("User is logged in");

    }

    public void verifyUserIsNotLoggedIn() {
        Assert.assertEquals(getUrl(), beforeLoginUrl, "User is LOGGED IN");
        LOGGER.info("User is NOT logged in");

    }
}
