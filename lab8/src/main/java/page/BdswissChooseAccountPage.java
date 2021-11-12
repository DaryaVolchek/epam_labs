package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static waits.ExplicitWaiter.waitForElementLocatedBy;

public class BdswissChooseAccountPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@class='jss45 jss48 jss403']/button")
    private WebElement chooseDemoButton;

    public BdswissChooseAccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public BdswissTradePage getDemoAccoount(){
        waitForElementLocatedBy(driver, By.xpath("//*[@class='jss45 jss48 jss403']/button"));
        chooseDemoButton.click();
        return new BdswissTradePage(driver);
    }
}
