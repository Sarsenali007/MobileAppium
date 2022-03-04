package lib.ui;

import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MainFirstPageObject extends MainPageObject
{
    protected static String
            TEXT_TENGE,
            IBAN_SHORT_FIRST_COMPANY,
            DROPDOWN_COMPANY,
            LINK_SECOND_COMPANY,
            ALLOW_LINK
            ;

    public MainFirstPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }


    public void waitElementOnMainTextTenge(String substring)
    {
        String MainPageTextTenge = getTextFromMainFirstPage(substring);
        this.waitForElementPresent(MainPageTextTenge, "Cannot find text" + substring, 20);
    }

    private static String getTextFromMainFirstPage(String substring)
    {
        return TEXT_TENGE.replace("{SUBSTRING}", substring);
    }

    @Step("Wait IBAN '{substring}' on Main Page")
    public void waitElementOnMainShortIBAN(String substring)
    {
        String MainPageTextIBAN = getTextIBANFromMain(substring);
        this.waitForElementPresent(MainPageTextIBAN, "Cannot find text" + substring, 20);
    }

    private static String getTextIBANFromMain(String substring)
    {
        return TEXT_TENGE.replace("{SUBSTRING}", substring);
    }

    @Step("Click dropDown on Main Page")
    public void clickDropdownCompany()
    {
        this.waitForElementAndClick(DROPDOWN_COMPANY, "Cannot find and click DROPDOWN_COMPANY", 15);
    }

    @Step("Chose second company from list")
    public void ChoseSecondCompany()
    {
            this.waitForElementAndClick(LINK_SECOND_COMPANY, "Cannot find and chose Second company", 15);
     }

    @Step("Checking first company IBAN, on second company main page")
    public void assertThereIsNoIbanFirstCompany(String substring) {

        String MainPageTextIBAN = getTextIBANFromMain(substring);
        screenshot(this.takeScreenshot("assert_No_Iban_First_Company"));
        this.waitForElementNotPresent(MainPageTextIBAN, "We supposed not to find IBAN First company!", 5);
    }
}
