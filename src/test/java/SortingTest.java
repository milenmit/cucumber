import Enums.Sorting;
import LoginPage.LoginPage;
import Products.ProductSorting;
import Utils.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
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

    @Test(testName = "Sorting Menu Exist")
    public void SortingMenuExist() {
        ps.verifySortingMenuIsAvailable(true);
    }
    @Test(testName = "Sorting Menu")
    public void SortingMenu() {
        ps.chooseSorting(Sorting.PRICE_HIGH_TO_LOW);
    }

  /*  @AfterTest
    public void stopDriver() {
        tearDown();
    }*/
}

