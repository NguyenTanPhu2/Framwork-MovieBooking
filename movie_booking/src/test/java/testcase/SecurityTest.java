package testcase;

import Pages.BookingPage;
import Pages.CommonPage;
import Pages.HomePage;
import Pages.MovieDetails;
import Pages.modals.CommonModal;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import report.ExtentReportManager;

public class SecurityTest extends BaseTest {

    @Test
    public void verify_Booking_Requires_Login() {
        ///Khoi tao page
        HomePage homePage = new HomePage(driver);
        MovieDetails movieDetails = new MovieDetails(driver);
        BookingPage bookingPage = new BookingPage(driver);
        CommonModal commonModal = new CommonModal(driver);

        ///Step 1: Click name film to movieDetails
        LOG.info("Step 1: Click name film to movieDetails");
        ExtentReportManager.info("Step 1: Click name film to movieDetails");
        homePage.clickOnNameFilm("gái già lắm chiêu");

        ///Step 2: Click screening
        LOG.info("Step 2: Click screening");
        ExtentReportManager.info("Step 2: Click screening");
        movieDetails.clickOnTimeFilm();

        ///Step 3: Click Choose Seat
        LOG.info("Step 3: Click Choose Seat");
        ExtentReportManager.info("Step 3: Click Choose Seat");
        bookingPage.clickOnSeat(24);

        ///Step 4: Click button Booking
        LOG.info("Step 4: Click button Booking");
        ExtentReportManager.info("Step 4: Click button Booking");
        bookingPage.clickOnBooking();

        ///VP: Requires Login
        LOG.info("VP: Requires Login");
        ExtentReportManager.info("VP: Requires Login");
        String recordedRequire = commonModal.getMessageText();
        Assert.assertEquals(recordedRequire,"Bạn chưa đăng nhập","Login required message is incorrect");
    }
}
