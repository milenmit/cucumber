import Enums.SortingByAlphabetically;
import Enums.SortingByPrice;
import LoginPage.LoginPage;
import Products.ProductSorting;
import Utils.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SortingTest extends Browser {

    WebDriver driver = initializeDriver("chrome");
    LoginPage lp = new LoginPage(driver);
    ProductSorting ps = new ProductSorting(driver);

    @BeforeClass
    public void setUp() {
        lp.openDemoPage();
        lp.login("standard_user", "secret_sauce");
    }

    @Test(testName = "Sorting Menu Exist" ,priority = 1)
    public void SortingMenuExist() {
        ps.verifySortingMenuIsAvailable(true);
    }
    @Test(testName = "Sorting Menu ASCENDING",priority = 2)
    public void SortingMenuAscending() {
        ps.choosePriceSorting(SortingByPrice.PRICE_LOW_TO_HIGH);
        ps.verifyPriceSorting(SortingByPrice.PRICE_LOW_TO_HIGH);
    }
    @Test(testName = "Sorting Menu DESCENDING" , priority = 3)
    public void SortingMenuDescending() {
        ps.choosePriceSorting(SortingByPrice.PRICE_HIGH_TO_LOW);
        ps.verifyPriceSorting(SortingByPrice.PRICE_HIGH_TO_LOW);
    }
    @Test(testName = "Sorting Menu Alphabetically A-Z" , priority = 4)
    public void SortingMenuDAlphabeticallyAtoZ() {
        ps.chooseAlphabeticallySorting(SortingByAlphabetically.NAME_A_TO_Z);
        ps.verifyAlphabeticallySorting();
    }
/*
    @AfterTest
    public void stopDriver() {
        tearDown();
    }*/
}

