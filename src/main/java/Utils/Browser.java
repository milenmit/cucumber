package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;


public class Browser {

    private WebDriver driver;
    final Logger LOGGER = LoggerFactory.getLogger(Browser.class);
    protected WebDriver initializeDriver(String browserType) {

        switch (browserType) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                LOGGER.info("Browser from type {} is loaded",browserType);
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                LOGGER.info("Browser from type {} is loaded",browserType);
                break;
            case "IE":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                LOGGER.info("Browser from type {} is loaded",browserType);
                break;
            default:
                LOGGER.error("Not correct choice {} available types are chrome,firefox,ie",browserType);

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

   protected void tearDown(){
        driver.quit();
        LOGGER.info("Closing WebDriver");
   }
}
