package lib.ui.ios;

import lib.ui.SetCodePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSSetCodePageObject extends SetCodePageObject {

    static {
    WELCOME_TEXT = "xpath://XCUIElementTypeStaticText[@name='Здравствуйте, Куаныш Маратович']";
    CODE1 = "xpath://XCUIElementTypeStaticText[@name='0']";
    CODE2 = "xpath://XCUIElementTypeStaticText[@name='0']";
    CODE3 = "xpath://XCUIElementTypeStaticText[@name='0']";
    CODE4 = "xpath://XCUIElementTypeStaticText[@name='0']";
    CODE5 = "xpath://XCUIElementTypeStaticText[@name='0']";
    CODE6 = "xpath://XCUIElementTypeStaticText[@name='0']";
    CODE7 = "xpath://XCUIElementTypeStaticText[@name='0']";
    CODE8 = "xpath://XCUIElementTypeStaticText[@name='0']";
    }
    public iOSSetCodePageObject (RemoteWebDriver driver)
    {
        super(driver);
    }

}
