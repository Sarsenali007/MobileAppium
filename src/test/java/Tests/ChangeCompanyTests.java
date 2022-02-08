package Tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.*;
import org.junit.Test;

@Epic("Change companies")
public class ChangeCompanyTests extends CoreTestCase {

    String short_IBAN = "KZ44 •••• 6013";
    String short_IBAN_iOS = "KZ44 • 6013";
    String  TextTenge = "Счета";

    @Test
    @DisplayName("Change company")
    @Description("change company and checking update for IBAN")
    @Step("Starting test change company")
    @Features(value = {@Feature(value = "Chose_company"), @Feature(value = "Update_Main_page"),})
    @Severity(value = SeverityLevel.BLOCKER)
    public void testChangeCompany() throws InterruptedException {

        MainFirstPageObject MainFirstPageObject = MainFirstPageObjectFactory.get(driver);
        if (Platform.getInstance().isMW()){
        MainFirstPageObject.waitElementOnMainShortIBAN(short_IBAN);}
        else
        {
            MainFirstPageObject.waitElementOnMainShortIBAN(short_IBAN_iOS);
        }
        MainFirstPageObject.clickDropdownCompany();
        MainFirstPageObject.ChoseSecondCompany();
        Thread.sleep(3000);
        MainFirstPageObject.waitElementOnMainTextTenge(TextTenge);

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.takeScreenshot("IBAN_on_Second_company");

        if (Platform.getInstance().isMW()){
            MainFirstPageObject.assertThereIsNoIbanFirstCompany(short_IBAN);
        }
        else
        {
            MainFirstPageObject.assertThereIsNoIbanFirstCompany(short_IBAN_iOS);
        }

    }
}
