package Products;

import Base.BasePage;
import LoginPage.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ProductSorting extends BasePage {

    private static final By LOC_DROPDOWN_SORTING = By.className("select_container");
    private static final By LOC_PASSWORD = By.id("password");
    private static final By LOC_SUBMIT = By.id("login-button");
    private static final By LOC_MENU = By.id("react-burger-menu-btn");

    public ProductSorting(WebDriver driver) {
        super(driver);
    }

    final Logger LOGGER = LoggerFactory.getLogger(ProductSorting.class);

    public void chooseSorting() {

        List<WebElement> options = getElements(LOC_DROPDOWN_SORTING);
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
    }
    }


