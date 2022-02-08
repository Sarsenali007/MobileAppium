package lib.ui.factories;

import lib.Platform;
import lib.ui.AuthorizationPasswordPageObject;
import lib.ui.android.AndroidAuthorizationPasswordPageObject;
import lib.ui.android.AndroidOTPPageObject;
import lib.ui.ios.iOSAuthorizationPasswordPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorizationPasswordPageObjectFactory
{
    public static AuthorizationPasswordPageObject get(RemoteWebDriver driver)
{
    if(Platform.getInstance().isAndroid())
    {
        return new AndroidAuthorizationPasswordPageObject(driver);
    }
    else if (Platform.getInstance().isIOS())
        return new iOSAuthorizationPasswordPageObject(driver);

    return null;
}
}

