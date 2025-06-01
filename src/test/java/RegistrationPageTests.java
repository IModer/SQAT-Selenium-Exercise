import org.eclipse.jetty.util.log.Log;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

import static org.junit.Assert.assertTrue;

public class RegistrationPageTests extends BaseTest {
    @Test
    public void testRegistration() {
        Wait<WebDriver> wait = new WebDriverWait(driver, 110);
        Random r = new Random();
        String credUserName = "petitesztuser" + Integer.toString(r.nextInt());
        String credEmail = "petitesztuser" + Integer.toString(r.nextInt()) + "@gmail.com";
        String credPass = "teszt1teszt1";
        RegistrationPage registPage = new RegistrationPage(driver);
        registPage.register
            ( credUserName
            , credEmail
            , credPass
            , "01-01-1990");
        //wait.until(d -> d.equals(null));
        LoginPage loginPage = new LoginPage(driver);
        UserPage userPage = loginPage.login(credUserName, credPass);
        assertTrue(userPage.getBodyText().contains("petiteszt"));
    }
}
