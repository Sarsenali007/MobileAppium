package lib.ui.factories;

import lib.Platform;
import lib.ui.OTPPageObject;
import lib.ui.android.AndroidOTPPageObject;
import lib.ui.ios.iOSOTPPageObject;
import lib.ui.mobile_web.WebOTPPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class OTPPageObjectFactory {

    public static OTPPageObject get(RemoteWebDriver driver)
{
    if(Platform.getInstance().isAndroid())
    {
        return new AndroidOTPPageObject(driver);
    }
    else if (Platform.getInstance().isIOS())
    {
        return new iOSOTPPageObject(driver);
    }
    else
    {
        return new WebOTPPageObject(driver);
    }
}
}
