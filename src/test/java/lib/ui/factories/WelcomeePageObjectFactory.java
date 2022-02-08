package lib.ui.factories;

import lib.Platform;
import lib.ui.WelcomeePageObject;
import lib.ui.android.AndroidOTPPageObject;
import lib.ui.android.AndroidWelcomeePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WelcomeePageObjectFactory
{

    public static WelcomeePageObject get(RemoteWebDriver driver)
    {
        if(Platform.getInstance().isAndroid())
        {
            return new AndroidWelcomeePageObject(driver);
        }
        else
        {
            return null;
        }
    }
}
