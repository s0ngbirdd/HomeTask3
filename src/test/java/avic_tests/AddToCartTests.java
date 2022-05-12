package avic_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTests extends BaseTest {

    public static final String SEARCH_KEYWORD = "MacBook";

    @Test
    public void checkShoppingCartTotalAmount() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        getSearchResultsPage().implicitWait(60);
        getSearchResultsPage().addItemToTheCart();
        Assert.assertEquals(getSearchResultsPage().getCartItemTotalAmount(), getSearchResultsPage().getCartItemAmount());
    }
}
