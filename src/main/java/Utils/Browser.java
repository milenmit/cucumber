package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;


public class Browser {

     static protected WebDriver driver;
    private static final Logger LOGGER = LoggerFactory.getLogger(Browser.class);

    public static WebDriver  initializeDriver(String browserType) {

        switch (browserType) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                LOGGER.info("Browser from type {} is loaded", browserType);
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                LOGGER.info("Browser from type {} is loaded", browserType);
                break;
            case "IE":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                LOGGER.info("Browser from type {} is loaded", browserType);
                break;
            case "Safari":
                WebDriverManager.iedriver().setup();
                driver = new SafariDriver();
                LOGGER.info("Browser from type {} is loaded", browserType);
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                LOGGER.info("Default browser from type {} is loaded", browserType);

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }

    protected void tearDown() {
        driver.quit();
        LOGGER.info("Closing WebDriver");
    }


}
