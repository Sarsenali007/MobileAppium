package lib.ui.android;

import lib.ui.AuthorizationPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidAuthorizationPageObject extends AuthorizationPageObject {
    static
    {
        INPUT_PHONE = "xpath:/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText";
        // INPUT_PHONE= "xpath://*[@class='android.widget.EditText'][@text='Номер телефона']";
        BUTTON_NEXT = "id:kz.jysan.business.dev:id/btn_text";
        INPUT_IIN = "xpath://android.widget.EditText";

    }

    public AndroidAuthorizationPageObject (RemoteWebDriver driver)
    {
        super(driver);
    }
}
