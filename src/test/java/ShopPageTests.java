import org.junit.Test;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ShopPageTests extends BaseTest {

    /* @Test
    public void testAddProductToCart() {
        driver.get("http://liftzone.hu/?o=shop");
        ShopPage shopPage = new ShopPage(driver);

        WebElement category = shopPage.getProductCategory("Supplements");
        assertTrue(category.isDisplayed());

        WebElement product = shopPage.getProductItem("Protein Powder");
        assertTrue(product.isDisplayed());

        WebElement addToCartButton = shopPage.getAddToCartButton("Protein Powder");
        addToCartButton.click();

        WebElement cartIcon = shopPage.getCartIcon();
        assertTrue(cartIcon.isDisplayed());

        cartIcon.click();

        WebElement checkoutButton = shopPage.getCheckoutButton();
        assertTrue(checkoutButton.isDisplayed());
    } */
}
