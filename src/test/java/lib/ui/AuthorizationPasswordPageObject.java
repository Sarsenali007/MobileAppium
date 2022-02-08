package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorizationPasswordPageObject extends MainPageObject
{
    protected static String
            INPUT_PASSWORD,
            BUTTON_NEXT_PASSWORD,
            INIT_PASSWORD
                    ;

    public void clickInputPassword()
    {
        this.waitForElementAndClick(INIT_PASSWORD, "Cannot find and click input Password", 20);
    }

    public void SendPassword(String Password)
    {
        this.waitForElementAndSendKeys(INPUT_PASSWORD, Password, "Cannot find and field Password", 15);
    }

    public void clickButtonNextAfterPassword()
    {
        this.waitForElementAndClick(BUTTON_NEXT_PASSWORD, "Cannot find and click 'NEXT' button", 15);
    }

    public AuthorizationPasswordPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

}
