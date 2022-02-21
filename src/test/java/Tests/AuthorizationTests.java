package Tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.*;
import org.junit.Test;


public class AuthorizationTests extends CoreTestCase {


    @Test
    public void testCorrectAuthorization() throws InterruptedException {

        String  TextTenge = "чета";

        AuthorizationPageObject AuthorizationPageObject = AuthorizationPageFactory.get(driver);
        AuthorizationPageObject.clickInputIIN();
        AuthorizationPageObject.SendIIN("890512300275", "DevPass1!");
        AuthorizationPageObject.clickInputPhone();
        AuthorizationPageObject.SendPhone("762831616");
        AuthorizationPageObject.clickButtonNext();

        OTPPageObject OTPPageObject = OTPPageObjectFactory.get(driver);
        Thread.sleep(6000);
        OTPPageObject.SendOTP1("0");
        OTPPageObject.SendOTP2("0");
        OTPPageObject.SendOTP3("0");
        OTPPageObject.SendOTP4("0");
        OTPPageObject.SendOTP5("0");
        OTPPageObject.SendOTP6("0");

        if(!Platform.getInstance().isMW()) {
            OTPPageObject.OTPField();
            OTPPageObject.clickOTP1();
            OTPPageObject.clickOTP2();
            OTPPageObject.clickOTP3();
            OTPPageObject.clickOTP4();
            OTPPageObject.clickOTP5();
            OTPPageObject.clickOTP6();
            AuthorizationPasswordPageObject AuthorizationPasswordPageObject = AuthorizationPasswordPageObjectFactory.get(driver);
            AuthorizationPasswordPageObject.clickInputPassword();
            AuthorizationPasswordPageObject.SendPassword("DevPass1!");
            AuthorizationPasswordPageObject.clickButtonNextAfterPassword();


            OTPPageObject.clickOTP1();
            OTPPageObject.clickOTP2();
            OTPPageObject.clickOTP3();
            OTPPageObject.clickOTP4();
            OTPPageObject.clickOTP1();
            OTPPageObject.clickOTP2();
            OTPPageObject.clickOTP3();
            OTPPageObject.clickOTP4();

            if(Platform.getInstance().isIOS())
            {
                OTPPageObject.clickCODE1();
                OTPPageObject.clickCODE1();
                OTPPageObject.clickCODE1();
                OTPPageObject.clickCODE1();
                OTPPageObject.clickCODE1();
                OTPPageObject.clickCODE1();
                OTPPageObject.clickCODE1();
                OTPPageObject.clickCODE1();
            }
        }

        MainFirstPageObject MainFirstPageObject = MainFirstPageObjectFactory.get(driver);
        MainFirstPageObject.waitElementOnMainTextTenge(TextTenge);
    }
}
