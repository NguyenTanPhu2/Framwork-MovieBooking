package Pages.components;

import base.BasePage;
import constants.TimeOutConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class Filter extends BasePage {
    private By byFilterFilm;
    private By byFilterCinema;
    private By byFilterShowTime;
    private By byBtnBooking;
    private By byCloseVideo;

    public Filter(WebDriver driver) {
        super(driver);

        this.byFilterFilm = By.name("film");
        this.byFilterCinema = By.name("cinema");
        this.byFilterShowTime = By.name("date");
        this.byBtnBooking = By.xpath("//button[span[text()='MUA VÉ NGAY']]");
        this.byCloseVideo = By.xpath("//button[@class='modal-video-close-btn']");
    }

    public void clickFilterFilm() {
        click(byFilterFilm);
    }

    public void clickChooseFilm(String nameFilm) {
        clickFilterFilm();
        choose(byFilterFilm, nameFilm);

    }
    public void closeVideoIfDisplayed() {
        try {
            if (isElementDisplayed(byCloseVideo)) {
                click(byCloseVideo);
            }
        } catch (Exception e) {
            // Video không hiển thị
        }
    }

    public boolean isMovieDisplayed(String movieName) {
        return isOptionDisplayed(byFilterFilm, movieName);
    }

    public void clickFilterCinema() {
        click(byFilterCinema);
    }

    public void clickChooseCinema(String cinema) {
        clickFilterCinema();
        choose(byFilterCinema, cinema);
    }

    public boolean isCinemaDisplayed(String cinemaName) {
        return isOptionDisplayed(byFilterCinema, cinemaName);
    }

    public void clickFilterShowTime() {
        click(byFilterShowTime);
    }

    public void clickChooseShowTime(String time) {
        clickFilterShowTime();
        choose(byFilterShowTime, time);
    }

    public boolean isDateDisplayed(String date) {
        return isOptionDisplayed(byFilterShowTime, date);
    }

    public void clickBtnBooking() {
        click(byBtnBooking);
    }
}
