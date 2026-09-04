package testcase;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterPage;
import Pages.modals.CommonModal;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import report.ExtentReportManager;

import java.util.UUID;

public class RegisterTest extends BaseTest {

    /// Data
    String account = UUID.randomUUID().toString();
    String fullName = "John";
    String password = "123456";
    String email = account + "@gmail.com";
    String wrongEmail = "C lara@.gmail.com";
    String existingEmail = "b0120ebe-fbee-42cf-8f8c-e12e5a1cb270@gmail.com";

    @Test
    public void verify_Register_Successfully() {

        ///Khoi tao cho pages
        RegisterPage registerPage = new RegisterPage(driver);
        CommonModal commonModal = new CommonModal(driver);
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        ///Step 1: Navigate to Register page
        LOG.info("Step 1: Navigate to Register page");
        ExtentReportManager.info("Step 1: Navigate to Register page");
        homePage.getTopNavigation().navigatesRegisterPage();

        ///Step 2: Enter account
        LOG.info("Step 2: Enter account");
        ExtentReportManager.info("Step 2: Enter account");
        registerPage.enterAccount(account);

        ///Step 3: Enter password
        LOG.info("Step 3: Enter password");
        ExtentReportManager.info("Step 3: Enter password");
        registerPage.enterPassword(password);

        ///Step 4: Enter confirm password
        LOG.info("Step 4: Enter confirm password");
        ExtentReportManager.info("Step 4: Enter confirm password");
        registerPage.enterConfirmPassword(password);

        ///Step 5: Enter Fullname
        LOG.info("Step 5: Enter Fullname");
        ExtentReportManager.info("Step 5: Enter Fullname");
        registerPage.enterFullName(fullName);

        ///Step 6: Enter Email
        LOG.info("Step 6: Enter Email");
        ExtentReportManager.info("Step 6: Enter Email");
        registerPage.enterEmail(email);

        ///Step 7: Click Register button
        LOG.info("Step 7: Click Register button");
        ExtentReportManager.info("Step 7: Click Register button");
        registerPage.clickRegister();

        ///VP 1: Verify Register successfully
        LOG.info("VP 1: Verify Register successfully");
        ExtentReportManager.info("VP 1: Verify Register successfully");

        String recordedTextRegister = commonModal.getMessageText();
        ///inspect
        Assert.assertEquals(recordedTextRegister, "Đăng ký thành công", "Register is not successfully");

        commonModal.waitModalDisappear();

        //VP 2: Verify login new user
        LOG.info("VP 2: Verify login new user");
        ExtentReportManager.info("VP 2: Verify login new user");
        homePage.getTopNavigation().navigateLoginPage();
        loginPage.login(account, password);

        String recordedTextLogin = commonModal.getMessageText();
        Assert.assertEquals(recordedTextLogin, "Đăng nhập thành công", "Login is not successfully");
        commonModal.waitModalDisappear();
    }

    @Test(priority = 1)
    public void verify_Register_With_Empty_Required_Fields() {

        ///Khoi tao cho pages
        RegisterPage registerPage = new RegisterPage(driver);
        CommonModal commonModal = new CommonModal(driver);
        HomePage homePage = new HomePage(driver);

        ///Step 1: Navigate to Register page
        LOG.info("Step 1: Navigate to Register page");
        ExtentReportManager.info("Step 1: Navigate to Register page");
        homePage.getTopNavigation().navigatesRegisterPage();

        ///Step 2: Empty all required fields
        LOG.info("Step 2: Empty all required fields");
        ExtentReportManager.info("Step 2: Empty all required fields");
        registerPage.register("", "", "", "");

        ///Step 3: Click Register button
        LOG.info("Step 3: Click Register button");
        ExtentReportManager.info("Step 3: Click Register button");
        registerPage.clickRegister();

        ///VP 1 : Verify error messages for empty fields Account
        LOG.info("VP 1: Verify error messages for empty fields Account");
        ExtentReportManager.info("VP 1: Verify error messages for empty fields Account");
        String recordedTextAccount = commonModal.getRequiredAccountMessageTextRegister();
        Assert.assertEquals(recordedTextAccount, "Đây là trường bắt buộc !", "Error message for empty account is not displayed");

        ///VP 2 : Verify error messages for empty fields Password
        LOG.info("VP 2: Verify error messages for empty fields Password");
        ExtentReportManager.info("VP 2: Verify error messages for empty fields Password");
        String recordedTextPassword = commonModal.getRequiredPasswordMessageTextRegister();
        Assert.assertEquals(recordedTextPassword, "Đây là trường bắt buộc !", "Error message for empty password is not displayed");

        ///VP 3 : Verify error messages for empty fields Confirm Password
        LOG.info("VP 3: Verify error messages for empty fields Confirm Password");
        ExtentReportManager.info("VP 3: Verify error messages for empty fields Confirm Password");
        String recordedTextConfirmPassword = commonModal.getRequiredConfirmPasswordMessageTextRegister();
        Assert.assertEquals(recordedTextConfirmPassword, "Đây là trường bắt buộc !", "Error message for empty confirm password is not displayed");

        ///VP 4 : Verify error messages for empty fields Full Name
        LOG.info("VP 4: Verify error messages for empty fields Full Name");
        ExtentReportManager.info("VP 4: Verify error messages for empty fields Full Name");
        String recordedTextFullName = commonModal.getRequiredFullNameMessageTextRegister();
        Assert.assertEquals(recordedTextFullName, "Đây là trường bắt buộc !", "Error message for empty full name is not displayed");

        ///VP 5 : Verify error messages for empty fields Email
        LOG.info("VP 5: Verify error messages for empty fields Email");
        ExtentReportManager.info("VP 5: Verify error messages for empty fields Email");
        String recordedTextEmail = commonModal.getRequiredEmailMessageTextRegister();
        Assert.assertEquals(recordedTextEmail, "Đây là trường bắt buộc !", "Error message for empty email is not displayed");
    }

