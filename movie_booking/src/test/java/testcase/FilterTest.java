package testcase;

import Pages.components.Filter;
import Pages.modals.CommonModal;
import base.BaseTest;
import constants.TimeOutConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        filter.clickFilterFilm();

        ///VP: Check display the movie list
        LOG.info("VP: Check display the movie list");
        ExtentReportManager.info("VP: Check display the movie list");
        boolean recordingFilterFilm = filter.isMovieDisplayed("CÔ GÁI TỪ QUÁ KHỨ");
        Assert.assertTrue(recordingFilterFilm, "The movie list does not display the film 'CÔ GÁI TỪ QUÁ KHỨ'.");
    }

    @Test (priority = 1)
    public void verify_Theater_And_Showtime_Default_State(){

        Filter filter = new Filter(driver);

        ///Step 1: click dropdown Cinema
        LOG.info("Step 1: click dropdown Cinema");
        ExtentReportManager.info("Step 1: click dropdown Cinema");
        filter.clickFilterCinema();

        ///VP: Check display the Cinema list
        LOG.info("VP: Check display the Cinema list");
        ExtentReportManager.info("VP: Check display the Cinema list");
        boolean recordingCinema = filter.isCinemaDisplayed("Rạp");
        Assert.assertTrue(recordingCinema,"Cinema information is not displayed");

        ///Close popup
        filter.closeVideoIfDisplayed();

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

    @Test (priority = 2)
    public void verify_Theater_Dropdown_After_Selecting_Movie(){
        Filter filter = new Filter(driver);
        CommonModal commonModal = new CommonModal(driver);

        ///Step 1: Select film
        LOG.info("Step 1: Select film");
        ExtentReportManager.info("Step 1: Select film");
        filter.clickChooseFilm("AVATAR 2");
        filter.closeVideoIfDisplayed();

        ///Step 2: Select cinema
        LOG.info("Step 2: Select cinema");
        ExtentReportManager.info("Step 2: Select cinema");
        filter.clickChooseCinema("BHD Star Cineplex - Vincom Lê Văn Việt");
    }

    @Test (priority = 3)
    public void verify_Showtime_Dropdown_After_Selecting_Theater(){
        Filter filter = new Filter(driver);

        ///Step 1: Select film
        LOG.info("Step 1: Select film");
        ExtentReportManager.info("Step 1: Select film");
        filter.clickChooseFilm("AVATAR 2");

        filter.closeVideoIfDisplayed();

        ///Step 2: Select Cinema
        LOG.info("Step 2: Select cinema");
        ExtentReportManager.info("Step 2: Select cinema");
        filter.clickChooseCinema("BHD Star Cineplex - Vincom Lê Văn Việt");

        filter.closeVideoIfDisplayed();
        ///Step 3: Select ShowTime
        LOG.info("Step 3: Select ShowTime");
        ExtentReportManager.info("Step 3: Select ShowTime");
        filter.clickChooseShowTime("18/10/2021 ~ 10:25");
    }

    @Test (priority = 4)
    public void verify_Buy_Ticket_Without_Complete_Information(){
        Filter filter = new Filter(driver);
        CommonModal commonModal = new CommonModal(driver);

        ///Step 1: Click button Mua ve ngay
        LOG.info("Step 1: Click button Mua ve ngay");
        ExtentReportManager.info("Step 1: Click button Mua ve ngay");
        filter.clickBtnBooking();

        ///VP: Verifle "Bạn chưa chọn phim"
        LOG.info("VP: Verifle 'Bạn chưa chọn phim'");
        ExtentReportManager.info("VP: Verifle 'Bạn chưa chọn phim'");
        String recordingBooking = commonModal.getMessageText();
        Assert.assertEquals(recordingBooking,"Bạn chưa chọn phim","Movie selection required message is incorrect");
    }

    @Test (priority = 5)
    public void verify_Buy_Ticket_With_Complete_Information(){
        Filter filter = new Filter(driver);
        ///Step 1: Select film
        LOG.info("Step 1: Select film");
        ExtentReportManager.info("Step 1: Select film");
        filter.clickChooseFilm("AVATAR 2");

        filter.closeVideoIfDisplayed();

        ///Step 2: Select Cinema
        LOG.info("Step 2: Select cinema");
        ExtentReportManager.info("Step 2: Select cinema");
        filter.clickChooseCinema("BHD Star Cineplex - Vincom Lê Văn Việt");

        filter.closeVideoIfDisplayed();
        ///Step 3: Select ShowTime
        LOG.info("Step 3: Select ShowTime");
        ExtentReportManager.info("Step 3: Select ShowTime");
        filter.clickChooseShowTime("18/10/2021 ~ 10:25");

        ///Step 4: Click btn Booking
        LOG.info("Step 4: Click btn Booking");
        ExtentReportManager.info("Step 4: Click btn Booking");
        filter.clickBtnBooking();

        ///VP: Navigate Booking Page
        LOG.info("VP: Navigate Booking Page");
        ExtentReportManager.info("VP: Navigate Booking Page");
        String recordingCurrentURL = driver.getCurrentUrl();
        Assert.assertEquals(recordingCurrentURL,"https://demo1.cybersoft.edu.vn/purchase/45060", "HomePage navigation to Booking Page is incorrect!");

    }

}