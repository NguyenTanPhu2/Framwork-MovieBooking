package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends CommonPage{

    private By byTxtLoginAccount;
    private By byTxtLoginPassword;
    private By byBtnLogin;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.byTxtLoginAccount = By.id("taiKhoan");
        this.byTxtLoginPassword = By.id("matKhau");
        this.byBtnLogin = By.xpath("//button[//span[text()='Đăng nhập'] and @type = 'submit']");

    }

    //method
    public void enterAccount(String account){
        sendKeys(byTxtLoginAccount,account);
    }

    public void enterPassword(String password){
        sendKeys(byTxtLoginPassword, password);
    }

    public void clickLogin(){
        click(byBtnLogin);
    }

    ///High level action (Business action)
    public void login(String account, String password){
        enterAccount(account);
        enterPassword(password);
        clickLogin();
    }
}
