import Enums.SocialPagesIcons;
import LoginPage.LoginPage;
import SocialLinks.SocialPages;
import Utils.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SocialPagesTest extends Browser {

    WebDriver driver = initializeDriver("chrome");
    LoginPage lp = new LoginPage(driver);
    SocialPages sp = new SocialPages(driver);

    @BeforeTest
    public void setUp() {
        lp.openDemoPage();
        lp.login("standard_user", "secret_sauce");
    }


    @Test(testName="Verify existing social icons")
    public void existingIcons(){
        sp.verifySocialLinkIconsExist(SocialPagesIcons.ICON_TWITTER,true);

    }

}