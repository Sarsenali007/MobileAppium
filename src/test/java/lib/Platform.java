package lib;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Platform {

    private static final String PLATFORM_IOS = "ios";
    private static final String PLATFORM_ANDROID = "android";
    private static final String PLATFORM_MOBILE_WEB = "mobile_web";
    private static final String Appium_URL ="http://127.0.0.1:4723/wd/hub/";

    private static Platform instance;

    private Platform(){}

    public static Platform getInstance()
    {
        if(instance == null)
        {
            instance = new Platform();
        }
        return instance;
    }

    public RemoteWebDriver getDriver() throws Exception {
        URL URL = new URL(Appium_URL);
        if (isAndroid()) {
            return new AndroidDriver(URL, this.getAndroidDesiredCapabilities());
        } else if (isIOS()) {
            return new IOSDriver(URL, this.getIOSDesiredCapabilities());
        } else if (isMW()) {
            return new ChromeDriver(this.getMwChromeOptions());
        }
        else {
            throw new Exception("Cannot detect type of the Driver. Platform value: " + this.getPlatformVar());
        }
    }

    public boolean isAndroid()
    {
        return isPlatform(PLATFORM_ANDROID);
    }

    public boolean isIOS()
    {
        return isPlatform(PLATFORM_IOS);
    }
    public boolean isMW()
    {
        return isPlatform(PLATFORM_MOBILE_WEB);
    }

    private DesiredCapabilities getAndroidDesiredCapabilities()
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        capabilities.setCapability("platformVersion","10");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","kz.jysan.business.dev");
        capabilities.setCapability("appActivity","kz.jysan.business.ui.SplashActivity");
        capabilities.setCapability("app","/Users/sarsenalizhunisbek/Downloads/JB/app-dev-debug.apk");
        capabilities.setCapability(AndroidMobileCapabilityType.ANDROID_INSTALL_TIMEOUT, "30000");
        return capabilities;
    }

    private DesiredCapabilities getIOSDesiredCapabilities()
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone 8");
        capabilities.setCapability("platformVersion", "15.2");
        capabilities.setCapability("app", "/Users/sarsenalizhunisbek/Downloads/JB/Jysan.app");
        return capabilities;

    }

    private ChromeOptions getMwChromeOptions()
    {
        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 350);
        deviceMetrics.put("height", 350);
        deviceMetrics.put("pixelRatio", 3.0);

        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("DeviceMetrics", deviceMetrics);
        mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) " + "AppleWebKit/535.19 (KHTML, like Gecko)"+ "Chrome/18.0.1025.166 Mobile Safari/535.19");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--window-size=1920,1200");

        chromeOptions.setAcceptInsecureCerts(true);

        DesiredCapabilities crcapabilities = DesiredCapabilities.chrome();
        crcapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        return chromeOptions;
    }

    private boolean isPlatform(String my_platform)
    {
        String platform = this.getPlatformVar();
        return my_platform.equals(platform);
    }

    public String getPlatformVar()
    {
        return System.getenv("PLATFORM");
    }

}
