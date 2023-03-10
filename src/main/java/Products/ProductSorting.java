package Products;

import Base.BasePage;
import Enums.SortingByAlphabeticallyAndPrice;
import com.google.common.collect.Ordering;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductSorting extends BasePage {

    private static final By LOC_DROPDOWN_SORTING = By.className("product_sort_container");
    private static final By LOC_INVENTORY_NAME = By.className("inventory_item_name");
    private static final By LOC_INVENTORY_PRICE = By.className("inventory_item_price");
    final Logger LOGGER = LoggerFactory.getLogger(ProductSorting.class);


    public ProductSorting(WebDriver driver) {
        super(driver);
    }

    public void verifySortingMenuIsAvailable(boolean available) {
        Assert.assertEquals(getElement(LOC_DROPDOWN_SORTING).isDisplayed(), available);
    }

    public void choosePriceSorting(SortingByAlphabeticallyAndPrice sort) {
        click(LOC_DROPDOWN_SORTING);
        Select sortingOption = new Select(driver.findElement(LOC_DROPDOWN_SORTING));
        sortingOption.selectByValue(sort.getValue());
        LOGGER.info("User chooses {}",sort.getValue());
    }

    public void verifyPriceSorting(SortingByAlphabeticallyAndPrice sort) {
        List<String> list = new ArrayList<>();
        List<WebElement> item = getElements(LOC_INVENTORY_PRICE);
        for (WebElement items : item) {
            list.add((items.getText().substring(1)));
        }
        List<Double> sortedList = list.stream().map(Double::parseDouble).collect(Collectors.toList());
        LOGGER.info("Price info {} {}",sortedList,sort.getOption());

        switch (sort.getOption()) {
            case "Price (low to high)":
                boolean isSortedLowToHigh = Ordering.natural().isOrdered(sortedList);
                Assert.assertTrue(isSortedLowToHigh, "Ordering low to high is is INCORRECT");
                break;
            case "Price (high to low)":
                boolean isSorted = Ordering.natural().isOrdered(sortedList);
                Assert.assertFalse(isSorted, "Ordering high to low is is INCORRECT");
                break;
            default:
                LOGGER.error("Not correct option for sorting");

        }

    }

    public void chooseAlphabeticallySorting(SortingByAlphabeticallyAndPrice sort) {
        click(LOC_DROPDOWN_SORTING);
        Select sortingOption = new Select(driver.findElement(LOC_DROPDOWN_SORTING));
        sortingOption.selectByValue(sort.getValue());
    }

    public void verifyAlphabeticallySorting(SortingByAlphabeticallyAndPrice sort) {
        List<String> sortedList = new ArrayList<>();
        List<WebElement> item = getElements(LOC_INVENTORY_NAME);
        for (WebElement items : item) {
            sortedList.add((items.getText().substring(11)));

        }
        switch (sort.getOption()) {
            case "Name (A to Z)":
                LOGGER.info("Listed products from A to Z are {}", sortedList);
                boolean isSortedLowToHigh = Ordering.natural().isOrdered(sortedList);
                Assert.assertTrue(isSortedLowToHigh, "Ordering is INCORRECT");
                break;
            case "Name (Z to A)":
                LOGGER.info("Listed products from Z to A are {}", sortedList);
                boolean isSorted = Ordering.natural().isOrdered(sortedList);
                Assert.assertFalse(isSorted, "Ordering is INCORRECT");
                break;
            default:
                LOGGER.error("Not correct option for sorting");


        }
    }
}

