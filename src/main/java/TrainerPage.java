
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
class TrainerPage extends PageBase {

    public TrainerPage(WebDriver driver) {
        super(driver);
    }
    
    // Trainer name
    public WebElement getTrainerName() {
        return this.waitAndReturnElement(By.xpath("//h1[contains(@class, 'trainer-name')]"));
    }
    
    // Trainer bio
    public WebElement getTrainerBio() {
        return this.waitAndReturnElement(By.xpath("//div[contains(@class, 'trainer-bio')]"));
    }
    
    // Trainer schedule
    public WebElement getTrainerSchedule() {
        return this.waitAndReturnElement(By.xpath("//div[contains(@class, 'trainer-schedule')]"));
    }
    
    // Book a session button
    public WebElement getBookSessionButton() {
        return this.waitAndReturnElement(By.xpath("//button[contains(@class, 'book-session')]"));
    }
    
    // Contact trainer button
    public WebElement getContactTrainerButton() {
        return this.waitAndReturnElement(By.xpath("//button[contains(@class, 'contact-trainer')]"));
    }

}
