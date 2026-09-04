package testcase;

import Pages.HomePage;
import Pages.LogOutPage;
import Pages.LoginPage;
import Pages.modals.CommonModal;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import report.ExtentReportManager;

public class LogOutTest extends BaseTest {

    ///Data
    private String account = "b0120ebe-fbee-42cf-8f8c-e12e5a1cb270";
    private String password = "123456";
    @Test
    public void verify_Logout_Successfully(){

        ///Khoi tao cho pages
        LoginPage loginPage = new LoginPage(driver);
        LogOutPage logOutPage = new LogOutPage(driver);
        CommonModal commonModal = new CommonModal(driver);
        HomePage homePage = new HomePage(driver);

        ///Step 1: Navigate to login page
        LOG.info("Step 1: Navigate to login page");
        ExtentReportManager.info("Step 1: Navigate to login page");
        homePage.getTopNavigation().navigateLoginPage();

        ///Step 2: Login
        LOG.info("Step 2: Login");
        ExtentReportManager.info("Step 2: Login");
        loginPage.login(account,password);

        ///Step 3: Click btn logOut
        LOG.info("Step 3: Click btn logOut");
        ExtentReportManager.info("Step 3: Click btn logOut");
        logOutPage.clickBtnLogOut();

        ///VP 1: Verify confirm
        LOG.info("VP 1: Verify confirm");
        ExtentReportManager.info("VP 1: Verify confirm");

        ///inspect
        String recordedTextLogOut = commonModal.getMessageText();
        Assert.assertEquals(recordedTextLogOut,"Bạn có muốn đăng xuất ?","Logout confirmation message is incorrect");

        ///Step 4: Xac nhan LogOut
        LOG.info("Step 4: Xac nhan LogOut");
        ExtentReportManager.info("Step 4: Xac nhan LogOut");
        logOutPage.clickBtnConfirmYes();

        ///inspect
        String recordedTextConfirmLogOut = commonModal.getMessageText();
        Assert.assertEquals(recordedTextConfirmLogOut,"Đã đăng xuất","Logout message is incorrect");

    }
}
