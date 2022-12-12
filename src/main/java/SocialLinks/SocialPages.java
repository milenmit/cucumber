package SocialLinks;

import Base.BasePage;
import Enums.SocialPagesIcons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class SocialPages extends BasePage {

    private static final By LOC_TWITTER = By.className("social_twitter1");
    private static final By LOC_FACEBOOK = By.className("social_facebook");
    private static final By LOC_LINKEDIN = By.className("social_linkedin");


    final Logger LOGGER = LoggerFactory.getLogger(SocialPages.class);

    public SocialPages(WebDriver driver) {
        super(driver);
    }

    public void verifySocialLinkIconsExist(SocialPagesIcons icons, boolean available) {
        switch (icons.getName()) {
            case "Twitter":
                Assert.assertEquals(getElement(LOC_TWITTER).isDisplayed(), available, "Icon for Twitter is missing");
                break;
            case "Facebook":
                Assert.assertEquals(getElement(LOC_FACEBOOK).isDisplayed(), available, "Icon for Facebook is missing");
                break;
            case "Linkedin":
                Assert.assertEquals(getElement(LOC_LINKEDIN).isDisplayed(), available, "Icon for Linkedin is missing");
                break;
            default:
                LOGGER.info("Not correct choice");

        }

        /*public void chooseIcon () {
            switch (icons.getName()) {
                case "Twitter":
                    LOGGER.info("Twitter has been selected");
                    getElement(LOC_TWITTER);
                    break;
                case "Facebook":
                    LOGGER.info("Facebook has been selected");
                    getElement(LOC_FACEBOOK);
                    break;
                case "Linkedin":
                    LOGGER.info("Linkedin has been selected");
                    getElement(LOC_LINKEDIN);
                    break;
                default:
                    LOGGER.info("Not correct choice");


            }
        }*/
    }
}
