package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

abstract public class SearchPageObject extends MainPageObject{

    protected static String
            SEARCH_INIT_ELEMENT,
            SEARCH_INPUT,
            SERCH_CANCEL_BUTTON,
            SEARCH_RESULT_BY_SUBSTRING_TPL,
            SERACH_RESULT_ELEMENT,
            SEARCH_EMPTY_RESULT_ELEMENT;

    public SearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }
    //template methods
    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    //template methods
    public void initSearchInput()
    {
       // this.waitForElementPresent(SEARCH_INIT_ELEMENT, "Cannot find search input after clicking search init element", 15);
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot find and click search init element", 15);
    }

    public void waitForCancelbuttonToAppear()
    {
        this.waitForElementPresent(SERCH_CANCEL_BUTTON, "Cannot find cancel button", 15);
    }

    public void waitForCancelbuttonToDisappear()
    {
        this.waitForElementNotPresent(SERCH_CANCEL_BUTTON, "Search cancel button is still present", 15);
    }

    public void clickCancelSearch()
    {
        this.waitForElementAndClick(SERCH_CANCEL_BUTTON, "Cannot find and click search cancel button", 15);
    }

    public void typeSearchLine(String search_line)
    {
        this.waitForElementAndSendKeys(SEARCH_INPUT,search_line, "Cannot find search input after clicking search init element", 15);
    }

    public void waitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(search_result_xpath, "Cannot find search result with substring" + substring, 15);
    }

    public void clickByArticleWithSubstring(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(search_result_xpath, "Cannot find and click with" + substring, 9);
    }
    public int getAmountOfFoundArticles() {
        this.waitForElementPresent(
                SERACH_RESULT_ELEMENT,
                "Cannot find anything by the request ",
                15
        );
        return this.getAmountOfElements(SERACH_RESULT_ELEMENT);
    }
    public void waitForEmptyResultsLabel() {
        this.waitForElementPresent(SEARCH_EMPTY_RESULT_ELEMENT, "Cannot find empty result label by the request ", 15);
    }
    public void assertThereIsNoResultOfSearch() {
        this.waitForElementNotPresent(SERACH_RESULT_ELEMENT, "We supposed not to find any result!", 5);
    }

    public void assertTherePageOfSearchIsClose() {
        this.waitForElementNotPresent("id:org.wikipedia:id/fragment_search_results", "Search results are not missing", 5);
    }
}
