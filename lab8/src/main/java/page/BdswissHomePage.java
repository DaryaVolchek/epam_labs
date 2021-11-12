package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static waits.ExplicitWaiter.waitForElementLocatedBy;

public class BdswissHomePage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id ='email']")
    private WebElement searchEmailArea;
    @FindBy(xpath = "//*[@id='password']")
    private WebElement searchPasswordArea;
    @FindBy(xpath = "//*[@type='button']")
    private List<WebElement> logInButton;

    public BdswissHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public BdswissHomePage openPage(){
        driver.get("https://dashboard.bdswiss.com/login");
        return this;
    }

    public BdswissHomePage inputEmail(String text){
        waitForElementLocatedBy(driver, By.xpath("//*[@id ='email']"));
        searchEmailArea.sendKeys(text);
        return this;
    }

    public BdswissHomePage inputPassword(String text){
        waitForElementLocatedBy(driver, By.xpath("//*[@id='password']"));
        searchPasswordArea.sendKeys(text);
        return this;
    }

    public BdswissChooseAccountPage getLogIn(){
        waitForElementLocatedBy(driver, By.xpath("//*[@type='button']"));
        logInButton.get(3).click();
        return new BdswissChooseAccountPage(driver);
    }
}
