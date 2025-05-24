import org.junit.Test;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TimetablePageTests extends BaseTest {
    /*
    
    @Test
    public void testSelectAvailableTimeSlot() {
        driver.get("http://liftzone.hu/?o=timetable");
        TimetablePage timetablePage = new TimetablePage(driver);
        
        String timeSlot = "10:00 AM";
        WebElement availableSlot = timetablePage.getAvailableTimeSlot(timeSlot);
        assertTrue(availableSlot.isDisplayed());
        
        WebElement selectButton = timetablePage.getSelectTimeSlotButton(timeSlot);
        selectButton.click();
        
        WebElement bookingForm = timetablePage.getBookingForm();
        assertTrue(bookingForm.isDisplayed());
        
        timetablePage.getNameInput().sendKeys("Test User");
        timetablePage.getEmailInput().sendKeys("testuser@example.com");
        timetablePage.getPhoneInput().sendKeys("1234567890");
        
        timetablePage.getSubmitBookingButton().click();
        
        // TODO: Add assertions for booking confirmation or success message
    }
    */
}
