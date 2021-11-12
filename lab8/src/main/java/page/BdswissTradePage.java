package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static waits.ExplicitWaiter.waitForElementLocatedBy;

public class BdswissTradePage {
    private WebDriver driver;

    @FindBy(xpath = "//label[@class='btn' and @data-cy='all']")
    private WebElement assetGroupAll;
    @FindBy(id = "forexTrader")
    private WebElement frameForexTrader;
    @FindBy(xpath = "//*[@title='favourite']")
    private List<WebElement> favourites;
    @FindBy(xpath = "//label[@class='btn' and @data-cy='favourites']")
    private WebElement assetGroupFavourite;
    @FindBy(xpath = "//*[@role='rowgroup']")
    private List<WebElement> listOfFavouritesValues;
    @FindBy(xpath = "//i[@class='favourite icon-star-full ']")
    private List<WebElement> valuesInFavourite;

    public BdswissTradePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public BdswissTradePage getAssetGroupAll() {
        waitFrameToBeAvailableAndSwitch(driver, frameForexTrader);
        waitForElementLocatedBy(driver, By.xpath("//label[@class='btn' and @data-cy='all']"));
        assetGroupAll.click();
        driver.switchTo().defaultContent();
        return this;
    }

    public BdswissTradePage addSomeCurrencyInFavourite() {
        waitFrameToBeAvailableAndSwitch(driver, frameForexTrader);
        waitForElementLocatedBy(driver, By.xpath("//*[@title='favourite']"));
        favourites.get(0).click();
        favourites.get(1).click();
        driver.switchTo().defaultContent();
        return this;
    }

    public BdswissTradePage getAssetGroupFavourite() {
        waitFrameToBeAvailableAndSwitch(driver, frameForexTrader);
        waitForElementLocatedBy(driver, By.xpath("//label[@class='btn' and @data-cy='favourites']"));
        assetGroupFavourite.click();
        driver.switchTo().defaultContent();
        return this;
    }

    public int getNumberOfFavourites() {
        waitFrameToBeAvailableAndSwitch(driver, frameForexTrader);
        waitForElementLocatedBy(driver, By.xpath("//*[@role='rowgroup']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        int number = listOfFavouritesValues.size();
        driver.manage().timeouts().implicitlyWait(Duration.ZERO);
        driver.switchTo().defaultContent();
        return number;
    }

    public BdswissTradePage deleteFromFavourites() {
        waitFrameToBeAvailableAndSwitch(driver, frameForexTrader);
        waitForElementLocatedBy(driver, By.xpath("//i[@class='favourite icon-star-full ']"));
        for (WebElement element : valuesInFavourite) element.click();
        driver.switchTo().defaultContent();
        return this;
    }

    public static void waitFrameToBeAvailableAndSwitch(WebDriver driver, WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.
                frameToBeAvailableAndSwitchToIt(element));
    }
}
