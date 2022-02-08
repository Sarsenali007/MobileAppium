package lib.ui.factories;

import lib.Platform;
import lib.ui.MainFirstPageObject;
import lib.ui.android.AndroidMainFirstPageObject;
import lib.ui.ios.iOSMainFirstPageObject;
import lib.ui.mobile_web.WebMainFirstPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MainFirstPageObjectFactory {

    public static MainFirstPageObject get(RemoteWebDriver driver)
    {
        if(Platform.getInstance().isAndroid())
        {
            return new AndroidMainFirstPageObject(driver);
        }
        else if(Platform.getInstance().isIOS())
        {
            return new iOSMainFirstPageObject(driver);
        }
        else
        {
            return new WebMainFirstPageObject(driver);
        }
    }
}
