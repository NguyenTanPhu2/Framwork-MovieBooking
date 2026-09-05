package testcase;

import Pages.components.Filter;
import Pages.modals.CommonModal;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import report.ExtentReportManager;

public class FilterTest extends BaseTest {

    @Test
    public void verify_Filter_Movie() {

        Filter filter = new Filter(driver);

        ///Step 1: click dropdown Film
        LOG.info("Step 1: click dropdown Film");
        ExtentReportManager.info("Step 1: click dropdown Film");
        filter.clickDropdownFilm();

        ///VP: Check display the movie list
        LOG.info("VP: Check display the movie list");
        ExtentReportManager.info("VP: Check display the movie list");
        boolean recordingFilterFilm = filter.isMovieDisplayed("CÔ GÁI TỪ QUÁ KHỨ");
        Assert.assertTrue(recordingFilterFilm, "The movie list does not display the film 'CÔ GÁI TỪ QUÁ KHỨ'.");
    }

    @Test (priority = 1)
    public void verify_Theater_And_Showtime_Default_State(){

        Filter filter = new Filter(driver);
        CommonModal commonModal = new CommonModal(driver);

        ///Step 1: click dropdown Cinema
        LOG.info("Step 1: click dropdown Cinema");
        ExtentReportManager.info("Step 1: click dropdown Cinema");
        filter.clickFilterCinema();

        ///VP: Check display the Cinema list
        LOG.info("VP: Check display the Cinema list");
        ExtentReportManager.info("VP: Check display the Cinema list");
        boolean recordingCinema = filter.isCinemaDisplayed("Rạp");
        Assert.assertTrue(recordingCinema,"Cinema information is not displayed");

        commonModal.getWebDriverWait(30);

        ///Step 2: Click dropdown ShowTime
        LOG.info("Step 2: Click dropdown ShowTime");
        ExtentReportManager.info("Step 2: Click dropdown ShowTime");
        filter.clickFilterShowTime();

        ///VP: Check display the ShowTime list
        LOG.info("VP: Check display the ShowTime list");
        ExtentReportManager.info("VP: Check display the ShowTime list");
        boolean recordingShowTime = filter.isDateDisplayed("Ngày giờ chiếu");
        Assert.assertTrue(recordingShowTime,"ShowTime information is not displayed");

    }
}