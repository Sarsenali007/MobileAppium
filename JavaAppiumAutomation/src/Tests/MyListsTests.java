package Tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MyListPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyListsTests extends CoreTestCase
{
    @Test
    public void testSaveFirstArticleToMyList() {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();
        String name_of_folder = "Learning programming";
        ArticlePageObject.addArticleToMylist(name_of_folder);
        ArticlePageObject.closeArticle();
        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.clickMyList();
        MyListPageObject MyListPageObject = new MyListPageObject(driver);
        MyListPageObject.openFolderByName(name_of_folder);
        MyListPageObject.swipeByArticleToDelete(article_title);
    }

    @Test
    public void testSaveTwoArticlesToMyList() {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        String firstSearchRequest = "Java";
        SearchPageObject.typeSearchLine(firstSearchRequest);
        String firstArticleTitle = "Java (programming language)";
        SearchPageObject.clickByArticleWithSubstring(firstArticleTitle);

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();

        String nameOfFolder = "List for ex.5";
        ArticlePageObject.addArticleToMylist(nameOfFolder);
        ArticlePageObject.closeArticle();

        SearchPageObject.initSearchInput();
        String secondSearchRequest = "Appium";
        SearchPageObject.typeSearchLine(secondSearchRequest);
        String secondArticleTitle = "Appium";
        SearchPageObject.clickByArticleWithSubstring(secondArticleTitle);

        ArticlePageObject.waitForTitleElement();
        ArticlePageObject.addArticleToMyExistingList(nameOfFolder);
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.clickMyList();

        MyListPageObject MyListPageObject = new MyListPageObject(driver);
        MyListPageObject.openFolderByName(nameOfFolder);

        MyListPageObject.swipeByArticleToDelete(firstArticleTitle);
        MyListPageObject.openArticleByName(secondArticleTitle);

        String articleTitle = ArticlePageObject.getArticleTitle();

        assertEquals(
                "We see unexpected title!",
                secondArticleTitle,
                articleTitle
        );
    }
}
