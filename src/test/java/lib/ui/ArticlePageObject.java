package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends MainPageObject {

    protected static String
            TITLE,
            SUBTITLE,
            FOOTER_ELEMENT,
            OPTIONS_BUTTON,
            OPTIONS_LAST_ELEMENT,
            OPTIONS_ADD_TO_MY_LIST_BUTTON,
            ADD_TO_MY_LIST_OVERLAY,
            MY_LIST_NAME_INPUT,
            MY_LIST_OK_BUTTON,
            MY_LIST_NAME_TPL,
            CLOSE_ARTICLE_BUTTON
    ;

    public ArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent((TITLE), "cannon find 'article title'", 15);
    }

    public String getArticleTitle() {
        WebElement titleElement = waitForTitleElement();
        if (Platform.getInstance().isAndroid()) {
            return titleElement.getAttribute("text");
        } else {
            return titleElement.getAttribute("name");
        }
    }

    public WebElement waitForSubtitleElement() {
        return this.waitForElementPresent(SUBTITLE, "Cannot find subtitle title on page!", 15);
    }

    public String getArticleSubtitle() {
        WebElement descriptionElement = waitForSubtitleElement();
        if (Platform.getInstance().isAndroid()) {
            return descriptionElement.getAttribute("text");
        } else {
            return descriptionElement.getAttribute("name");
        }
    }

    public static String getFolderXpathByName(String nameOfFolder) {
        return MY_LIST_NAME_TPL.replace("{FOLDER_NAME}", nameOfFolder);
    }

    public void swipeToFooter()
    {
        this.swipeUpToFindElement(
                FOOTER_ELEMENT,
                "Cannot find 'Search Wikipedia' input",
                20
        );
    }

    public void addArticleToMylist(String name_of_folder){

        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5
        );

        this.waitForElementPresent(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find 'Add to reading list'",
                10
        );

        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find 'Add to reading list'",
                10
        );

        this.waitForElementAndClick(
                ADD_TO_MY_LIST_OVERLAY,
                "Cannot find 'Go it' top overlay",
                5
        );

        this.waitForElementAndClear(
                MY_LIST_NAME_INPUT,
                "Cannot find input line to set ame of articles folder",
                5
        );

        this.waitForElementAndSendKeys(
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "Cannot find input line",
                5
        );

        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON,
                "Cannot press 'OK' button",
                5
        );
    }
    public void addArticleToMyExistingList(String nameOfFolder) {
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5
        );

        /* Explicit Wait */
        this.waitForElementPresent(
                OPTIONS_LAST_ELEMENT,
                "Cannot find 'Font and theme'",
                5
        );
        /* Explicit Wait */

        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find options to add article to reading list",
                10
        );

        String folderNameXpath = getFolderXpathByName(nameOfFolder);

        this.waitForElementAndClick(
                folderNameXpath,
                "Cannot find folder: " + nameOfFolder,
                5
        );
    }

    public void addArticlesToMySaved()
    {
        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON, "Cannot find option to add article to redaing list", 5);
    }

    public void closeArticle()
    {
        this.waitForElementAndClick(
                CLOSE_ARTICLE_BUTTON,
                "Cannot close article, cannot find 'x' Link",
                5
        );
    }
}
