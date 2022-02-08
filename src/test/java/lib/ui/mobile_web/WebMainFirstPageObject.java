package lib.ui.mobile_web;

import lib.ui.MainFirstPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebMainFirstPageObject extends MainFirstPageObject {

    static
    {
        TEXT_TENGE = "xpath://*[contains(text(),'{SUBSTRING}')]";
        IBAN_SHORT_FIRST_COMPANY = "xpath://*[contains(text(),'{SUBSTRING}')]";
        DROPDOWN_COMPANY = "xpath://*[@class='dropdown-arrow ml-auto text-primary']";
        LINK_SECOND_COMPANY = "xpath://*[@class='aside-dropdown-menu p3']/*[2]";
    }


    public WebMainFirstPageObject (RemoteWebDriver driver)
    {
        super(driver);
    }
}

