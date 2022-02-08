package lib.ui.android;

import lib.ui.MainFirstPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidMainFirstPageObject extends MainFirstPageObject {

    static
{
    TEXT_TENGE = "xpath://*[contains(@text, '{SUBSTRING}')]";
    IBAN_SHORT_FIRST_COMPANY = "xpath://*[contains(@text, '{SUBSTRING}')]";
    DROPDOWN_COMPANY = "xpath://*[contains(@text, 'ИП Jusan Entrepreneur_000930.034120')]";
    LINK_SECOND_COMPANY = "xpath://*[contains(@text, 'ИП Jusan Entrepreneur_000920.017946')]";

}

    public AndroidMainFirstPageObject (RemoteWebDriver driver)
    {
        super(driver);
    }
}
