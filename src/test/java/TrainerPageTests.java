import org.junit.Test;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TrainerPageTests extends BaseTest {

    @Test
    public void testNavigateToTrainerPage() {
        //Wait<WebDriver> wait = new WebDriverWait(driver, 110);
        
        LoginPage loginPage = new LoginPage(driver);
        UserPage userPage = loginPage.login("pistike-teszt-user", "jelszojelszo1");
        TrainerPage trainerPage = new TrainerPage(2, driver);
        System.out.println(trainerPage.getBodyText());
        //wait.until(d -> d.equals(null));
        assertTrue(trainerPage.getTrainerNameField().getAttribute("value").contains("Gergő edzőke"));
    }

    @Test
    public void testWritingToTextField() {
        LoginPage loginPage = new LoginPage(driver);
        UserPage userPage = loginPage.login("pistike-teszt-user", "jelszojelszo1");
        TrainerPage trainerPage = new TrainerPage(2, driver);
        WebElement textarea = trainerPage.getTrainerFeedbackTextArea();
        textarea.sendKeys("Nanon jo test");
        assertTrue(textarea.getAttribute("value").contains("test"));
    }
}
