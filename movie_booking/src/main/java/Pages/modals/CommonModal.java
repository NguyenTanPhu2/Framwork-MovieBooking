package Pages.modals;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonModal extends BasePage {

    private By byLbMessage;
    private By byLbErrorMessage;
    private By byLbRequiredAccountMessage;
    private By byLbRequiredPasswordMessage;

    public CommonModal(WebDriver driver) {
        super(driver);
        this.byLbMessage = By.id("swal2-title");
        this.byLbErrorMessage =By.xpath("//div[text()='Tài khoản hoặc mật khẩu không đúng!']");
        this.byLbRequiredAccountMessage = By.xpath("//p[@id='taiKhoan-helper-text']");
        this.byLbRequiredPasswordMessage = By.xpath("//p[@id='matKhau-helper-text']");
    }

    public String getMessageText(){
        return getText(byLbMessage);
    }

    public String getErrorMessageText(){
        return getText(byLbErrorMessage);
    }

    public String getRequiredAccountMessageText(){
        return getText(byLbRequiredAccountMessage);
    }

    public String getRequiredPasswordMessageText(){
        return getText(byLbRequiredPasswordMessage);
    }

    public void waitModalDisappear(){
        waitInVisibilityOfElementLocated(byLbMessage);
    }


}
