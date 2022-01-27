package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidSearchPageObject extends SearchPageObject {
     static {
         SEARCH_INIT_ELEMENT = "xpath://*[contains(@text, 'Search Wikipedia')]";
         SEARCH_INPUT = "xpath://*[contains(@text, 'Search…')]";
         SERCH_CANCEL_BUTTON = "xpath://android.widget.ImageView[@content-desc='Clear query']";
         SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[contains((text),'{SUBSTRING}')]";
         SERACH_RESULT_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_description']";
         SEARCH_EMPTY_RESULT_ELEMENT = "xpath://*[@text='No results found']";
     }
    public AndroidSearchPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
