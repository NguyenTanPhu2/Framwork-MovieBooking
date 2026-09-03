package Pages.modals;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.security.PrivateKey;

public class CommonModal extends BasePage {

    private By byLbMessage;
    private By byLbErrorMessageLogin;
    private By byLbRequiredAccountMessageLogin;
    private By byLbRequiredPasswordMessageLogin;
    private By byLbRequiredAccountMessageRegister;
    private By byLbRequiredPasswordMessageRegister;
    private By byLbRequiredConfirmPasswordMessageRegister;
    private By byLbRequiredFullNameMessageRegister;
    private By byLbRequiredEmailMessageRegister;
    private By byLbErrorMessageRegister;

    public CommonModal(WebDriver driver) {
        super(driver);
        this.byLbMessage = By.id("swal2-title");

        //Login page
        this.byLbErrorMessageLogin = By.xpath("//div[text()='Tài khoản hoặc mật khẩu không đúng!']");
        this.byLbRequiredAccountMessageLogin = By.xpath("//p[@id='taiKhoan-helper-text']");
        this.byLbRequiredPasswordMessageLogin = By.xpath("//p[@id='matKhau-helper-text']");

        //Register page
        this.byLbRequiredAccountMessageRegister = By.xpath("//p[@id='taiKhoan-helper-text']");
        this.byLbRequiredPasswordMessageRegister = By.xpath("//p[@id='matKhau-helper-text']");
        this.byLbRequiredConfirmPasswordMessageRegister = By.xpath("//p[@id='confirmPassWord-helper-text']");
        this.byLbRequiredFullNameMessageRegister = By.xpath("//p[@id='hoTen-helper-text']");
        this.byLbRequiredEmailMessageRegister = By.xpath("//p[@id='email-helper-text']");
        this.byLbErrorMessageRegister = By.xpath("//div[@role ='alert']");
    }

    public String getMessageText() {
        return getText(byLbMessage);
    }

    /// Login page
    public String getErrorMessageTextLogin() {
        return getText(byLbErrorMessageLogin);
    }

    public String getRequiredAccountMessageTextLogin() {
        return getText(byLbRequiredAccountMessageLogin);
    }

    public String getRequiredPasswordMessageTextLogin() {
        return getText(byLbRequiredPasswordMessageLogin);
    }

    /// Register page
    public String getRequiredAccountMessageTextRegister() {
        return getText(byLbRequiredAccountMessageRegister);
    }

    public String getRequiredPasswordMessageTextRegister() {
        return getText(byLbRequiredPasswordMessageRegister);
    }

    public String getRequiredConfirmPasswordMessageTextRegister() {
        return getText(byLbRequiredConfirmPasswordMessageRegister);
    }

    public String getRequiredFullNameMessageTextRegister() {
        return getText(byLbRequiredFullNameMessageRegister);
    }

    public String getRequiredEmailMessageTextRegister() {
        return getText(byLbRequiredEmailMessageRegister);
    }

    public String getErrorMessageTextRegister() {
        return getText(byLbErrorMessageRegister);
    }

    public String getErrorMessageTextInvalidPasswordRegister() {
        return getText(byLbRequiredPasswordMessageRegister);
    }

    public String getErrorMessageTextPasswordRegister() {
        return getText(byLbRequiredConfirmPasswordMessageRegister);
    }

    public void waitModalDisappear() {
        waitInVisibilityOfElementLocated(byLbMessage);
    }
}
