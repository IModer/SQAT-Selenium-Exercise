import org.junit.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class LoginPageTests extends BaseTest {

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

    @Test
    public void testLoginPagefourofour() {
        // We start from the login page and log in
        LoginPage loginPage = new LoginPage(driver);
        UserPage userPage = loginPage.login("pistike-teszt-user", "jelszojelszo1");
        // Then navigate back
        driver.navigate().back();
        // Wait untill we are back at the login page
        String expectedUrl = "https://liftzone.hu/?o=loginform";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        assertNotEquals("URL didn't change to " + expectedUrl, expectedUrl, driver.getCurrentUrl());
        // Test if we 404d
        assertTrue(loginPage.getBodyText().contains("404"));
    }

}
