
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

class UserPage extends PageBase {

    public UserPage(WebDriver driver) {
        super(driver);
        navigate("https://liftzone.hu/?o=fiok");
    }

    // Account settings
    public WebElement getAccountSettingsButton() {
        return this.waitAndReturnElement(By.xpath("//button[contains(@id, 'edit-btn')]"));
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

    // Username field in settings
    public WebElement getSettingsUserNameField() {
        return this.waitAndReturnElement(By.xpath("//input[contains(@id,'InputUsername')]"));
    }

    // Real name field in settings
    public WebElement getSettingsRealNameField() {
        return this.waitAndReturnElement(By.xpath("//input[contains(@id,'InputRealName')]"));
    }

    // Email field in settings
    public WebElement getSettingsEmailField() {
        return this.waitAndReturnElement(By.xpath("//input[contains(@id,'InputEmail')]"));
    }

    // Birth Date field in settings
    public WebElement getSettingsDateField() {
        return this.waitAndReturnElement(By.xpath("//input[contains(@id,'InputDate')]"));
    }

    // Profile picture field in settings
    public WebElement getSettingsProfilePicField() {
        return this.waitAndReturnElement(By.xpath("//input[contains(@id,'InputPic')]"));
    }

    // Save button in settings
    public WebElement getSettingsSaveButton() {
        return this.waitAndReturnElement(By.xpath("//button[contains(@id,'btn-save')]"));
    }

    // Two-factor authentication ON button
    public WebElement getTwoFactoryOnButton() {
        return this.waitAndReturnElement(By.xpath("//form[contains(@action,'2fa')]/button[contains(@class,'success')]"));
    }

    // Two-factor authentication OFF button
    public WebElement getTwoFactoryOffButton() {
        return this.waitAndReturnElement(By.xpath("//button[contains(@class,'danger')]"));
    }

    // Save account editing button
    public WebElement getAccountEditSaveButton() {
        return this.waitAndReturnElement(By.xpath("//button[contains(@id,'btn-save')]"));
    }

    public WebElement getAccountProfilePicture() {
        return this.waitAndReturnElement(By.xpath("//div[contains(@class,'profile-header')]//img[contains(@alt,'Profile')]\n" + //
                        ""));
    }

    // Changes the settings via the setting menu in UserPage to the given credentials
    public void changeAccountSetting(String nUsername, String nRealName, String nEmail, String nDate, String nProfilePic) {
        
        WebElement userAccountBtn = this.getAccountSettingsButton();
        userAccountBtn.click();
        if (nUsername != null) {
            clearAndSendKeys(this.getSettingsUserNameField(), nUsername);
        }
        if (nRealName != null) {
            clearAndSendKeys(this.getSettingsRealNameField(), nRealName);
        }
        
        if (nEmail != null) {
            clearAndSendKeys(this.getSettingsEmailField(), nEmail);
        }
        if (nDate != null) {
            this.getSettingsDateField().sendKeys(nDate);
        }
        if (nProfilePic != null) {
            clearAndSendKeys(this.getSettingsProfilePicField(), nProfilePic);
        }
        
        // This is a little tricky (hacky), the old chrome version renders the page
        // bad, so we instead send an enter to save the settings
        // In a real world senario we would fix the rendering issue, or
        // use a newer form of chromedriver (i didnt find a newer one) 
        this.getSettingsUserNameField().sendKeys(Keys.ENTER);
        /*
        WebElement usersaveButton = this.getAccountEditSaveButton();
        usersaveButton.click();
        */

    }
}
