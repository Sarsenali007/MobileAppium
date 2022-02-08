package lib.ui.factories;

import lib.Platform;
import lib.ui.AuthorizationPageObject;
import lib.ui.android.AndroidAuthorizationPageObject;
import lib.ui.android.AndroidMyListPageObject;
import lib.ui.ios.iOSAuthorizationPageObject;
import lib.ui.ios.iOSMyListPageObject;
import lib.ui.mobile_web.WebAuthorizationPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorizationPageFactory {

    public static AuthorizationPageObject get(RemoteWebDriver driver)
    {
        if(Platform.getInstance().isAndroid())
        {
            return new AndroidAuthorizationPageObject(driver);
        }

        else if(Platform.getInstance().isIOS())
        {
            return new iOSAuthorizationPageObject(driver);
        }
        else
        {
            return new WebAuthorizationPageObject(driver);
        }
    }
}
