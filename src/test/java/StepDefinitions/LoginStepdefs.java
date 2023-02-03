package StepDefinitions;


import LoginPage.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LoginStepdefs {
    private final WebDriver driver;
    private final LoginPage loginPage;
    private Hooks hooks;

    public LoginStepdefs(Hooks hooks) {
        this.hooks = hooks;
        this.driver = hooks.getDriver();
        this.loginPage = new LoginPage(driver);

    }

    @Given("User navigates to home page")
    public void userNavigatesToHomePage() {
        loginPage.openDemoPage();
    }

    @When("User enters user and password {string} and {string} for login")
    public void userEnterCorrectUserAndPasswordAndForLogin(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("Verify user is logged in")
    public void verifyUserIsLoggedIn() {
        loginPage.verifyUserIsLoggedIn();
    }


    @Then("Verify user is NOT logged in")
    public void verifyUserIsNOTLoggedIn() {
        loginPage.verifyUserIsNotLoggedIn();
    }
}