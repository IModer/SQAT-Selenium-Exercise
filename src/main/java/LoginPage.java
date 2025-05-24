

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

// http://liftzone.hu/?o=loginform
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

    public UserPage login(String username , String password) {
        this.getLoginUsernameField().clear();
        this.getLoginUsernameField().sendKeys(username);
        this.getLoginPasswordField().clear();
        this.getLoginPasswordField().sendKeys(password);
        this.getLoginKuldesGomb().click();
        if (!this.getBodyText().contains("Helytelen belépési adatok!!")) {
            UserPage up = new UserPage(this.driver);
            return up;
        }
        return null;
    }

    public WebElement typePasswordAndShow(String password){
        this.getLoginPasswordField().sendKeys(password);
        this.getJelszoMegjelenites().click();
        return this.getLoginPasswordField();
    }

}
