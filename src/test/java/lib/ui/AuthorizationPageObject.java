package lib.ui;

import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorizationPageObject extends MainPageObject
{
    protected static String
            INPUT_IIN,
            BUTTON_NEXT,
            INPUT_PHONE,
            PASSWORD
                    ;

    public void clickInputIIN()
    {
        if (!Platform.getInstance().isMW())
            this.waitForElementAndClick(INPUT_IIN, "Cannot find and click input IIN", 20);
    }

    public void SendIIN(String IIN, String password)
    {
        if (Platform.getInstance().isMW())
        {
            this.waitForElementAndSendKeys(PASSWORD, password, "Cannot find and send password", 15);
        }
        else
            this.waitForElementAndSendKeys(INPUT_IIN, IIN, "Cannot find and send IIN", 15);
    }

    public void clickInputPhone()
    {
        this.waitForElementAndClick(INPUT_PHONE, "Cannot find and click input phone", 15);
    }

    public void SendPhone(String phone)
    {
        if(Platform.getInstance().isAndroid()) {
            this.waitForElementAndSendKeys(INPUT_PHONE, "7"+ phone, "Cannot find and send phone", 15);
        }
        else if(Platform.getInstance().isIOS()){
            this.waitForElementAndSendKeys(INPUT_PHONE, phone, "Cannot find and send phone", 15);
        }
        else if(Platform.getInstance().isMW())
        {
            this.waitForElementAndSendKeys(INPUT_PHONE, "7"+ phone, "Cannot find and send phone", 15);
        }
    }

    public void clickButtonNext()
    {
        this.waitForElementAndClick(BUTTON_NEXT, "Cannot find and click 'NEXT' button", 15);
    }


    public AuthorizationPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

}
