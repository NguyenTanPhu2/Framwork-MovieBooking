package testcase;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.modals.CommonModal;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import report.ExtentReportManager;

public class LoginTest extends BaseTest {

    /// Data test
    private String account = "b0120ebe-fbee-42cf-8f8c-e12e5a1cb270";
    private String password = "123456";

    private String wrongPassword = "123457";
    private String wrongAccount = "John";


    @Test
    public void verify_Login_Successfully() {

        ///Khoi tao cho pages
        LoginPage loginPage = new LoginPage(driver);
        CommonModal commonModal = new CommonModal(driver);
        HomePage homePage = new HomePage(driver);
        
        ///Step 1: Navigate to login page
        LOG.info("Step 1: Navigate to login page");
        ExtentReportManager.info("Step 1: Navigate to login page");
        homePage.getTopNavigation().navigateLoginPage();

        ///Step 2: Enter account, Password and click on login button
        LOG.info("Step 2: Enter account and password");
        ExtentReportManager.info("Step 2: Enter account and password");
        loginPage.login(account, password);

        ///Step 3: Verify login successfully
        LOG.info("Step 3: Verify login successfully");
        ExtentReportManager.info("Step 3: Verify login successfully");
        String recordedTextLogin = commonModal.getMessageText();

        ///inspect
        Assert.assertEquals(recordedTextLogin, "Đăng nhập thành công", "Login message is incorrect!");

        ///wait for popup to disappear
        commonModal.waitModalDisappear();

        ///VP1: Click on user profile
        LOG.info("VP1: Click on user profile");
        ExtentReportManager.info("VP1: Click on user profile");
        loginPage.clickProfile();

        ///VP 2: click logout link displays
        LOG.info("VP2: click logout link displays");
        ExtentReportManager.info("VP2: click logout link displays");
        loginPage.clickLogout();

        ///inspect logout message
        String recordedTextLogout = commonModal.getMessageText();
        Assert.assertEquals(recordedTextLogout, "Bạn có muốn đăng xuất ?", "Logout message is incorrect!");
    }

    @Test(priority = 1)
    public void verify_Login_With_Wrong_Password() {
 
        ///Khoi tao cho pages
        LoginPage loginPage = new LoginPage(driver);
        CommonModal commonModal = new CommonModal(driver);
        HomePage homePage = new HomePage(driver);

        ///Step 1: Navigate to login page
        LOG.info("Step 1: Navigate to login page");
        ExtentReportManager.info("Step 1: Navigate to login page");
        homePage.getTopNavigation().navigateLoginPage();

        ///Step 2: Enter account
        LOG.info("Step 2: Enter account");
        ExtentReportManager.info("Step 2: Enter account");
        loginPage.enterAccount(account);

        ///Step 3: Enter wrong password
        LOG.info("Step 3: Enter wrong password");
        ExtentReportManager.info("Step 3: Enter wrong password");
        loginPage.enterPassword(wrongPassword);

        //Step 4: Click on login button
        LOG.info("Step 4: Click on login button");
        ExtentReportManager.info("Step 4: Click on login button");
        loginPage.clickLogin();

        ///VP: Verify login unsuccessfully
        LOG.info("VP: Verify login unsuccessfully");
        ExtentReportManager.info("VP: Verify login unsuccessfully");
        String recordedTextLogin = commonModal.getErrorMessageTextLogin();

        ///inspect
        commonModal.getErrorMessageTextLogin();
        Assert.assertEquals(recordedTextLogin, "Tài khoản hoặc mật khẩu không đúng!", "Login message is incorrect!");
    }

