import Enums.SocialPagesIcons;
import LoginPage.LoginPage;
import SocialLinks.SocialPages;
import Utils.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
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


    @Test(testName = "Verify existing social icons")
    public void existingIcons() {
        sp.verifySocialLinkIconsExist(SocialPagesIcons.ICON_TWITTER, true);
        sp.verifySocialLinkIconsExist(SocialPagesIcons.ICON_FACEBOOK, true);
        sp.verifySocialLinkIconsExist(SocialPagesIcons.ICON_LINKEDIN, true);

    }

    @Test(testName = "Verify opened page social icons")
    public void openSocialPageIcons() {
        sp.verifySocialIconLink(SocialPagesIcons.ICON_TWITTER);
        sp.verifySocialIconLink(SocialPagesIcons.ICON_FACEBOOK);
        sp.verifySocialIconLink(SocialPagesIcons.ICON_LINKEDIN);
    }

    @AfterTest
    public void stopDriver() {
        tearDown();
    }


}