    @Test(priority = 2)
    public void verify_Hide_Password() {

        ///Khoi tao cho pages
        RegisterPage registerPage = new RegisterPage(driver);
        HomePage homePage = new HomePage(driver);

        ///Step 1: Navigate to Register page
        LOG.info("Step 1: Navigate to Register page");
        ExtentReportManager.info("Step 1: Navigate to Register page");
        homePage.getTopNavigation().navigatesRegisterPage();

        ///Step 2: Enter Account
        LOG.info("Step 2: Enter account");
        ExtentReportManager.info("Step 2: Enter account");
        registerPage.enterAccount(account);

        ///Step 3: Enter Password
        LOG.info("Step 3: Enter password");
        ExtentReportManager.info("Step 3: Enter password");
        registerPage.enterPassword(password);

        ///Step 4: Enter Confirm Password
        LOG.info("Step 4: Enter confirm password");
        ExtentReportManager.info("Step 4: Enter confirm password");
        registerPage.enterConfirmPassword(password);

        ///Step 5: Click Hide Password
        LOG.info("Step 5: Click Hide Password");
        ExtentReportManager.info("Step 5: Click Hide Password");
        registerPage.clickHidePassword();

        ///Step 6: Click Hide Confirm Password
        LOG.info("Step 6: Click Hide Confirm Password");
        ExtentReportManager.info("Step 6: Click Hide Confirm Password");
        registerPage.clickHideConfirmPassword();

        ///Step 7: Enter Full Name
        LOG.info("Step 7: Enter Full Name");
        ExtentReportManager.info("Step 7: Enter Full Name");
        registerPage.enterFullName(fullName);

        ///Step 8: Enter Email
        LOG.info("Step 8: Enter Email");
        ExtentReportManager.info("Step 8: Enter Email");
        registerPage.enterEmail(email);
    }

    @Test(priority = 3)
    public void verify_Register_With_Invalid_Email() {

        ///Khoi tao cho pages
        RegisterPage registerPage = new RegisterPage(driver);
        CommonModal commonModal = new CommonModal(driver);
        HomePage homePage = new HomePage(driver);

        ///Step 1: Navigate to Register page
        LOG.info("Step 1: Navigate to Register page");
        ExtentReportManager.info("Step 1: Navigate to Register page");
        homePage.getTopNavigation().navigatesRegisterPage();

        ///Step 2: Enter Account
        LOG.info("Step 2: Enter account");
        ExtentReportManager.info("Step 2: Enter account");
        registerPage.enterAccount(account);

        ///Step 3: Enter Password
        LOG.info("Step 3: Enter password");
        ExtentReportManager.info("Step 3: Enter password");
        registerPage.enterPassword(password);

        ///Step 4: Enter Confirm Password
        LOG.info("Step 4: Enter confirm password");
        ExtentReportManager.info("Step 4: Enter confirm password");
        registerPage.enterConfirmPassword(password);

        ///Step 5: Enter Full Name
        LOG.info("Step 5: Enter Full Name");
        ExtentReportManager.info("Step 5: Enter Full Name");
        registerPage.enterFullName(fullName);

        ///Step 6: Enter Invalid Email
        LOG.info("Step 6: Enter Invalid Email");
        ExtentReportManager.info("Step 6: Enter Invalid Email");
        registerPage.enterEmail(wrongEmail);

        ///Step 7: Click Register button
        LOG.info("Step 7: Click Register button");
        ExtentReportManager.info("Step 7: Click Register button");
        registerPage.clickRegister();

        ///VP 1 : Verify error messages for invalid email
        LOG.info("VP 1: Verify error messages for invalid email");
        ExtentReportManager.info("VP 1: Verify error messages for invalid email");
        String recordedTextEmail = commonModal.getErrorMessageTextRegister();
        Assert.assertEquals(recordedTextEmail, "Email không hợp lệ !", "Error message for invalid email is not displayed");
    }

