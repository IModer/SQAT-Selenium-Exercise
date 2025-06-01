import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertNotEquals;

public abstract class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @Before
    public void setup() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1080,720");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), capabilities);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 50);
    }

    public void setupWithMobile() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("Android"); // Note: case-sensitive in some environments

        // Additional Appium-specific capabilities if needed
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), capabilities);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 50);
    }

    protected void assertPageNavigation(WebElement element, String expectedUrl) {
        String currentUrl = driver.getCurrentUrl();
        element.click();
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        assertNotEquals("URL didn't change to " + expectedUrl, currentUrl, driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
