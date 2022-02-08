package lib.ui.ios;

import lib.ui.AuthorizationPageObject;
import lib.ui.AuthorizationPasswordPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSAuthorizationPasswordPageObject extends AuthorizationPasswordPageObject {

    static
        {
            INIT_PASSWORD = "xpath://XCUIElementTypeSecureTextField";
            INPUT_PASSWORD = "xpath://XCUIElementTypeSecureTextField";
            BUTTON_NEXT_PASSWORD = "xpath://XCUIElementTypeButton[@name='Войти']";
        }

    public iOSAuthorizationPasswordPageObject (RemoteWebDriver driver)
    {
        super(driver);
    }
}