    @Test(priority = 4)
    public void verify_Register_With_Mismatched_Confirm_Password() {

        ///Khoi tao cho pages
        RegisterPage registerPage = new RegisterPage(driver);
        CommonModal commonModal = new CommonModal(driver);
        HomePage homePage = new HomePage(driver);

        ///Step 1: Navigate to Register page
        LOG.info("Step 1: Navigate to Register page");
        ExtentReportManager.info("Step 1: Navigate to Register page");
        homePage.getTopNavigation().navigatesRegisterPage();

        ///Step 2: Enter Account
        LOG.info("Step 2: Enter account");
        ExtentReportManager.info("Step 2: Enter account");
        registerPage.enterAccount(account);

        ///Step 3: Enter Password
        LOG.info("Step 3: Enter password");
        ExtentReportManager.info("Step 3: Enter password");
        registerPage.enterPassword(password);

        ///Step 4: Enter Mismatched Confirm Password
        LOG.info("Step 4: Enter Mismatched Confirm Password");
        ExtentReportManager.info("Step 4: Enter Mismatched Confirm Password");
        registerPage.enterConfirmPassword(password + "123");

        ///Step 5: Enter Full Name
        LOG.info("Step 5: Enter Full Name");
        ExtentReportManager.info("Step 5: Enter Full Name");
        registerPage.enterFullName(fullName);

        ///Step 6: Enter Email
        LOG.info("Step 6: Enter Email");
        ExtentReportManager.info("Step 6: Enter Email");
        registerPage.enterEmail(email);

        ///Step 7: Click Register button
        LOG.info("Step 7: Click Register button");
        ExtentReportManager.info("Step 7: Click Register button");
        registerPage.clickRegister();

        ///VP: Verify error message for mismatched confirm password
        LOG.info("VP: Verify error message for mismatched confirm password");
        ExtentReportManager.info("VP: Verify error message for mismatched confirm password");
        String recordedTextConfirmPassword = commonModal.getErrorMessageTextPasswordRegister();
        Assert.assertEquals(recordedTextConfirmPassword, "Mật khẩu không khớp !", "Error message for mismatched confirm password is not displayed");
    }

    @Test(priority = 5)
    public void verify_Login_Link() {

        ///Khoi tao cho pages
        RegisterPage registerPage = new RegisterPage(driver);
        HomePage homePage = new HomePage(driver);

        ///Step 1: Navigate to Register page
        LOG.info("Step 1: Navigate to Register page");
        ExtentReportManager.info("Step 1: Navigate to Register page");
        homePage.getTopNavigation().navigatesRegisterPage();

        ///Step 2: Click Login link
        LOG.info("Step 2: Click Login link");
        ExtentReportManager.info("Step 2: Click Login link");
        registerPage.clickLoginLink();
    }

    @Test(priority = 6)
    public void verify_Register_With_Existing_Email() {

        ///Khoi tao cho pages
        RegisterPage registerPage = new RegisterPage(driver);
        HomePage homePage = new HomePage(driver);

        ///Step 1: Navigate to Register page
        LOG.info("Step 1: Navigate to Register page");
        ExtentReportManager.info("Step 1: Navigate to Register page");
        homePage.getTopNavigation().navigatesRegisterPage();

        ///Step 2: Enter fields with existing email
        LOG.info("Step 2: Enter fields with existing email");
        ExtentReportManager.info("Step 2: Enter fields with existing email");
        registerPage.register(account, password, fullName, existingEmail);

        ///VP: Verify error message for existing email
        LOG.info("VP: Verify error message for existing email");
        ExtentReportManager.info("VP: Verify error message for existing email");
        CommonModal commonModal = new CommonModal(driver);
        String recordedTextExistingEmail = commonModal.getErrorMessageTextRegister();
        Assert.assertEquals(recordedTextExistingEmail, "Email đã tồn tại!", "Error message for existing email is not displayed");
    }

    @Test(priority = 7)
    public void verify_Register_With_Invalid_Password() {
        ///Khoi tao cho pages
        RegisterPage registerPage = new RegisterPage(driver);
        CommonModal commonModal = new CommonModal(driver);
        HomePage homePage = new HomePage(driver);

        ///Step 1: Navigate to Register page
        LOG.info("Step 1: Navigate to Register page");
        ExtentReportManager.info("Step 1: Navigate to Register page");
        homePage.getTopNavigation().navigatesRegisterPage();

        ///Step 2: Enter fields with invalid password
        LOG.info("Step 2: Enter fields with invalid password");
        ExtentReportManager.info("Step 2: Enter fields with invalid password");
        registerPage.register(account, "123", fullName, email);

        ///VP: Verify error message for invalid password
        LOG.info("VP: Verify error message for invalid password");
        ExtentReportManager.info("VP: Verify error message for invalid password");
        String recordedTextInvalidPassword = commonModal.getErrorMessageTextInvalidPasswordRegister();
        Assert.assertEquals(recordedTextInvalidPassword, "Mật khẩu phải có ít nhất 6 kí tự !", "Error message for invalid password is not displayed");
    }
}
