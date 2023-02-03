package SocialLinks;

import Base.BasePage;
import Enums.SocialPagesIcons;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;


public class SocialPages extends BasePage {

    private static final By LOC_TWITTER = By.className("social_twitter");
    private static final By LOC_FACEBOOK = By.className("social_facebook");
    private static final By LOC_LINKEDIN = By.className("social_linkedin");
    private static final String TWITTER_URL = "https://twitter.com/saucelabs";
    private static final String FACEBOOK_URL = "https://www.facebook.com/saucelabs";
    private static final String LINKEDIN_URL = "https://www.linkedin.com/";


    final Logger LOGGER = LoggerFactory.getLogger(SocialPages.class);

    public SocialPages(WebDriver driver) {
        super(driver);
    }

    public void verifySocialLinkIconsExist(SocialPagesIcons icons, boolean available) {
        switch (icons.getName()) {
            case "Twitter":
                try {
                    if (!available) {
                        Assert.assertFalse(getElement(LOC_TWITTER).isDisplayed(), "Expected icon is missing but Twitter icon found");
                    }
                    Assert.assertEquals(getElement(LOC_TWITTER).isDisplayed(), available);
                    LOGGER.info("Twitter icon found");

                } catch (NoSuchElementException e) {
                    Assert.fail("Icon for Twitter is missing");
                }

                break;
            case "Facebook":
                try {
                    if (!available) {
                        Assert.assertFalse(getElement(LOC_FACEBOOK).isDisplayed(), "Expected icon is missing but Facebook icon found");
                    }
                    Assert.assertEquals(getElement(LOC_FACEBOOK).isDisplayed(), available);
                    LOGGER.info("Facebook icon found");

                } catch (NoSuchElementException e) {
                    Assert.fail("Icon for Facebook is missing");
                }
                break;
            case "Linkedin":
                try {
                    if (!available) {
                        Assert.assertFalse(getElement(LOC_LINKEDIN).isDisplayed(), "Expected icon is missing but Linkedin icon found");
                    }
                    Assert.assertEquals(getElement(LOC_LINKEDIN).isDisplayed(), available);
                    LOGGER.info("Linkedin icon found");

                } catch (NoSuchElementException e) {
                    Assert.fail("Icon for Linkedin is missing");

                }
                break;
            default:
                LOGGER.info("Not correct choice");

        }
    }

    public void verifySocialIconLink(SocialPagesIcons icons) {

        switch (icons.getName()) {

            case "Twitter":
                LOGGER.info("Twitter has been selected");
                click(LOC_TWITTER);
                wait.until(ExpectedConditions.urlContains("sauce"));
                String currentTwitterUrl = manageWindows();
                LOGGER.info("Current opened page is {}",currentTwitterUrl);
                Assert.assertEquals(currentTwitterUrl, TWITTER_URL);
                break;
            case "Facebook":
                LOGGER.info("Facebook has been selected");
                click(LOC_FACEBOOK);
                wait.until(ExpectedConditions.urlContains("sauce"));
                String currentFacebookUrl = manageWindows();
                LOGGER.info("Current opened page is {}",currentFacebookUrl);
                Assert.assertEquals(currentFacebookUrl, FACEBOOK_URL);
                break;
            case "Linkedin":
                LOGGER.info("Linkedin has been selected");
                click(LOC_LINKEDIN);
                wait.until(ExpectedConditions.urlContains("sauce"));
                String currentLinkedinUrl = manageWindows();
                LOGGER.info("Current opened page is {}",currentLinkedinUrl);
                Assert.assertTrue(currentLinkedinUrl.contains(LINKEDIN_URL));
                break;
            default:
                LOGGER.info("Not correct choice");
        }
    }

}