
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
class UserPage extends PageBase {

    public UserPage(WebDriver driver) {
        super(driver);
        navigate("https://liftzone.hu/?o=fiok");
    }

    // Account settings
    public WebElement getAccountSettingsButton() {
        return this.waitAndReturnElement(By.xpath("//a[contains(@href, 'fiokbeallitasok')]"));
    }

    public WebElement getMainPageLogoButton() {
        return this.waitAndReturnElement(By.xpath("//a[img[contains(@class, 'logo')][contains(@title,'LiftZone')]]"));
    }

    // Membership status
    public WebElement getMembershipStatus() {
        return this.waitAndReturnElement(By.xpath("//div[contains(@class, 'membership-status')]"));
    }

    // Subscription details
    public WebElement getSubscriptionDetails() {
        return this.waitAndReturnElement(By.xpath("//div[contains(@class, 'subscription-details')]"));
    }

    // Payment history
    public WebElement getPaymentHistoryLink() {
        return this.waitAndReturnElement(By.xpath("//a[contains(@href, 'fiokfizetesek')]"));
    }

    // Logout button
    public WebElement getLogoutButton() {
        return this.waitAndReturnElement(By.xpath("//a[contains(@href, 'logout')]"));
    }

    
           
}
