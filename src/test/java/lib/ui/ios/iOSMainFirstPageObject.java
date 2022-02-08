package lib.ui.ios;

import lib.ui.MainFirstPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSMainFirstPageObject extends MainFirstPageObject {

    static
    {
        TEXT_TENGE = "xpath://XCUIElementTypeStaticText[@name='{SUBSTRING}']";
        IBAN_SHORT_FIRST_COMPANY = "xpath://*XCUIElementTypeStaticText[contains(@name='{SUBSTRING}')]";
        DROPDOWN_COMPANY = "xpath://XCUIElementTypeNavigationBar[@name='ИП Jusan Entrepreneur_000930.034120']";
        LINK_SECOND_COMPANY = "xpath://XCUIElementTypeStaticText[@name='ИП Jusan Entrepreneur_000920.017946']";
     //   ALLOW_LINK= "xpath://XCUIElementTypeButton[@label='Allow']";
    }

    public iOSMainFirstPageObject (RemoteWebDriver driver)
    {
        super(driver);
    }
}
