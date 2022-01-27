package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import lib.ui.WelcomePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;


public class CoreTestCase extends TestCase {

    protected RemoteWebDriver driver;

    @Override
    protected void setUp() throws Exception{
        super.setUp();
        driver = Platform.getInstance().getDriver();
        this.skipWelcomePageForIOSApp();
        this.openWikiWebPageForMobileWeb();
    }

    @Override
    public void tearDown() throws Exception{

        driver.quit();
        super.tearDown();
    }

    private void skipWelcomePageForIOSApp()
    {
        if(Platform.getInstance().isIOS())
        {
            AppiumDriver driver = (AppiumDriver) this.driver;
            WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
            WelcomePageObject.clickSkip();
        }
    }

    protected void openWikiWebPageForMobileWeb()
    {
        if(Platform.getInstance().isMW())
        {
            driver.get("https://en.m.wikipedia.org");
        }
        else
        {
            System.out.println("Method openWikiWebPageForMobileWeb() do nothing for platform" + Platform.getInstance().getPlatformVar());
        }
    }
}
