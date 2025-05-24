

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

// http://liftzone.hu/?o=registerform
class TimetablePage extends PageBase {

    public TimetablePage(WebDriver driver) {
        super(driver);
    }

    // Available time slots
    public WebElement getAvailableTimeSlot(String time) {
        return this.waitAndReturnElement(By.xpath("//div[contains(@class, 'time-slot') and text()='" + time + "']"));
    }
    
    // Select time slot button
    public WebElement getSelectTimeSlotButton(String time) {
        return this.waitAndReturnElement(By.xpath("//div[contains(@class, 'time-slot') and text()='" + time + "']//button[contains(@class, 'select-time')]"));
    }
    
    // Booking form
    public WebElement getBookingForm() {
        return this.waitAndReturnElement(By.xpath("//form[contains(@action, 'book')]"));
    }
    
    // Name input field
    public WebElement getNameInput() {
        return this.waitAndReturnElement(By.xpath("//input[contains(@name, 'name')]"));
    }
    
    // Email input field
    public WebElement getEmailInput() {
        return this.waitAndReturnElement(By.xpath("//input[contains(@name, 'email')]"));
    }
    
    // Phone input field
    public WebElement getPhoneInput() {
        return this.waitAndReturnElement(By.xpath("//input[contains(@name, 'phone')]"));
    }
    
    // Submit booking button
    public WebElement getSubmitBookingButton() {
        return this.waitAndReturnElement(By.xpath("//button[contains(@type, 'submit') and contains(@class, 'submit-booking')]"));
    }


}
