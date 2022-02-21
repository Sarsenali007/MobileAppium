package lib;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import junit.framework.TestCase;
import lib.ui.*;
import lib.ui.factories.AuthorizationPageFactory;
import lib.ui.factories.AuthorizationPasswordPageObjectFactory;
import lib.ui.factories.MainFirstPageObjectFactory;
import lib.ui.factories.OTPPageObjectFactory;

import org.junit.Before;
import org.junit.After;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileOutputStream;
import java.util.Properties;


public class CoreTestCase{

    protected RemoteWebDriver driver;

    @Before
    @Step("Run driver and session")
    public void setUp() throws Exception{
        driver = Platform.getInstance().getDriver();
        this.createAllurePropertyFile();
       // this.skipWelcomePageForIOSApp();
        this.openJysanOnWeb();
        this.testCorrectAuthorization();
    }

    @After
    @Step("Stop driver and session")
    public void tearDown(){
        driver.quit();
    }


    protected void openJysanOnWeb()
    {
        if(Platform.getInstance().isMW())
        {
            driver.get("https://business-staging.jysanbank.kz:8460");
        }
        else
        {
            System.out.println("Method openJysanOnWeb() do nothing for platform" + Platform.getInstance().getPlatformVar());
        }
    }

    @Step("First Authorization")
    public void testCorrectAuthorization() throws InterruptedException {


        String  TextTenge = "Счета";

        AuthorizationPageObject AuthorizationPageObject = AuthorizationPageFactory.get(driver);
        AuthorizationPageObject.clickInputIIN();
        AuthorizationPageObject.SendIIN("890512300275", "DevPass1!");
        AuthorizationPageObject.clickInputPhone();
        AuthorizationPageObject.SendPhone("762831616");
        AuthorizationPageObject.clickButtonNext();

        OTPPageObject OTPPageObject = OTPPageObjectFactory.get(driver);
        Thread.sleep(6000);
        OTPPageObject.SendOTP1("0");
        OTPPageObject.SendOTP2("0");
        OTPPageObject.SendOTP3("0");
        OTPPageObject.SendOTP4("0");
        OTPPageObject.SendOTP5("0");
        OTPPageObject.SendOTP6("0");

        if(!Platform.getInstance().isMW()) {
            OTPPageObject.OTPField();
            OTPPageObject.clickOTP1();
            OTPPageObject.clickOTP2();
            OTPPageObject.clickOTP3();
            OTPPageObject.clickOTP4();
            OTPPageObject.clickOTP5();
            OTPPageObject.clickOTP6();
            AuthorizationPasswordPageObject AuthorizationPasswordPageObject = AuthorizationPasswordPageObjectFactory.get(driver);
            AuthorizationPasswordPageObject.clickInputPassword();
            AuthorizationPasswordPageObject.SendPassword("DevPass1!");
            AuthorizationPasswordPageObject.clickButtonNextAfterPassword();


            OTPPageObject.clickOTP1();
            OTPPageObject.clickOTP2();
            OTPPageObject.clickOTP3();
            OTPPageObject.clickOTP4();
            OTPPageObject.clickOTP1();
            OTPPageObject.clickOTP2();
            OTPPageObject.clickOTP3();
            OTPPageObject.clickOTP4();

            if(Platform.getInstance().isIOS())
            {
                OTPPageObject.clickCODE1();
                OTPPageObject.clickCODE1();
                OTPPageObject.clickCODE1();
                OTPPageObject.clickCODE1();
                OTPPageObject.clickCODE1();
                OTPPageObject.clickCODE1();
                OTPPageObject.clickCODE1();
                OTPPageObject.clickCODE1();
            }
        }

        MainFirstPageObject MainFirstPageObject = MainFirstPageObjectFactory.get(driver);
        MainFirstPageObject.waitElementOnMainTextTenge(TextTenge);
    }

    public void createAllurePropertyFile()
    {
        String path = System.getProperty("allure.results.directory");
        try{
            Properties props = new Properties();
            FileOutputStream fos = new FileOutputStream(path + "/environment.properties");
            props.setProperty("Environment", Platform.getInstance().getPlatformVar());
            props.store(fos, "See https://github.com/allure-framework/allure-app/wiki/Environment");
            fos.close();
        }
        catch (Exception e)
        {
            System.err.println("IO problem when writing allure properties file");
            e.printStackTrace();
        }
    }


}
