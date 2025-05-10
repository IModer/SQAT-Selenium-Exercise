import org.junit.*;
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
* MainPade is the class responsible for providing an interface to testthe main page of our website
* under test.
* <p>
* @author      Korpa Peter
* @author      Hudoba Peter
* @since       1.0
*/
class MainPage extends PageBase {

    
    public MainPage(WebDriver driver) {
        super(driver);
        this.driver.get("http://liftzone.hu");
    }    
    
    /*
    public String getFooterText() {
        return this.waitAndReturnElement(footerBy).getText();
    }

    public SearchResultPage search(String searchQuery) {
        this.waitAndReturnElement(searchBarTogglerBy).click();
        
        this.waitAndReturnElement(searchBarBy).sendKeys(searchQuery + "\n");
        return new SearchResultPage(this.driver);
    }
    */
}
