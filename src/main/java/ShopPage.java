

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
class ShopPage extends PageBase {

    public ShopPage(WebDriver driver) {
        super(driver);
    }

    // Product categories
    public WebElement getProductCategory(String categoryName) {
        return this.waitAndReturnElement(By.xpath("//div[contains(@class, 'product-category') and text()='" + categoryName + "']"));
    }
    
    // Product items
    public WebElement getProductItem(String productName) {
        return this.waitAndReturnElement(By.xpath("//div[contains(@class, 'product-item') and text()='" + productName + "']"));
    }
    
    // Add to cart button
    public WebElement getAddToCartButton(String productName) {
        return this.waitAndReturnElement(By.xpath("//div[contains(@class, 'product-item') and text()='" + productName + "']//button[contains(@class, 'add-to-cart')]"));
    }
    
    // Cart icon
    public WebElement getCartIcon() {
        return this.waitAndReturnElement(By.xpath("//a[contains(@href, 'cart')]//i[contains(@class, 'cart-icon')]"));
    }
    
    // Checkout button
    public WebElement getCheckoutButton() {
        return this.waitAndReturnElement(By.xpath("//a[contains(@href, 'checkout')]//button[contains(@class, 'checkout')]"));
    }

           
}
