package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class WelcomeePageObject extends MainPageObject{

    protected static String
            WELCOM_FIO
            ;

    public WelcomeePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    public void waitWelcomeFIO(String substring)
    {
        String search_result_xpath = getWelcomeText(substring);
        this.waitForElementPresent(search_result_xpath, "Cannot find welcome text " + substring, 15);
    }

    private static String getWelcomeText(String substring)
    {
        return WELCOM_FIO.replace("{SUBSTRING}", substring);
    }
}
