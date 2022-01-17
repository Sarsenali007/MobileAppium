package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class WelcomePageObject extends MainPageObject
{
    private static final String
            STEP_LEARN_MORE_LINK = "Узнать подробнее о Википедии",
            STEP_NEW_WAY_TO_EXPLORE_TEXT = "Новые способы изучения",
            STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK = "Добавить или изменить предпочтительные языки",
            STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK = "Узнать подробнее о сборе данных",
            NEXT_BUTTON = "Далее",
            GET_STARTED_BUTTON = "Начать";

    public WelcomePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void waitElementForLearnMoreLink()
    {
        this.waitForElementPresent(By.id(STEP_LEARN_MORE_LINK), "Cannot find 'Узнать подробнее о Википедии' link", 10);
    }

    public void waitForNewWayToExploreText()
    {
        this.waitForElementPresent(By.id(STEP_NEW_WAY_TO_EXPLORE_TEXT), "Cannot find 'Узнать подробнее о Википедии' link", 10);
    }

    public void waitForAddOrEditPreferredLangText()
    {
        this.waitForElementPresent(By.id(STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK), "Cannot find 'Добавить или изменить предпочтительные языки' link", 10);
    }

    public void waitForLearnMoreAboutDataCollectedText()
    {
        this.waitForElementPresent(By.id(STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK), "Cannot find 'Узнать подробнее о сборе данных' link", 10);
    }

    public void clickNextButton()
    {
        this.waitForElementAndClick(By.id(NEXT_BUTTON), "Cannot find and click 'Далее' link", 10);
    }

    public void clickGetStartedButton()
    {
        this.waitForElementAndClick(By.id(GET_STARTED_BUTTON), "Cannot find and click 'Начать' link", 10);
    }
}
