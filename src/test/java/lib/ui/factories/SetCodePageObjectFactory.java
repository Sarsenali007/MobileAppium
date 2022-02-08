package lib.ui.factories;

import lib.Platform;
import lib.ui.OTPPageObject;
import lib.ui.SetCodePageObject;
import lib.ui.android.AndroidOTPPageObject;
import lib.ui.ios.iOSOTPPageObject;
import lib.ui.ios.iOSSetCodePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SetCodePageObjectFactory  {

    public static SetCodePageObject get(RemoteWebDriver driver)
    {
        if(Platform.getInstance().isIOS())
        {
            return new iOSSetCodePageObject(driver);
        }
        else
        {
            return null;
        }
    }
}
