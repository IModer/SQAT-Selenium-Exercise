import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

class ShopPage extends PageBase {

    public ShopPage(WebDriver driver) {
        super(driver);
        navigate("http://liftzone.hu/?o=shop");
    }

    // Product categories as in https://1lab.dev/Cat.Instances.Product.html#product-categories
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

    //Switch to passes button 
    public WebElement getSwitchToPassesButton() {
        return this.waitAndReturnElement(By.xpath("//a[contains(@href,'passes')]"));
    }
    
    //Switch to passes button 
    public WebElement getSwitchToProductsButton() {
        return this.waitAndReturnElement(By.xpath("//a[contains(@href,'?o=shop&view=products')]"));
    }
           
}
