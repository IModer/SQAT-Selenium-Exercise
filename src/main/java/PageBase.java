import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

//PageBase is the base class for all Selenium tests which test a specific page.
class PageBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    // This can be freely set by the user of the class/subclasses so there are no setter/getters
    public int waitAmount = 100;
    
    public PageBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, waitAmount);
    }

    public void navigate(String url) {
        this.driver.get(url);
    }

    /**
    * Wait until a speficit element is loaded then return the found element.
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

    /**
    * Send keys to a field but first clear it
    * <p>
    * @param  e     the element to clean and send on
    * @param  s     the string to send to e
    */  
    public void clearAndSendKeys(WebElement e, String s) {
        e.clear();
        e.sendKeys(s);
    }
   
}
