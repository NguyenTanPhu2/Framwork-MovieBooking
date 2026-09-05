package Pages.components;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        this.byFilterShowTime=By.name("date");
        this.byBtnBooking=By.xpath("//button[span[text()='MUA VÉ NGAY']]");
    }

    public void clickDropdownFilm(){
        click(byFilterFilm);
    }

    public boolean isMovieDisplayed(String movieName) {
        return isOptionDisplayed(byFilterFilm, movieName);
    }

    public void clickFilterCinema(){
        click(byFilterCinema);
    }

    public boolean isCinemaDisplayed(String cinemaName) {
        return isOptionDisplayed(byFilterCinema, cinemaName);
    }

    public void clickFilterShowTime(){
        click(byFilterShowTime);
    }


    public boolean isDateDisplayed(String date){
        return isOptionDisplayed(byFilterShowTime,date);
    }

    public void clickBtnBooking(){
        click(byBtnBooking);
    }
}
