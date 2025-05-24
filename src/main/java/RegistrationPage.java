

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
class RegistrationPage extends PageBase {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getRegisterUsernameField() {
        return this.waitAndReturnElement(By.xpath("//input[contains(@id,'InputUsername')]"));
    }
    
    public WebElement getRegisterEmailField() {
        return this.waitAndReturnElement(By.xpath("//input[contains(@id,'InputEmail')]"));
    }
    
    public WebElement getRegisterPasswordField() {
        return this.waitAndReturnElement(By.xpath("//input[contains(@id,'InputPassword')]"));
    }
    
    public WebElement getRegisterJelszoMegjelenites() {
        return this.waitAndReturnElement(By.xpath("//img[contains(@class,'eye-icon')]"));
    }
    
    public WebElement getPasswordRetypeField() {
        return this.waitAndReturnElement(By.xpath("//input[contains(@id,'InputPassword')][contains(@name,'retype')]"));
    }
    
    public WebElement getRegisterDateField() {
        return this.waitAndReturnElement(By.xpath("//input[contains(@id,'InputDate')]"));
    }
    
    public WebElement getCaptchaField() {
        return this.waitAndReturnElement(By.xpath("//input[contains(@name,'user_eredmeny')]"));
    }
    
    public WebElement getElfogadasCheckbox() {
        return this.waitAndReturnElement(By.xpath("//input[contains(@id,'elfogadas')]"));
    }
    
    public WebElement getRegisterKuldesGomb() {
        return this.waitAndReturnElement(By.xpath("//form[@action='actions/regisztracio_feldolgozas.php']//button[contains(@class, 'btn')][@type='submit']"));
    }

           
}