    @Test(priority = 2)
    public void verify_Login_With_Wrong_Account() {
 
        ///Khoi tao cho pages
        LoginPage loginPage = new LoginPage(driver);
        CommonModal commonModal = new CommonModal(driver);
        HomePage homePage = new HomePage(driver);

        ///Step 1: Navigate to login page
        LOG.info("Step 1: Navigate to login page");
        ExtentReportManager.info("Step 1: Navigate to login page");
        homePage.getTopNavigation().navigateLoginPage();

        ///Step 2: Enter wrong account
        LOG.info("Step 2: Enter wrong account");
        ExtentReportManager.info("Step 2: Enter wrong account");
        loginPage.enterAccount(wrongAccount);

        ///Step 3: Enter password
        LOG.info("Step 3: Enter password");
        ExtentReportManager.info("Step 3: Enter password");
        loginPage.enterPassword(password);

        //Step 4: Click on login button
        LOG.info("Step 4: Click on login button");
        ExtentReportManager.info("Step 4: Click on login button");
        loginPage.clickLogin();

        ///VP: Verify login unsuccessfully
        LOG.info("VP: Verify login unsuccessfully");
        ExtentReportManager.info("VP: Verify login unsuccessfully");
        String recordedTextLogin = commonModal.getErrorMessageTextLogin();

        ///inspect
        commonModal.getErrorMessageTextLogin();
        Assert.assertEquals(recordedTextLogin, "Tài khoản hoặc mật khẩu không đúng!", "Login message is incorrect!");
    }

    @Test(priority = 3)
    public void verify_Login_Empty_Account_And_Password() {
 
        ///Khoi tao cho pages
        LoginPage loginPage = new LoginPage(driver);
        CommonModal commonModal = new CommonModal(driver);
        HomePage homePage = new HomePage(driver);

        ///Step 1: Navigate to login page
        LOG.info("Step 1: Navigate to login page");
        ExtentReportManager.info("Step 1: Navigate to login page");
        homePage.getTopNavigation().navigateLoginPage();

        ///Step 2: Click on login button without entering account and password
        LOG.info("Step 2: Click on login button without entering account and password");
        ExtentReportManager.info("Step 2: Click on login button without entering account and password");
        loginPage.clickLogin();

        ///VP 1: Verify login account unsuccessfully
        LOG.info("VP 1: Verify login account unsuccessfully");
        ExtentReportManager.info("VP 1: Verify login account unsuccessfully");
        String recordedTextLogin = commonModal.getRequiredAccountMessageTextLogin();

        ///inspect
        commonModal.getRequiredAccountMessageTextLogin();
        Assert.assertEquals(recordedTextLogin, "Đây là trường bắt buộc !", "Login message is incorrect!");

        ///VP 2: Verify login password unsuccessfully
        LOG.info("VP 2: Verify login password unsuccessfully");
        ExtentReportManager.info("VP 2: Verify login password unsuccessfully");
        String recordedTextPassword = commonModal.getRequiredPasswordMessageTextLogin();
        Assert.assertEquals(recordedTextPassword, "Đây là trường bắt buộc !", "Password message is incorrect!");
    }

    @Test(priority = 4)
    public void verify_Login_With_Remember_Me() {

        ///Khoi tao cho pages
        LoginPage loginPage = new LoginPage(driver);
        CommonModal commonModal = new CommonModal(driver);
        HomePage homePage = new HomePage(driver);

        ///Step 1: Navigate to login page
        LOG.info("Step 1: Navigate to login page");
        ExtentReportManager.info("Step 1: Navigate to login page");
        homePage.getTopNavigation().navigateLoginPage();

        ///Step 2:Enter account, Password
        LOG.info("Step 2:Enter account, Password");
        ExtentReportManager.info("Step 2:Enter account, Password");
        loginPage.enterAccount(account);
        loginPage.enterPassword(password);

        ///Step 3: Click on Remember Me checkbox
        LOG.info("Step 3: Click on Remember Me checkbox");
        ExtentReportManager.info("Step 3: Click on Remember Me checkbox");
        loginPage.clickRememberMeCheckbox();

        ///Step 4: Click on login button
        LOG.info("Step 4: Click on login button");
        ExtentReportManager.info("Step 4: Click on login button");
        loginPage.clickLogin();

        ///VP: Verify login successfully
        LOG.info("VP: Verify login successfully");
        ExtentReportManager.info("VP: Verify login successfully");
        String recordedTextLogin = commonModal.getMessageText();
        Assert.assertEquals(recordedTextLogin, "Đăng nhập thành công", "Login message is incorrect!");

        commonModal.waitModalDisappear();

        ///Step 5: Click Log out
        LOG.info("Step 5: Click Log out");
        ExtentReportManager.info("Step 5: Click Log out");
        loginPage.clickLogout();
        loginPage.clickConfirmLogout();

        String recordedTextLogout = commonModal.getMessageText();
        Assert.assertEquals(recordedTextLogout, "Đã đăng xuất", "Logout message is incorrect!");

        ///Step 6: Navigate to login page again
        LOG.info("Step 6: Navigate to login page again");
        ExtentReportManager.info("Step 6: Navigate to login page again");

        ///wait popup disappear
        commonModal.waitModalDisappear();

        homePage.getTopNavigation().navigateLoginPage();

        String recordedAccountValue = loginPage.getAttributeText("value");
        Assert.assertEquals(recordedAccountValue, account, "Account value is incorrect!");
    }

