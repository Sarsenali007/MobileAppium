package lib.ui.android;

import lib.ui.OTPPageObject;
import lib.ui.WelcomeePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidWelcomeePageObject extends WelcomeePageObject {


    static
    {
       // WELCOM_FIO = "xpath://*[contains(@text, '{SUBSTRING}')]";
        WELCOM_FIO = "xpath://*[@text='{SUBSTRING}']";
    }

    public AndroidWelcomeePageObject (RemoteWebDriver driver)
    {
        super(driver);
    }

}
