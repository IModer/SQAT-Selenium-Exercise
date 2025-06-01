import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class FaqPageTests extends BaseTest {
    
    @Test
    public void a() {

    }

    // Test Hovering over questions
    @ParameterizedTest
    // We can test any of the faqs
    @ValueSource(ints = {1,2,3,4,5})
    public void testFaqHoverChangesBackground(int i) {
        // login first
        FaqPage faqPage = new FaqPage(driver);
        WebElement faqquestioni = faqPage.getFaqQuestions(i);
        String old = faqquestioni.getCssValue("background-color");

        Actions hoverAction = new Actions(driver);
        // We move over to faqquestioni
        hoverAction.moveToElement(faqquestioni).perform();
        System.out.println(faqquestioni.getCssValue("background-color"));
        assertTrue(faqquestioni.getCssValue("background-color").contains("rgba(241, 241, 241, 1)"));
        // Check if the bachground changed
        assertTrue(faqquestioni.getCssValue("background-color") != old);
    }


}
