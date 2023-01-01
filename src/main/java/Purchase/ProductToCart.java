package Purchase;

import Base.BasePage;
import Enums.Products;
import com.google.common.collect.Ordering;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class ProductToCart extends BasePage {
    private static final By LOC_BACKPACK = By.xpath("//div[@class='inventory_item_name' and contains(text(),'Backpack')]");
    private static final By LOC_BIKE_LIGHT = By.xpath("//div[@class='inventory_item_name' and contains(text(),'Bike Light')]");
    private static final By LOC_BOLT_T_SHIRT = By.xpath("//div[@class='inventory_item_name' and contains(text(),'Bolt T-Shirt')]");
    private static final By LOC_FLEECE_JACKET = By.xpath("//div[@class='inventory_item_name' and contains(text(),'Fleece Jacket')]");
    private static final By LOC_ONESIE = By.xpath("//div[@class='inventory_item_name' and contains(text(),'Onesie')]");
    private static final By LOC_T_SHIRT_RED = By.xpath("//div[@class='inventory_item_name' and contains(text(),'T-Shirt (Red)')]");



    final Logger LOGGER = LoggerFactory.getLogger(ProductToCart.class);

    protected ProductToCart(WebDriver driver) {
        super(driver);
    }

    public void addProduct(Products product){
        switch (product.getName()) {
            case "Backpack":
                LOGGER.info("Product {} is selected",product.getName());
                click(LOC_BACKPACK);
                break;
            case "Bike":
                boolean isSorted = Ordering.natural().isOrdered(sortedList);
                Assert.assertFalse(isSorted, "Ordering is INCORRECT");
                break;
            default:
                LOGGER.error("Not correct option");
        click(LOC_BACKPACK);

    }

}
