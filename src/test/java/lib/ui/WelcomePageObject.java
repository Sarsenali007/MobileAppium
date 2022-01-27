package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WelcomePageObject extends MainPageObject
{
    private static final String
            STEP_LEARN_MORE_LINK = "id:Узнать подробнее о Википедии",
            STEP_NEW_WAY_TO_EXPLORE_TEXT = "id:Новые способы изучения",
            STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK = "id:Добавить или изменить предпочтительные языки",
            STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK = "id:Узнать подробнее о сборе данных",
            NEXT_BUTTON = "id:Далее",
            GET_STARTED_BUTTON = "id:Начать",
            SKIP = "id:Skip";

    public WelcomePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    public void waitElementForLearnMoreLink()
    {
        this.waitForElementPresent(STEP_LEARN_MORE_LINK, "Cannot find 'Узнать подробнее о Википедии' link", 10);
    }

    public void waitForNewWayToExploreText()
    {
        this.waitForElementPresent(STEP_NEW_WAY_TO_EXPLORE_TEXT, "Cannot find 'Узнать подробнее о Википедии' link", 10);
    }

    public void waitForAddOrEditPreferredLangText()
    {
        this.waitForElementPresent(STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK, "Cannot find 'Добавить или изменить предпочтительные языки' link", 10);
    }

    public void waitForLearnMoreAboutDataCollectedText()
    {
        this.waitForElementPresent(STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK, "Cannot find 'Узнать подробнее о сборе данных' link", 10);
    }

    public void clickNextButton()
    {
        this.waitForElementAndClick(NEXT_BUTTON, "Cannot find and click 'Далее' link", 10);
    }

    public void clickGetStartedButton()
    {
        this.waitForElementAndClick(GET_STARTED_BUTTON, "Cannot find and click 'Начать' link", 10);
    }

    public void clickSkip() {
        this.waitForElementAndClick(SKIP, "Cannot find and click skip button", 15);
    }
}
