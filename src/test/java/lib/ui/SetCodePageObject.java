package lib.ui;

import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SetCodePageObject extends MainPageObject
 {

    protected static String
            WELCOME_TEXT,
            CODE1,
            CODE2,
            CODE3,
            CODE4,
            CODE5,
            CODE6,
            CODE7,
            CODE8;


    public SetCodePageObject (RemoteWebDriver driver) {
        super(driver);
    }



    public void clickCODE1()
    {
        if(Platform.getInstance().isIOS())
        {
            this.waitForElementAndClick(CODE1, "Cannot find and click input OTP1", 15);
        }
    }

}

