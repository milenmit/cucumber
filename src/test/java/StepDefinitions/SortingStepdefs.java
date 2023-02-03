package StepDefinitions;

import Enums.SortingByAlphabeticallyAndPrice;
import LoginPage.LoginPage;
import Products.ProductSorting;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class SortingStepdefs  {
    private WebDriver driver;
    private  LoginPage loginPage;
    private ProductSorting productSorting;
    private Hooks hooks;
    private final String username="standard_user";
    private final String password="secret_sauce";

    public SortingStepdefs(Hooks hooks) {
        this.driver = hooks.getDriver();
        loginPage = new LoginPage(driver);
        productSorting = new ProductSorting(driver);
    }

    @Given("User is logged in")
    public void userIsLoggedIn() {
        loginPage.openDemoPage();
        loginPage.login(username,password);
    }

    @Then("Sorting menu is available")
    public void sortingMenuIsAvailable() {
        productSorting.verifySortingMenuIsAvailable(true);
    }

    @When("User choose {string} of products")
    public void userChooseOfProducts(String order) {
        SortingByAlphabeticallyAndPrice sortingByAlphabeticallyAndPrice = SortingByAlphabeticallyAndPrice.valueOf(order);
        productSorting.choosePriceSorting(sortingByAlphabeticallyAndPrice);
    }

    @Then("All products are sorted in {string} alphabetically order")
    public void allProductsAreSortedInAlphabeticallyOrder(String order) {
        SortingByAlphabeticallyAndPrice sortingByAlphabeticallyAndPrice = SortingByAlphabeticallyAndPrice.valueOf(order);
        productSorting.verifyAlphabeticallySorting(sortingByAlphabeticallyAndPrice);
    }

    @Then("All products are sorted in {string} price order")
    public void allProductsAreSortedInPriceOrder(String order) {
        SortingByAlphabeticallyAndPrice sortingByAlphabeticallyAndPrice = SortingByAlphabeticallyAndPrice.valueOf(order);
        productSorting.verifyPriceSorting(sortingByAlphabeticallyAndPrice);
    }
}
