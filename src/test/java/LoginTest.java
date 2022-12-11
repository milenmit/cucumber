import LoginPage.LoginPage;
import Utils.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends Browser {

    WebDriver driver = initializeDriver("chrome");
    LoginPage lp = new LoginPage(driver);

    @BeforeTest
    public void setUp() {
        lp.openDemoPage();
    }

    @Test(testName = "Successful login")
    public void loginPage() {
        lp.login("standard_user", "secret_sauce");
        lp.verifyUserIsLoggedIn();
    }

    @AfterTest
    public void stopDriver() {
        tearDown();
    }
}
