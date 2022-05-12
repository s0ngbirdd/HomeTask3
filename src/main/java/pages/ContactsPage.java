package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage extends BasePage {

    @FindBy(xpath = "//div[@class='general-col border--bottom']//strong[text()='Одесса']")
    private WebElement city;

    @FindBy(xpath = "//div[@class='general-col border--bottom']//p[text()='ул. Преображенская, 41']")
    private WebElement street;

    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    public String getCity() {
        return city.getText();
    }

    public String getStreet() {
        return street.getText();
    }
}
