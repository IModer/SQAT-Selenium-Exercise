import org.junit.Test;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ShopPageTests extends BaseTest {
    
    @Test
    public void testSwitchingtoPasses() {
        ShopPage shopPage = new ShopPage(driver);
        WebElement swchbtn = shopPage.getSwitchToPassesButton();
        swchbtn.click();
        assertTrue(shopPage.getBodyText().contains("Havi bérlet"));
    }
    
    @Test
    public void testSwitchingtoProducts() {
        ShopPage shopPage = new ShopPage(driver);
        shopPage.navigate("http://liftzone.hu/?o=shop&view=passes");
        WebElement swchbtn = shopPage.getSwitchToProductsButton();
        swchbtn.click();
        assertTrue(shopPage.getBodyText().contains("Whey Pink - LiftZone"));
    }
    
}
