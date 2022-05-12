package avic_tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactsTests extends BaseTest {

    private static final String CITY = "Одесса";
    private static final String STREET = "ул. Преображенская, 41";

    @Test
    public void checkOdesaAddressOnContactsPage() {
        getHomePage().openContactsPage();
        getContactsPage().implicitWait(60);
        Assert.assertTrue(getContactsPage().getCity().equals(CITY) && getContactsPage().getStreet().equals(STREET));
    }
}
