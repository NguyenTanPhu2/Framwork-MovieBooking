import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class test {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();

        WebDriver driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo1.cybersoft.edu.vn/");

        try {
            By byBtnPlayVideo = By.xpath("(//img[@alt='video-button'])[1]");
            WebElement btnPlayVideo = wait.until(ExpectedConditions.elementToBeClickable(byBtnPlayVideo));
            btnPlayVideo.click();

            By byBtnCloseVideo = By.xpath("//button[@class='modal-video-close-btn']");
            WebElement btnCloseVideo = wait.until(ExpectedConditions.elementToBeClickable(byBtnCloseVideo));
            btnCloseVideo.click();

            By byClickNameFilm = By.xpath("//div[text()='The Gentlemen Dangbk']");
            WebElement clickNameFilm = wait.until(ExpectedConditions.elementToBeClickable(byClickNameFilm));
            clickNameFilm.click();

            Thread.sleep(3000);
        } finally {
            driver.quit();
        }
    }
}
