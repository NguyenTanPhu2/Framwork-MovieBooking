package Pages.components;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopNavigation extends BasePage {

    private By byLnkLogin;
    private By byLnlRegister;


    public TopNavigation(WebDriver driver) {
        super(driver);
        this.byLnkLogin = By.xpath("//a[h3[text()='Đăng Nhập']]");
        this.byLnlRegister = By.xpath("//a[h3[text()='Đăng Ký' ]]");
    }

    public void navigateLoginPage(){click(byLnkLogin);}

    public void navigatesRegisterPage(){click(byLnlRegister);}
}
