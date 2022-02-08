package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {
    static
    {
        TITLE = "css:#content h1";
        //SUBTITLE = "css:footer";
        FOOTER_ELEMENT = "css:footer";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "css:#page-actions li#ca-watch button";
        //MY_LIST_NAME_TPL = "xpath://*[@resource-id='org.wikipedia:id/item_title'][@text='{FOLDER_NAME}']";
        //CLOSE_ARTICLE_BUTTON = "id:Back";
    }

    public MWArticlePageObject (RemoteWebDriver driver)
    {
        super(driver);
    }
}
