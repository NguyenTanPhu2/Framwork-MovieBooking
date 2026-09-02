package Pages.components;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopNavigation extends BasePage {

    private By byLnkLogin;
    private By byLnkRegister;
    private By byLnkProfile;


    public TopNavigation(WebDriver driver) {
        super(driver);
        this.byLnkLogin = By.xpath("//a[h3[text()='Đăng Nhập']]");
        this.byLnkRegister = By.xpath("//a[h3[text()='Đăng Ký' ]]");
        this.byLnkProfile = By.xpath("//a[@href='/account']");
    }

    public void navigateLoginPage(){click(byLnkLogin);}

    public void navigatesRegisterPage(){click(byLnkRegister);}

    public boolean isUserLoggedIn() {
      return isElementDisplayed(byLnkProfile);
    }

}
