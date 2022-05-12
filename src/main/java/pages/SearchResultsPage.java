package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//input[@id='input_search']")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@class='button-reset search-btn']")
    private WebElement searchButton;

    @FindBy(xpath = "//p[text()='Ничего не найдено']")
    private WebElement message;

    @FindBy(xpath = "//a[contains(text(),'Купить')]")
    private WebElement buyButton;

    @FindBy(xpath = "//div[@class='item']//span[@class='prise']")
    private WebElement itemAmount;

    @FindBy(xpath = "//div[@class='item-total']//span[@class='prise']")
    private WebElement itemTotalAmount;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void clearSearch() {
        searchInput.clear();
    }

    public void searchByKeyword(final String keyword) {
        searchInput.sendKeys(keyword);
        searchButton.click();
    }

    public String getSearchResultMessage() {
        return message.getText();
    }

    public void addItemToTheCart() {
        buyButton.click();
        implicitWait(60);
    }

    public String getCartItemAmount() {
        return itemAmount.getText();
    }

    public String getCartItemTotalAmount() {
        return itemTotalAmount.getText();
    }
}
