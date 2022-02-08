package lib.ui.ios;

import lib.ui.AuthorizationPageObject;
import lib.ui.OTPPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSOTPPageObject extends OTPPageObject {

    static {
        OTP_FIELD = "xpath://XCUIElementTypeStaticText[@name='Здравствуйте, Куаныш Маратович']";
        OTP1 = "xpath:(//XCUIElementTypeStaticText[@name='-'])[1]";
        OTP2 = "xpath:(//XCUIElementTypeStaticText[@name='-'])[1]";
        OTP3 = "xpath:(//XCUIElementTypeStaticText[@name='-'])[3]";
        OTP4 = "xpath:(//XCUIElementTypeStaticText[@name='-'])[1]";
        OTP5 = "xpath:(//XCUIElementTypeStaticText[@name='-'])[1]";
        OTP6 = "xpath:(//XCUIElementTypeStaticText[@name='-'])[1]";
        CODE1 = "xpath://XCUIElementTypeStaticText[@name='0']";
    }

    public iOSOTPPageObject (RemoteWebDriver driver)
    {
        super(driver);
    }
}
