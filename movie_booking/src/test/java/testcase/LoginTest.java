package testcase;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.modals.CommonModal;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {
    @Test
    public void verify_Login() {
        ///Pre-codition

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();

        driver.get("https://demo1.cybersoft.edu.vn");

        ///Khoi tao cho pages
        LoginPage loginPage = new LoginPage(driver);
        CommonModal commonModal = new CommonModal(driver);
        HomePage homePage = new HomePage(driver);

        ///VP1: User login successfully with new account with new account
        //pre-codition: navigate login page
        homePage.getTopNavigation().navigateLoginPage();

        String account = "b0120ebe-fbee-42cf-8f8c-e12e5a1cb270";
        String password = "123456";

        loginPage.login(account, password);

        //Step 4: Verify login successfully
        //Vp1 "Đăng nhập thành công" dialog message displays
        String recordedTextLogin = commonModal.getMessageText();

        ///inspect - kiem tra
        Assert.assertEquals(recordedTextLogin, "Đăng nhập thành công", "Login message is incorrect!");

        //doi popup tat
        commonModal.waitModalDisappear();

        ///VP2: User profile dislays on the top right
        By byLnkProfile = By.xpath("//a[div[contains(@class,'jss12')]]");
        WebElement lnkProfile = wait.until(ExpectedConditions.elementToBeClickable(byLnkProfile));
        lnkProfile.click();

        ///VP3: Logout link displays
        By byLnkLogo = By.xpath("//img[@alt='Logo']");
        WebElement lnkLogo = wait.until(ExpectedConditions.visibilityOfElementLocated(byLnkLogo));
        System.out.println("Logo: " + lnkLogo.isDisplayed());

    }
}
