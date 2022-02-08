package lib.ui;

import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

public class OTPPageObject extends MainPageObject {

    protected static String
            OTP_FIELD,
            OTP1,
            OTP2,
            OTP3,
            OTP4,
            OTP5,
            OTP6,
            CODE1;


    public OTPPageObject(RemoteWebDriver driver) {
        super(driver);
    }


    public void OTPField()
    {
        if(Platform.getInstance().isAndroid())
        {
            this.waitForElementPresent(OTP_FIELD, "Cannot find OTP Field", 15);
        }
        else
            return;
    }

    public void clickOTP1()
    {
        if(Platform.getInstance().isAndroid())
        {
            this.waitForElementAndClick(OTP1, "Cannot find and click input OTP1", 15);
        }
        else
            return;
    }

    public void SendOTP1(String phone)
    {
        if (Platform.getInstance().isIOS())
        {
            this.waitForElementAndSendKeys(OTP1, phone, "Cannot find and send OTP1", 15);
        }
        else if(Platform.getInstance().isMW())
        {
            this.waitForElementAndSendKeys(OTP1, phone,"Cannot find and send OTP1", 15);
        }
        else
            return;
    }

    public void clickOTP2()
    {
        if(Platform.getInstance().isAndroid())
        {
            this.waitForElementAndClick(OTP2, "Cannot find and click input OTP2", 15);
        }
        else
            return;
    }

    public void SendOTP2(String phone)
    {
        if (Platform.getInstance().isIOS())
        {
            this.waitForElementAndSendKeys(OTP2, phone, "Cannot find and send OTP2", 15);
        }
        else if(Platform.getInstance().isMW())
        {
            this.waitForElementAndSendKeys(OTP2, phone,"Cannot find and send OTP2", 15);
        }
        else
            return;
    }

    public void clickOTP3()
    {
        if(Platform.getInstance().isAndroid())
        {
            this.waitForElementAndClick(OTP3, "Cannot find and click input OTP3", 15);
        }
        else
            return;
    }

    public void SendOTP3(String phone)
    {
        if (Platform.getInstance().isIOS())
        {
            this.waitForElementAndSendKeys(OTP3, phone, "Cannot find and send OTP3", 15);
        }
        else if(Platform.getInstance().isMW())
        {
            this.waitForElementAndSendKeys(OTP3, phone,"Cannot find and send OTP3", 15);
        }
        else
            return;
    }

    public void clickOTP4()
    {
        if(Platform.getInstance().isAndroid())
        {
            this.waitForElementAndClick(OTP4, "Cannot find and click input OTP4", 15);
        }
        else
            return;
    }

    public void SendOTP4(String phone)
    {
        if (Platform.getInstance().isIOS())
        {
            this.waitForElementAndSendKeys(OTP4, phone, "Cannot find and send OTP4", 15);
        }
        else if(Platform.getInstance().isMW())
        {
            this.waitForElementAndSendKeys(OTP4, phone,"Cannot find and send OTP4", 15);
        }
        else
            return;
    }

    public void clickOTP5()
    {
        if(Platform.getInstance().isAndroid())
        {
            this.waitForElementAndClick(OTP5, "Cannot find and click input OTP5", 15);
        }
        else
            return;
    }

    public void SendOTP5(String phone)
    {
        if (Platform.getInstance().isIOS())
        {
            this.waitForElementAndSendKeys(OTP5, phone, "Cannot find and send OTP5", 15);
        }
        else if(Platform.getInstance().isMW())
        {
            this.waitForElementAndSendKeys(OTP5, phone,"Cannot find and send OTP5", 15);
        }
        else
            return;
    }

    public void clickOTP6()
    {
        if(Platform.getInstance().isAndroid())
        {
            this.waitForElementAndClick(OTP6, "Cannot find and click input OTP6", 15);
        }
        else
            return;

    }

    public void SendOTP6(String phone)
    {
        if (Platform.getInstance().isIOS())
        {
            this.waitForElementAndSendKeys(OTP6, phone, "Cannot find and send OTP6", 15);
        }
        else if(Platform.getInstance().isMW())
        {
            this.waitForElementAndSendKeys(OTP6, phone,"Cannot find and send OTP6", 15);
        }
        else
            return;
    }


    public void clickCODE1()
    {
        if(Platform.getInstance().isIOS())
        {
            this.waitForElementAndClick(CODE1, "Cannot find and click input OTP1", 15);
        }
        else
            return;
    }
}
