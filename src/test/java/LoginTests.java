import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginTests extends BaseTest {

    @Test
    public void testLoginWithGoodCred() {
        LoginPage loginPage = new LoginPage(driver);
        UserPage userPage = loginPage.login("pistike-teszt-user", "jelszojelszo1");
        Assert.assertTrue(userPage.getBodyText().contains("@pistike-teszt-user"));
        Assert.assertTrue(userPage.getBodyText().contains("Szerkesztés"));
    }

    @Test
    public void testLoginWithBadCredUsername() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("bad-username", "bad-password");
        Assert.assertTrue(loginPage.getBodyText().contains("Helytelen belépési adatok!!"));
    }

    @Test
    public void testLoginWithBadCredPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("pistike-test-user", "bad-password");
        Assert.assertTrue(loginPage.getBodyText().contains("Helytelen belépési adatok!!"));
    }

    @Test
    public void testLoginEmptyCred() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "");
        Assert.assertTrue(loginPage.getBodyText().contains("Helytelen belépési adatok!!"));
    }

}
