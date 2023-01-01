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
    private static final By LOC_ERROR = By.tagName("h3");

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
        LOGGER.info("USer is logged in {}",URL);
    }

    public void verifyUserIsLoggedIn() {

        Assert.assertTrue(getElement(LOC_MENU).isDisplayed());
        LOGGER.info("User is logged in");

    }
    public void verifyUserIsNotLoggedIn() {
        System.out.println(getElement(LOC_ERROR).getText());
        Assert.assertTrue(getElement(LOC_ERROR).isDisplayed());
        LOGGER.info("User is NOT logged in");

    }
}
