import org.junit.Test;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TimetablePageTests extends BaseTest {
    
    @Test
    public void testNavigateToTimeTable() {
        LoginPage loginPage = new LoginPage(driver);
        UserPage userPage = loginPage.login("pistike-teszt-user", "jelszojelszo1");
        TimetablePage timetablepage = new TimetablePage(2, driver);
        assertTrue(timetablepage.getBodyText().contains("Időpont foglalás"));
    }
}
