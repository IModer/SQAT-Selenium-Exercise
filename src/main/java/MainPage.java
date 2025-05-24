
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

/**
* MainPage is the class responsible for providing an interface to testthe main page of our website
* under test.
* <p>
* @author      Korpa Peter
* @author      Hudoba Peter
* @since       1.0
*/
class MainPage extends PageBase {

    public MainPage(WebDriver driver) {
        super(driver);
        navigate("http://liftzone.hu");
    }

    public WebElement getNavBar() {
        return this.waitAndReturnElement(By.xpath("//nav[contains(@class, 'navbar')]"));
    }

    public WebElement getBejelentkezesGomb() {
        return this.waitAndReturnElement(By.xpath("//nav[contains(@class, 'navbar')]//a[contains(@class, 'btn')][contains(@href,'./?o=loginform')]"));
    }

    public WebElement getRegisztralasGomb() {
        return this.waitAndReturnElement(By.xpath("//nav[contains(@class, 'navbar')]//a[contains(@class, 'btn')][contains(@href,'./?o=registerform')]"));
    }

    public WebElement getKilepesGomb() {
        return this.waitAndReturnElement(By.xpath("//nav[contains(@class, 'navbar')]//a[contains(@class, 'btn')][contains(@href,'actions/kijelentkezes.php')]"));
    }

    public WebElement getKorasGomb() {
        return this.waitAndReturnElement(By.xpath("//nav[contains(@class, 'navbar')]//div[contains(@data-bs-target,'#kosarpopup')][contains(@class, 'btn')]"));
    }

    public WebElement getVasarlasGomb() {
        return this.waitAndReturnElement(By.xpath("//form[contains(@action,'actions/vasarlas.php')]//button[contains(@class,'btn')][@type='submit']"));
    }

    public WebElement getNyelvGomb() {
        return this.waitAndReturnElement(By.xpath("//nav[contains(@class, 'navbar')]//button[contains(@class,'btn')][contains(@id,'language')]"));
    }

    public WebElement getMagyarValaszto() {
        return this.waitAndReturnElement(By.xpath("//ul[contains(@class,'dropdown-menu')][@aria-labelledby='languageMenu']//li[1]"));
    }

    public WebElement getAngolValaszto() {
        return this.waitAndReturnElement(By.xpath("//ul[contains(@class,'dropdown-menu')][@aria-labelledby='languageMenu']//li[2]"));
    }

    public WebElement getTobbiDologGomb() {
        return this.waitAndReturnElement(By.xpath("//nav[contains(@class, 'navbar')]//button[contains(@class,'btn')][contains(@id,'hamburger')]"));
    }

    public WebElement getHamburgerMenuItem(int index) {
        return this.waitAndReturnElement(By.xpath("//ul[contains(@class,'dropdown-menu')][@aria-labelledby='hamburgerMenu']//li[" + index + "]"));
    }

    public WebElement getContent() {
        return this.waitAndReturnElement(By.xpath("//div[contains(@class, 'content')]"));
    }

    public WebElement getFelhasznaloGomb() {
        return this.waitAndReturnElement(By.xpath("//a[contains(@id,'felhasznalo_nev')]"));
    }

    public WebElement getCsatlakozasGomb() {
        return this.waitAndReturnElement(By.xpath("//button[contains(@class,'btn')][text()='Csatlakozz']"));
    }

    public WebElement getArakGomb() {
        return this.waitAndReturnElement(By.xpath("//button[contains(@class,'btn')][contains(text(),'raink')]"));
    }

    public WebElement getUzenofal() {
        return this.waitAndReturnElement(By.xpath("//a[contains(@class,'edzo-nev')][contains(@href,'?o=edzok&eid=1')]"));
    }

    // Form elements
    public WebElement getEmailField() {
        return this.waitAndReturnElement(By.xpath("//input[contains(@id,'email')]"));
    }

    public WebElement getMsgField() {
        return this.waitAndReturnElement(By.xpath("//textarea[contains(@id,'message')]"));
    }

    public WebElement getKuldesGomb() {
        return this.waitAndReturnElement(By.xpath("//form[contains(@action,'actions/uzenet_kuldes.php')]//button[contains(@class,'btn')][@type='submit']"));
    }

}
