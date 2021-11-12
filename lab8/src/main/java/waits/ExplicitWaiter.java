package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaiter {
    public static WebElement waitForElementLocatedBy(WebDriver driver, By locator){
        return new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.
                presenceOfElementLocated(locator));
    }
}
