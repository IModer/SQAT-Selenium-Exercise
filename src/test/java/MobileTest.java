import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.net.MalformedURLException;

import org.junit.Test;


public class MobileTest extends BaseTest {
    @Test
    public void testMobileView() throws MalformedURLException {
        // We look at the page normaly
        MainPage mainPage = new MainPage(driver);
        String pad = mainPage.getNavBar().getCssValue("padding");
        String mar = mainPage.getNavBar().getCssValue("margin");

        // We change the browser settings
        super.setupWithMobile();

        // WE check if the body has the same style, for example padding
        String newpad = mainPage.getNavBar().getCssValue("padding");
        String newmar = mainPage.getNavBar().getCssValue("margin");
        
        System.out.println(pad + " || " + newpad);
        System.out.println(mar + " || " + newmar);
        
        assertEquals(newpad, pad);
        assertEquals(newmar, mar);

    }

}
