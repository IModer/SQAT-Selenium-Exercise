

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

class LoginPage extends PageBase {

    public LoginPage(WebDriver driver) {
        super(driver);
        navigate("https://liftzone.hu/?o=loginform");
    }

    public WebElement getLoginUsernameField() {
        return this.waitAndReturnElement(By.xpath("//input[contains(@id,'InputUsername')]"));
    }

    public WebElement getLoginPasswordField() {
        return this.waitAndReturnElement(By.xpath("//input[contains(@id,'InputPassword')]"));
    }

    public WebElement getJelszoMegjelenites() {
        return this.waitAndReturnElement(By.xpath("//img[contains(@class,'eye-icon')]"));
    }

    public WebElement getLoginKuldesGomb() {
        return this.waitAndReturnElement(By.xpath("//form[@action='actions/loginaction.php']//button[contains(@class, 'btn')]"));
    }

    // Logs in with the given credentions, and navigates to the userpage
    public UserPage login(String username , String password) {
        clearAndSendKeys(this.getLoginUsernameField(),username);
        clearAndSendKeys(this.getLoginPasswordField(),password);
        this.getLoginKuldesGomb().click();
        if (!this.getBodyText().contains("Helytelen belépési adatok!!")) {
            UserPage up = new UserPage(this.driver);
            return up;
        }
        return null;
    }

    // Types the password but also reveals it
    public WebElement typePasswordAndShow(String password){
        this.getLoginPasswordField().sendKeys(password);
        this.getJelszoMegjelenites().click();
        return this.getLoginPasswordField();
    }

}
