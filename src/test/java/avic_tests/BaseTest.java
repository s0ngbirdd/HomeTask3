package avic_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.ContactsPage;
import pages.HomePage;
import pages.SearchResultsPage;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTest {

    private WebDriver driver;
    private static final String AVIC_URL = "https://avic.ua/";

    @BeforeTest
    public void profileSetUp() {
        chromedriver().setup();
    }

    @BeforeMethod
    public void testsSetUp() {

        //For turning on VPN

        /*File vpn = new File("src\\main\\resources\\4.1.0_0.crx");
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(vpn);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        driver.get("chrome-extension://bihmplhobchoageeokmgbdihknkjbknd/panel/index.html");
        String firstWindow = driver.getWindowHandle();

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        driver.findElement(By.xpath("//div[@id='ConnectionButton']")).click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);*/

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(AVIC_URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    public SearchResultsPage getSearchResultsPage() {
        return new SearchResultsPage(getDriver());
    }

    public ContactsPage getContactsPage() {
        return new ContactsPage(getDriver());
    }
}
