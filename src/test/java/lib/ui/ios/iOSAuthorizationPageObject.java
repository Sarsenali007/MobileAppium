package lib.ui.ios;

import lib.ui.AuthorizationPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSAuthorizationPageObject extends AuthorizationPageObject{
    static
    {
        INPUT_IIN = "xpath://XCUIElementTypeTextField[@index='1']";
        INPUT_PHONE = "xpath://XCUIElementTypeTextField[@index='3']";
        BUTTON_NEXT = "xpath://XCUIElementTypeStaticText[@name='Продолжить']";

    }

    public iOSAuthorizationPageObject (RemoteWebDriver driver)
    {
        super(driver);
    }
}
