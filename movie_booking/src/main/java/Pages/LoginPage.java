package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends CommonPage {

    private By byTxtLoginAccount;
    private By byTxtLoginPassword;
    private By byBtnLogin;
    private By byLnkProfile;
    private By byLnkLogout;
    private By byChkRememberMe;
    private By byBtnConfirmLogout;
    private By byLnkLoginFromRegisterPage;
    private By byBtnHidePassword;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.byTxtLoginAccount = By.id("taiKhoan");
        this.byTxtLoginPassword = By.id("matKhau");
        this.byBtnLogin = By.xpath("//button[//span[text()='Đăng nhập'] and @type = 'submit']");
        this.byLnkProfile = By.xpath("//a[@href='/account']");
        this.byLnkLogout = By.xpath("//a[h3[text()='Đăng xuất']]");
        this.byChkRememberMe = By.xpath("//input[@name='remember']/ancestor::span[contains(@class,'MuiCheckbox-root')]");
        this.byBtnConfirmLogout = By.xpath("//button[text()='Đồng ý']");
        this.byLnkLoginFromRegisterPage = By.xpath("//h3[contains(@class,'MuiTypography-h3') and text()='Bạn đã có tài khoản? Đăng nhập']");
        this.byBtnHidePassword = By.xpath("//button[contains(@class,'MuiIconButton-edgeEnd')]");
    }

    //method
    public void enterAccount(String account) {
        sendKeys(byTxtLoginAccount, account);
    }

    public void enterPassword(String password) {
        sendKeys(byTxtLoginPassword, password);
    }

    public void clickLogin() {
        click(byBtnLogin);
    }

    public void clickProfile() {
        click(byLnkProfile);
    }

    public void clickLogout() {
        click(byLnkLogout);
    }

    public void clickRememberMeCheckbox() {
        click(byChkRememberMe);
    }

    public void clickHidePassword() {
        click(byBtnHidePassword);
    }

    public void clickConfirmLogout() {
        click(byBtnConfirmLogout);
    }

    public String getAttributeText(String attributeName) {
        return getAttribute(byTxtLoginAccount, attributeName);
    }


    public void clickLoginFromRegisterPage() {
        click(byLnkLoginFromRegisterPage, 30);

    }

    /// High level action (Business action)
    public void login(String account, String password) {
        enterAccount(account);
        enterPassword(password);
        clickLogin();
    }
}
