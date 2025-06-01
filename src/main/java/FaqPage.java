import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

class FaqPage extends PageBase {

    public FaqPage(WebDriver driver) {
        super(driver);
        navigate("https://liftzone.hu/?o=faqs");
    }

    // Gets the ith faq, i is between 1-5
    public WebElement getFaqQuestions(int i) {
        return this.waitAndReturnElement(By.xpath("(//section[contains(@class,'faq')]//div[contains(@class,'question')])[" + i + "]"));
    }

}