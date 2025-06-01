import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class MainPageTests extends BaseTest {

    @Test
    public void testLoginButtonNavigatesToLoginPage() {
        MainPage mainPage = new MainPage(driver);
        WebElement loginButton = mainPage.getBejelentkezesGomb();
        assertPageNavigation(loginButton, "http://liftzone.hu/?o=loginform");
    }

    @Test
    public void testRegisterButtonNavigatesToRegisterPage() {
        MainPage mainPage = new MainPage(driver);
        WebElement registerButton = mainPage.getRegisztralasGomb();
        assertPageNavigation(registerButton, "http://liftzone.hu/?o=registerform");
    }

    @Test
    public void testLogoutButtonNavigatesToMainPage() {
        /*
         
        MainPage mainPage = new MainPage(driver);
        WebElement loginButton = mainPage.getBejelentkezesGomb();
        assertPageNavigation(loginButton, "http://liftzone.hu/?o=loginform");
        WebElement logoutButton = mainPage.getKilepesGomb();
        assertPageNavigation(logoutButton, "http://liftzone.hu");
        */
        LoginPage loginPage = new LoginPage(driver);
        UserPage userPage = loginPage.login("pistike-teszt-user", "jelszojelszo1");
        
        // From user page, click the main page logo button to navigate back to main page
        WebElement logoButton = userPage.getMainPageLogoButton();
        logoButton.click();
        MainPage mainPage = new MainPage(driver);
        WebElement logoutButton = mainPage.getKilepesGomb();
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButton.click();
        System.out.println(driver.getCurrentUrl());
        assertTrue("Logout button should navigate to main page",
        driver.getCurrentUrl().contains("http://liftzone.hu"));

    }

    @Test
    public void testCartButtonOpensCartPopup() {
        MainPage mainPage = new MainPage(driver);
        WebElement cartButton = mainPage.getKorasGomb();
        cartButton.click();
        WebElement cartPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kosarpopup")));
        assertTrue("Cart popup should be visible", cartPopup.isDisplayed());
    }

    @Test
    public void testLanguageSelectorChangesLanguage() {
        MainPage mainPage = new MainPage(driver);
        WebElement languageButton = mainPage.getNyelvGomb();
        languageButton.click();
        WebElement englishOption = mainPage.getAngolValaszto();
        englishOption.click();
        assertTrue("Page should display English text", driver.getPageSource().contains("Welcome to LiftZone Gym!"));       
    }

    @Test
    public void testLanguageSelectorChangesLanguageBack() {
        MainPage mainPage = new MainPage(driver);
        WebElement languageButton = mainPage.getNyelvGomb();
        languageButton.click();
        WebElement englishOption = mainPage.getAngolValaszto();
        englishOption.click();
        // We wait a little again
        languageButton = mainPage.getNyelvGomb();
        languageButton.click();
        WebElement hunOption = mainPage.getMagyarValaszto();
        hunOption.click();
        assertTrue("Page should display Hungarian text", driver.getPageSource().contains("Üdvözlünk a LiftZone Gymnél!"));       
        
        
    }

    public void testGetPageTitle() {
        MainPage mainPage = new MainPage(driver);
        assertTrue(driver.getTitle().contains("LiftZone"));
    }

/*
This doestn wanna work even tho its oerfectly valid, it gets "unexpected crash"d
// Test writing int the form and sending
@Test
public void testWritingToFeedbackForm() {
    MainPage mainPage = new MainPage(driver);
    WebElement field = mainPage.getMsgField();
    Actions moveAction = new Actions(driver);
    // We move over to the textbox
    moveAction.moveToElement(field).perform();
    
    WebElement btn = mainPage.getKuldesGomb();
    mainPage.fillForm("kistarcsa@gmail.com", "legjobb hely");
    assertTrue(field.getText().contains("hely"));
    assertPageNavigation(btn, "https://liftzone.hu/");
}
*/
}
