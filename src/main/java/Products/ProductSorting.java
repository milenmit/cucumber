package Products;

import Base.BasePage;
import Enums.Sorting;
import LoginPage.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.List;

public class ProductSorting extends BasePage {

    private static final By LOC_DROPDOWN_SORTING = By.className("product_sort_container");
    final Logger LOGGER = LoggerFactory.getLogger(ProductSorting.class);
        Actions action = new Actions(driver);

    public ProductSorting(WebDriver driver) {
        super(driver);
    }

    public void verifySortingMenuIsAvailable(boolean available){
        Assert.assertEquals(getElement(LOC_DROPDOWN_SORTING).isDisplayed(), available);
    }
    public void chooseSorting(Sorting sort) {
        click(LOC_DROPDOWN_SORTING);
            Select sortingOption = new Select(driver.findElement(LOC_DROPDOWN_SORTING));
            sortingOption.selectByValue(sort.getValue());
        }

    }




