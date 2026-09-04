package testcase;

import Pages.HomePage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import report.ExtentReportManager;

public class NavbarTest extends BaseTest {

    @Test
    public void verify_LogoNavigation() {

        ///Pre-codition
        HomePage homePage = new HomePage(driver);

        ///Step 1: Navigate to login page
        LOG.info("Step 1: Navigate to login page");
        ExtentReportManager.info("Step 1: Navigate to login page");
        homePage.getTopNavigation().navigateLoginPage();

        ///Step 2: Click Logo to homePage
        LOG.info("Step 2: Click Logo to homePage");
        ExtentReportManager.info("Step 2: Click Logo to homePage");
        homePage.getTopNavigation().clickLogoToHomePage();

        ///VP: Verify navigate to Home Page successfully
        LOG.info("VP: Verify navigate to Home Page successfully");
        ExtentReportManager.info("VP: Verify navigate to Home Page successfully");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://demo1.cybersoft.edu.vn/", "Logo navigation to Home Page is incorrect!");

    }

    @Test(priority = 1)
    public void verify_ShowTimes_Navigation() {
        ///Pre-codition
        HomePage homePage = new HomePage(driver);

        ///Step 1: Click Lnk 'Lich chieu'
        LOG.info("Step 1: Click Lnk 'Lich chieu'");
        ExtentReportManager.info("Step 1: Click Lnk 'Lich chieu'");
        homePage.getTopNavigation().clickShowTime();

        ///VP: Verify ShowTimes section is displayed
        LOG.info("VP: Verify ShowTimes section is displayed");
        ExtentReportManager.info("VP: Verify ShowTimes section is displayed");

        boolean isShowTime = homePage.isShowTimeSectionDisplayed();
        Assert.assertTrue(isShowTime, "ShowTimes section is not displayed!");
    }

    @Test (priority = 2)
    public void verify_Cinema_Cluster_Navigation(){
        ///Pre-codition
        HomePage homePage = new HomePage(driver);

        ///Step 1: Click Lnk 'Cum Rap'
        LOG.info("Step 1: Click Lnk 'Cum Rap'");
        ExtentReportManager.info("Step 1: Click Lnk 'Cum Rap'");
        homePage.getTopNavigation().clickTheater();

        ///VP: Verify Theater section is displayed
        LOG.info("VP: Verify Theater section is displayed");
        ExtentReportManager.info("VP: Verify Theater section is displayed");
        boolean isTheater = homePage.isTheaterDisplayed();
        Assert.assertTrue(isTheater, "Theater section is not displayed!");
    }

    @Test (priority = 3)
    public void verify_News_Navigation(){
        ///Pre-codition
        HomePage homePage = new HomePage(driver);

        ///Step 1: Click Lnk 'Tin Tuc'
        LOG.info("Step 1: Click Lnk 'Cum Rap'");
        ExtentReportManager.info("Step 1: Click Lnk 'Tin Tuc'");
        homePage.getTopNavigation().clickNews();

        ///VP: Verify Theater section is displayed
        LOG.info("VP: Verify News section is displayed");
        ExtentReportManager.info("VP: Verify News section is displayed");
        boolean isNews = homePage.isTheaterNewsDisplayed();
        Assert.assertTrue(isNews, "News section is not displayed!");
    }

    @Test (priority = 4)
    public void verify_Application_Navigation(){
        ///Pre-codition
        HomePage homePage = new HomePage(driver);

        ///Step 1: Click Lnk 'Tin Tuc'
        LOG.info("Step 1: Click Lnk 'Ung Dung'");
        ExtentReportManager.info("Step 1: Click Lnk 'Ung Dung'");
        homePage.getTopNavigation().clickApplication();

        ///VP: Verify Application section is displayed
        LOG.info("VP: Verify Application section is displayed");
        ExtentReportManager.info("VP: Verify Application section is displayed");
        boolean isApplication = homePage.isApplicationDisplayed();
        Assert.assertTrue(isApplication, "Application section is not displayed!");
    }
}
