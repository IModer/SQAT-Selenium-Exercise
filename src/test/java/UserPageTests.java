import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

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

    // Test settings edit

    @Test
    public void testSettingsEditButton() {
        // login first
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("pistike-teszt-user", "jelszojelszo1");

        UserPage userPage = new UserPage(driver);
        WebElement userAccountBtn = userPage.getAccountSettingsButton();
        userAccountBtn.click();
        WebElement userButton = userPage.getAccountEditSaveButton();
        assertTrue(userButton.getText().contains("Változtatások mentése"));
    }

    @Test
    public void testSettingsEditingUserName() throws InterruptedException {
        // login first
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("pistike-teszt-user", "jelszojelszo1");

        UserPage userPage = new UserPage(driver);
        
        userPage.changeAccountSetting
        ("pistike-teszt-user-changed"
        , null
        , null
        , null
        , null);
        
        //userPage = new UserPage(driver);
        WebElement usernamefield = userPage.getSettingsUserNameField();
        
        
        System.out.println(usernamefield.getAttribute("value"));
        //wait.until(d -> d.equals(null));
        assertTrue(usernamefield.getAttribute("value").contains("changed"));
        
        userPage.changeAccountSetting
            ("pistike-teszt-user"
            , null
            , null
            , null
            , null);
            assertTrue(!usernamefield.getAttribute("value").contains("changed"));
        
    }

    @Test
    public void testSettingsEditingRealName() throws InterruptedException {
        // login first
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("pistike-teszt-user", "jelszojelszo1");

        UserPage userPage = new UserPage(driver);
        
        userPage.changeAccountSetting
        (null
        , "Pista"
        , null
        , null
        , null);
        
        //userPage = new UserPage(driver);
        WebElement realnamefield = userPage.getSettingsRealNameField();
        
        
        System.out.println(realnamefield.getAttribute("value"));
        //wait.until(d -> d.equals(null));
        assertTrue(realnamefield.getAttribute("value").contains("Pista"));
        
        userPage.changeAccountSetting
            (null
            , ""
            , null
            , null
            , null);
    }

    @Test
    public void testSettingsEditingEmail() throws InterruptedException {
        Wait<WebDriver> wait = new WebDriverWait(driver, 110);
        // login first
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("pistike-teszt-user", "jelszojelszo1");
        
        UserPage userPage = new UserPage(driver);
        
        //wait.until(d -> d.equals(null));
        userPage.changeAccountSetting
        (null
        , null
        , "test@gmail.hu"
        , null
        , null);
        
        //userPage = new UserPage(driver);
        WebElement emailfield = userPage.getSettingsEmailField();
        
        
        System.out.println(emailfield.getAttribute("value"));
        //wait.until(d -> d.equals(null));
        assertTrue(emailfield.getAttribute("value").contains("test"));
        
        userPage.changeAccountSetting
            (null
            , null
            , "pistike-teszt-user@remelem-ilyen-nincs.hu"
            , null
            , null);
    }

    @Test
    public void testSettingsEditingDate() throws InterruptedException {
        // login first
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("pistike-teszt-user", "jelszojelszo1");

        UserPage userPage = new UserPage(driver);
        
        userPage.changeAccountSetting
        (null
        , null
        , null
        , "01012025"
        , null);
        
        //userPage = new UserPage(driver);
        WebElement datefield = userPage.getSettingsDateField();
        
        
        System.out.println(datefield.getAttribute("value"));
        //wait.until(d -> d.equals(null));
        assertTrue(datefield.getAttribute("value").contains("2025-01-01"));
        
        userPage.changeAccountSetting
            (null
            , null
            , null
            , "1900-01-01"
            , null);
    }

    @Test
    public void testSettingsEditingProfilePic() throws InterruptedException {
        //Wait<WebDriver> wait = new WebDriverWait(driver, 110);
        // login first
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("pistike-teszt-user", "jelszojelszo1");

        UserPage userPage = new UserPage(driver);
        WebElement ppicfield = userPage.getSettingsProfilePicField();
        String inital = ppicfield.getAttribute("src");
 
        //wait.until(d -> d.equals(null));
        userPage.changeAccountSetting
        (null
        , null
        , null
        , null
        , "/home/ppic.jpg");
        //userPage = new UserPage(driver);
        ppicfield = userPage.getSettingsProfilePicField();
        
        System.out.println(ppicfield.getAttribute("src"));
        assertTrue(ppicfield.getAttribute("src") != inital);
        
        userPage.changeAccountSetting
            (null
            , null
            , null
            , null
            , "/home/ppic2.jpg");
    }

}
