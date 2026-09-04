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
        driver.get("https://demo1.cybersoft.edu.vn/detail/9913");

        try {
            By byLnkLogo = By.xpath("//a[@href = '/purchase/45243']");
            WebElement lnkLogo = wait.until(ExpectedConditions.elementToBeClickable(byLnkLogo));
            lnkLogo.click();

            Thread.sleep(3000);
        } finally {
            driver.quit();
        }
    }
}
