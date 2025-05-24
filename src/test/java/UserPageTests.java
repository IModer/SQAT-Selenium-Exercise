import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertNotEquals;

public class UserPageTests extends BaseTest {

    @Test
    public void testUserButtonNavigatesToUserPage() {
        // login first
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("pistike-teszt-user", "jelszojelszo1");

        MainPage mainPage = new MainPage(driver);
        WebElement userButton = mainPage.getFelhasznaloGomb();
        assertPageNavigation(userButton, "http://liftzone.hu/?o=fiok");
    }


}
