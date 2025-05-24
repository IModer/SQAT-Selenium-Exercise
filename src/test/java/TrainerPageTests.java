import org.junit.Test;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TrainerPageTests extends BaseTest {
    /*
    
    @Test
    public void testTrainerPageElements() {
        driver.get("http://liftzone.hu/?o=trainer");
        TrainerPage trainerPage = new TrainerPage(driver);
        
        WebElement trainerName = trainerPage.getTrainerName();
        assertTrue(trainerName.isDisplayed());
        
        WebElement trainerBio = trainerPage.getTrainerBio();
        assertTrue(trainerBio.isDisplayed());
        
        WebElement trainerSchedule = trainerPage.getTrainerSchedule();
        assertTrue(trainerSchedule.isDisplayed());
        
        WebElement bookSessionButton = trainerPage.getBookSessionButton();
        assertTrue(bookSessionButton.isDisplayed());
        
        WebElement contactTrainerButton = trainerPage.getContactTrainerButton();
        assertTrue(contactTrainerButton.isDisplayed());
    }
    */
}
