import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

class RegistrationPage extends PageBase {

    public RegistrationPage(WebDriver driver) {
        super(driver);
        navigate("http://liftzone.hu/?o=registerform");
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


    public WebElement getCaptchaText() {
        return this.waitAndReturnElement(By.xpath("//label[contains(@class,'form-label')][@for='InputCaptcha']"));
    }
    
    public WebElement getElfogadasCheckbox() {
        return this.waitAndReturnElement(By.xpath("//input[contains(@id,'elfogadas')]"));
    }
    
    public WebElement getRegisterKuldesGomb() {
        return this.waitAndReturnElement(By.xpath("//form[@action='actions/regisztracio_feldolgozas.php']//button[contains(@class, 'btn')][@type='submit']"));
    }

    // Registers a user with teh given credentials
    public void register(String username, String email, String password, String date) {
            clearAndSendKeys(this.getRegisterUsernameField(),username);
            clearAndSendKeys(this.getRegisterEmailField(),email);
            clearAndSendKeys(this.getRegisterPasswordField(),password);
            clearAndSendKeys(this.getPasswordRetypeField(),password);
            this.getRegisterDateField().sendKeys(date);
            // We solve the captcha
            String captcha = this.getCaptchaText().getText();
            System.out.println(captcha);
            String captcha1 = captcha.split(":")[1].split("\\+")[0].trim();
            System.out.println(captcha1);
            String captcha2 = captcha.split(":")[1].split("\\+")[1].split("=")[0].trim();
            System.out.println(captcha2);
            String sol = Integer.toString((Integer.parseInt(captcha1) + Integer.parseInt(captcha2)));
            System.out.println(sol);
            WebElement captchaField = this.getCaptchaField();
            
            //csak a legújabb seleniumba van scroll
            //¯\_(ツ)_/¯
        
            clearAndSendKeys(captchaField, sol);
            getElfogadasCheckbox().sendKeys(Keys.SPACE);
            this.getRegisterUsernameField().sendKeys(Keys.ENTER);
            /* 
            getRegisterKuldesGomb().click();
            */
            
    }
}