    @Test(priority = 5)
    public void verify_Register_link() {
  
        ///Khoi tao cho pages
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        ///Step 1: Navigate to Register page
        LOG.info("Step 1: Navigate to Register page");
        ExtentReportManager.info("Step 1: Navigate to Register page");
        homePage.getTopNavigation().navigatesRegisterPage();

        ///Step 2: click navigate to login page
        LOG.info("Step 2: click navigate to login page");
        ExtentReportManager.info("Step 2: click navigate to login page");
        loginPage.clickLoginFromRegisterPage();
    }

    @Test (priority = 6)
    public void verify_Show_Hide_Password() {
  
        ///Khoi tao cho pages
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        ///Step 1: Navigate to Register page
        LOG.info("Step 1: Navigate to Register page");
        ExtentReportManager.info("Step 1: Navigate to Register page");
        homePage.getTopNavigation().navigateLoginPage();

        ///Step 2: Enter password
        LOG.info("Step 2: Enter password");
        ExtentReportManager.info("Step 2: Enter password");
        loginPage.enterPassword(password);

        ///Step 3: Click hide/show password button
        LOG.info("Step 3: Click hide/show password button");
        ExtentReportManager.info("Step 3: Click hide/show password button");
        loginPage.clickHidePassword();

        ///VP: Verify password is hidden
        LOG.info("VP: Verify password is hidden");
        ExtentReportManager.info("VP: Verify password is hidden");
        String recordedPasswordType = loginPage.getAttributeText("type");
        Assert.assertEquals(recordedPasswordType, "text", "Password is not hidden!");
    }

    @Test(priority = 7)
    public void verify_Refresh_Page() {
  
        ///Khoi tao cho pages
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CommonModal commonModal = new CommonModal(driver);

        ///Step 1: Navigate to Register page
        LOG.info("Step 1: Navigate to Register page");
        ExtentReportManager.info("Step 1: Navigate to Register page");
        homePage.getTopNavigation().navigateLoginPage();
        ///Step 2: Login page
        LOG.info("Step 2: Login page");
        ExtentReportManager.info("Step 2: Login page");
        loginPage.login(account, password);

        commonModal.waitModalDisappear();

        ///Step 3: Refresh page
        LOG.info("Step 3: Refresh page");
        ExtentReportManager.info("Step 3: Refresh page");
        boolean isUserLoggedInBeforeRefresh =
                homePage.getTopNavigation().isUserLoggedIn();
        driver.navigate().refresh();

        ///Verify login status after refresh The logout button appears.
        LOG.info("Verify login status after refresh The logout button appears.");
        ExtentReportManager.info("Verify login status after refresh The logout button appears.");
        Assert.assertTrue(isUserLoggedInBeforeRefresh, "User is not logged in before refresh!");
    }
}
