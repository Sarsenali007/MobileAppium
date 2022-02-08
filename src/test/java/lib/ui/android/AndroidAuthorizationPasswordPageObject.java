package lib.ui.android;

import lib.ui.AuthorizationPasswordPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidAuthorizationPasswordPageObject extends AuthorizationPasswordPageObject {

    static
{
    INIT_PASSWORD = "id:kz.jysan.business.dev:id/et_password";
    INPUT_PASSWORD = "xpath://*[@class='android.widget.EditText']";
    BUTTON_NEXT_PASSWORD = "id:kz.jysan.business.dev:id/btn_text";
}

    public AndroidAuthorizationPasswordPageObject (RemoteWebDriver driver)
    {
        super(driver);
    }
}
