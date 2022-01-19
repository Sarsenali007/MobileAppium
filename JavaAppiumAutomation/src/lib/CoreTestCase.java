package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import lib.ui.WelcomePageObject;
import org.openqa.selenium.remote.DesiredCapabilities;


public class CoreTestCase extends TestCase {

    protected AppiumDriver driver;

    @Override
    protected void setUp() throws Exception{
        super.setUp();
        driver = Platform.getInstance().getDriver();
        this.skipWelcomePageForIOSApp();
    }

    @Override
    public void tearDown() throws Exception{

        driver.quit();
        super.tearDown();
    }

    private void skipWelcomePageForIOSApp()
    {
        if(Platform.getInstance().isAndroid())
        {
            WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
            WelcomePageObject.clickSkip();
        }
    }
}
