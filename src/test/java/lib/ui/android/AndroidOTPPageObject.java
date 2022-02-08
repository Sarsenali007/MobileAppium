package lib.ui.android;

import lib.ui.OTPPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidOTPPageObject extends OTPPageObject {

    static {
        OTP_FIELD = "id:kz.jysan.business.dev:id/otp";
        OTP1 = "xpath://*[@class='android.widget.GridLayout']/*[@text='0']";
        OTP2 = "xpath://*[@class='android.widget.GridLayout']/*[@text='0']";
        OTP3 = "xpath://*[@class='android.widget.GridLayout']/*[@text='0']";
        OTP4 = "xpath://*[@class='android.widget.GridLayout']/*[@text='0']";
        OTP5 = "xpath://*[@class='android.widget.GridLayout']/*[@text='0']";
        OTP6 = "xpath://*[@class='android.widget.GridLayout']/*[@text='0']";
    }

    public AndroidOTPPageObject (RemoteWebDriver driver)
    {
        super(driver);
    }

}
