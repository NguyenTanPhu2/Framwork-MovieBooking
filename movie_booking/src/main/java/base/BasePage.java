package base;

import constants.TimeOutConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /// Thoi gian doi
    public WebDriverWait getWebDriverWait(long timeOutInSec) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeOutInSec));
    }

    /// Action visibility element wait
    // enter time out
    public WebElement waitVisibilityOfElementLocated(By locator, long timeOutInSec) {
        WebDriverWait wait = getWebDriverWait(timeOutInSec);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //don't enter time out
    public WebElement waitVisibilityOfElementLocated(By locator) {
        return waitVisibilityOfElementLocated(locator, TimeOutConstants.DEFAULT_TIMEOUT);
    }

    /// Action clickable element wait
    // enter time out
    public WebElement waitElementToBeClickable(By locator, long timeOutInSec) {
        WebDriverWait wait = getWebDriverWait(timeOutInSec);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    //don't enter time out
    public WebElement waitElementToBeClickable(By locator) {
        return waitElementToBeClickable(locator, TimeOutConstants.DEFAULT_TIMEOUT);
    }

    /// Action senkey
    // enter time out
    public void sendKeys(By locator, String value, long timeOutInSec) {
        WebElement element = waitVisibilityOfElementLocated(locator, timeOutInSec);
        element.sendKeys(value);
    }

    //don't enter time out
    public void sendKeys(By locator, String value) {
        sendKeys(locator, value, TimeOutConstants.DEFAULT_TIMEOUT);
    }

    /// Action click
    // enter time out
    public void click(By locator, long timeOutInSec) {
        WebElement element = waitElementToBeClickable(locator, timeOutInSec);
        element.click();
    }

    //don't enter time out
    public void click(By locator) {
        click(locator, TimeOutConstants.DEFAULT_TIMEOUT);
    }

    /// Action getText
    // enter time out
    public String getText(By locator, long timeOutInSec) {
        WebElement element = waitVisibilityOfElementLocated(locator, timeOutInSec);
        return element.getText();
    }

    //don't enter time out
    public String getText(By locator) {
        return getText(locator, TimeOutConstants.DEFAULT_TIMEOUT);
    }

    /// Action doi popup/alert tat
    // enter time out
    public boolean waitInVisibilityOfElementLocated(By locator, long timeOutInSec) {
        WebDriverWait wait = getWebDriverWait(timeOutInSec);
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    //don't enter time out
    public boolean waitInVisibilityOfElementLocated(By locator) {
        return waitInVisibilityOfElementLocated(locator, TimeOutConstants.DEFAULT_TIMEOUT);
    }
}
