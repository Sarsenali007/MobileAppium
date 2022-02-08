package lib.ui.mobile_web;

import lib.ui.OTPPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebOTPPageObject extends OTPPageObject {

    static {
        OTP_FIELD = "id:kz.jysan.business.dev:id/otp";
        OTP1 = "xpath://html/body/j-root/div/j-login/section/div/div/section/j-login-sms/j-sms/div/div/form/j-sms-input/div/input";
        OTP2 = "xpath://html/body/j-root/div/j-login/section/div/div/section/j-login-sms/j-sms/div/div/form/j-sms-input/div/input";
        OTP3 = "xpath://html/body/j-root/div/j-login/section/div/div/section/j-login-sms/j-sms/div/div/form/j-sms-input/div/input";
        OTP4 = "xpath://html/body/j-root/div/j-login/section/div/div/section/j-login-sms/j-sms/div/div/form/j-sms-input/div/input";
        OTP5 = "xpath://html/body/j-root/div/j-login/section/div/div/section/j-login-sms/j-sms/div/div/form/j-sms-input/div/input";
        OTP6 = "xpath://html/body/j-root/div/j-login/section/div/div/section/j-login-sms/j-sms/div/div/form/j-sms-input/div/input";
    }

    public WebOTPPageObject (RemoteWebDriver driver)
    {
        super(driver);
    }

}
