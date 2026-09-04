package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends CommonPage {

    By byLnkShowTime = By.xpath("//a[h4[text()='Lịch Chiếu']]");
    By byLnkTheater = By.xpath("//a[h4[text()='Cụm Rạp']]");
    By byLnkNews = By.xpath("//a[h4[text()='Tin Tức']]");
    By byLnkApplication = By.xpath("//a[h4[text()='Ứng Dụng']]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isShowTimeSectionDisplayed() {
        return isElementDisplayed(byLnkShowTime);
    }

    public boolean isTheaterDisplayed() {
        return isElementDisplayed(byLnkTheater);
    }

    public boolean isTheaterNewsDisplayed() {
        return isElementDisplayed(byLnkNews);
    }

    public boolean isApplicationDisplayed() {
        return isElementDisplayed(byLnkApplication);
    }

    public void clickOnNameFilm(String nameFilm) {
        By byClickOnName = By.xpath("//div[text()='"
                + nameFilm+ "']");
        click(byClickOnName);
    }
}
