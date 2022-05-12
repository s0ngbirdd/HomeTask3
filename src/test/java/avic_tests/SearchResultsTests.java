package avic_tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchResultsTests extends BaseTest {

    private static final String SEARCH_KEYWORD1 = "Asus";
    private static final String SEARCH_KEYWORD2 = "ddd";
    private static final String SEARCH_RESULT_MESSAGE = "Ничего не найдено";

    @Test
    public void checkThatProductNotFound() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD1);
        getSearchResultsPage().clearSearch();
        getSearchResultsPage().searchByKeyword(SEARCH_KEYWORD2);
        Assert.assertEquals(getSearchResultsPage().getSearchResultMessage(), SEARCH_RESULT_MESSAGE);
    }
}
