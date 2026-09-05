package testcase;

import Pages.BannerPage;
import Pages.CommonPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import report.ExtentReportManager;

public class BannerTest extends BaseTest {

    @Test
    public void verify_Banner_WithOut_Alt_Text() {
        BannerPage bannerPage = new BannerPage(driver);


        ///VP:Banner does not display the text "Img alt"
        boolean recordingBannerAlt = bannerPage.isAltTextDisplayed();
        Assert.assertFalse(recordingBannerAlt,"Banner is displaying the text 'Img alt'");

    }

    @Test (priority = 1)
    public void verify_Banner_After_Refresh() {
        BannerPage bannerPage = new BannerPage(driver);

        driver.navigate().refresh();
        ///VP:Banner does not display the text "Img alt" after Refresh
        LOG.info("VP:Banner does not display the text \"Img alt\" after Refresh");
        ExtentReportManager.info("VP:Banner does not display the text \"Img alt\" after Refresh");
        boolean recordingBannerAltAfterRefresh = bannerPage.isAltTextDisplayed();
        Assert.assertFalse(recordingBannerAltAfterRefresh,"Banner is displaying the text 'Img alt'");
    }
}
