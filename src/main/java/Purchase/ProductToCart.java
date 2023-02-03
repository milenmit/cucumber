package Purchase;

import Base.BasePage;
import Enums.Products;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;


public class ProductToCart extends BasePage {
    private static final By LOC_BACKPACK_ITEM = By.xpath("//div[@class='inventory_item_name' and contains(text(),'Backpack')]");
    private static final By LOC_BIKE_LIGHT = By.xpath("//div[@class='inventory_item_name' and contains(text(),'Bike Light')]");
    private static final By LOC_BOLT_T_SHIRT = By.xpath("//div[@class='inventory_item_name' and contains(text(),'Bolt T-Shirt')]");
    private static final By LOC_FLEECE_JACKET = By.xpath("//div[@class='inventory_item_name' and contains(text(),'Fleece Jacket')]");
    private static final By LOC_ONESIE = By.xpath("//div[@class='inventory_item_name' and contains(text(),'Onesie')]");
    private static final By LOC_SHOPPING_CART_LINK = By.id("shopping_cart_container");
    private static final By LOC_ADD_PRODUCT_TO_CART = By.name("add-to-cart-sauce-labs-backpack");
    private static final By LOC_REMOVE_PRODUCT_TO_CART = By.name("remove-sauce-labs-backpack");
    private static final By LOC_SHOPPING_CART_BADGE = By.id("shopping_cart_container");
    private static final By LOC_SHOPPING_CART_ITEMS = By.className("cart_list");
    private static final By LOC_BACK_TO_PRODUCTS = By.id("back-to-products");
    private static final By LOC_PRODUCT_REMOVE_FROM_CART = By.className("removed_cart_item");


    final Logger LOGGER = LoggerFactory.getLogger(ProductToCart.class);

    public ProductToCart(WebDriver driver) {
        super(driver);
    }

    public void addProduct(Products product) {
        switch (product.getName()) {
            case "Sauce Backpack":
                LOGGER.info("Product {} is selected", product.getName());
                click(LOC_BACKPACK_ITEM);
                click(LOC_ADD_PRODUCT_TO_CART);
                LOGGER.info("Product {} is added to cart", product.getName());
                break;
            case "Bike":
                break;
            default:
                LOGGER.error("Not correct option");


        }
    }


    public void navigateToShoppingCart() {
        click(LOC_SHOPPING_CART_LINK);
        LOGGER.info("Navigated to user cart page");
    }

    public void navigateToProducts() {
        click(LOC_BACK_TO_PRODUCTS);
        LOGGER.info("Navigated to user to products page");
    }


    public void removeProduct() {
        click(LOC_REMOVE_PRODUCT_TO_CART);
        LOGGER.info("Product is removed from cart");
    }

    public void verifyBadgeIndicator(int badgeNumber) {
        int actualNumber;
        String number = (getElement(LOC_SHOPPING_CART_BADGE).getText());
        if (number.isEmpty()) {
            actualNumber = 0;

        } else {
            actualNumber = Integer.parseInt(number);
        }
        LOGGER.info("Badge number is {}", actualNumber);
        Assert.assertEquals(actualNumber, badgeNumber, "Badge number is incorrect");
    }


    //method works only if there is 1 product in the cart//
    public void verifyProductIsRemovedFromCart() {
        Boolean isPresent = getElements(LOC_PRODUCT_REMOVE_FROM_CART).size() > 0;
        Assert.assertEquals(isPresent, true, "Product is not removed from cart");
        LOGGER.info("{}", isPresent);
    }
}
