

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

/**
* PageBase is the base class for all Selenium tests which test a specific page.
* <p>
* @author      Korpa Peter
* @author      Hudoba Peter
* @since       1.0
*/
class PageBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    // This can be freely set by the user of the class/subclasses so there are no setter/getters
    public int waitAmount = 10;
    
    public PageBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, waitAmount);
    }

    public void navigate(String url) {
        this.driver.get(url);
        //wait.until(ExpectedConditions.urlToBe(url));
    }
    /**
    * Wait until a speficit element is loaded then return the fouond element.
    * <p>
    * @param  locator  a term of type By speficying which element to wait for and return 
    * @return      the element found by locator
    */
    protected WebElement waitAndReturnElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    } 
    /**
    * Returns the text content of the curret active page via *getText()*
    * <p>
    * @return      the text content of the current page
    */
    public String getBodyText() {
        WebElement bodyElement = this.waitAndReturnElement(By.tagName("body"));
        return bodyElement.getText();
    }
   
}
