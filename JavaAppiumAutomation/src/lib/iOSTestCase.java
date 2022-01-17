package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.TestCase;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class iOSTestCase extends TestCase {

    protected AppiumDriver driver;

    private static String Appium_URL="http://127.0.0.1:4723/wd/hub/";

    @Override
    protected void setUp() throws Exception{

        super.setUp();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","iOS");
        capabilities.setCapability("deviceName","iPhone 8");
        capabilities.setCapability("platformVersion","15.2");
        capabilities.setCapability("app","/Users/sarsenalizhunisbek/Documents/GitHub/MobileAppium/apks/org.wikipedia.apk");
        driver = new IOSDriver(new URL(Appium_URL), capabilities);
    }

    @Override
    public void tearDown() throws Exception{

        driver.quit();
        super.tearDown();

    }

}
