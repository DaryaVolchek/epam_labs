import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.BdswissHomePage;
import page.BdswissTradePage;


public class WebDriverTestCase {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserOpen() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "test case for check favourites")
    public void addToFavouriteTest() {
        BdswissTradePage assetGroupFavourite = new BdswissHomePage(driver)
                .openPage()
                .inputEmail("darya.solig.01@gmail.com")
                .inputPassword("18d06v2001")
                .getLogIn()
                .getDemoAccoount()
                .getAssetGroupAll()
                .addSomeCurrencyInFavourite()
                .getAssetGroupFavourite();
        int expectRes = assetGroupFavourite.getNumberOfFavourites();
        assetGroupFavourite.deleteFromFavourites();
        Assert.assertEquals(expectRes, 2);
    }

    @AfterMethod(alwaysRun = true)
    public void browserClose() {
        driver.quit();
        driver = null;
    }
}
