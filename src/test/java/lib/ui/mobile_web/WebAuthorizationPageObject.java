package lib.ui.mobile_web;

import lib.ui.AuthorizationPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebAuthorizationPageObject extends AuthorizationPageObject {
    static
    {
        INPUT_PHONE = "xpath://*[@type='undefined']";
        // INPUT_PHONE= "xpath://*[@class='android.widget.EditText'][@text='Номер телефона']";
        BUTTON_NEXT = "xpath://*[@type='submit']";
        INPUT_IIN = "xpath://android.widget.EditText";
        PASSWORD = "xpath://*[@type='password']";
    }

    public WebAuthorizationPageObject (RemoteWebDriver driver)
    {
        super(driver);
    }
}
