package Pages.components;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopNavigation extends BasePage {

    private By byLnkLogin;
    private By byLnkRegister;
    private By byLnkProfile;
    private By byLnkLogo;
    private By byLnkShowTime;
    private By byLnkTheater;
    private By byLnkNews;
    private By byApplication;

    public TopNavigation(WebDriver driver) {
        super(driver);
        this.byLnkLogin = By.xpath("//a[h3[text()='Đăng Nhập']]");
        this.byLnkRegister = By.xpath("//a[h3[text()='Đăng Ký']]");
        this.byLnkProfile = By.xpath("//a[@href='/account']");
        this.byLnkLogo = By.xpath("//img[@alt='Logo']");
        this.byLnkShowTime = By.xpath("//a[h4[text()='Lịch Chiếu']]");
        this.byLnkTheater = By.xpath("//a[h4[text()='Cụm Rạp']]");
        this.byLnkNews = By.xpath("//a[h4[text()='Tin Tức']]");
        this.byApplication = By.xpath("//a[h4[text()='Ứng Dụng']]");

    }

    public void navigateLoginPage() {
        click(byLnkLogin);
    }

    public void navigatesRegisterPage() {
        click(byLnkRegister);
    }

    public boolean isUserLoggedIn() {
        return isElementDisplayed(byLnkProfile);
    }

    public void clickLogoToHomePage() {
        click(byLnkLogo);
    }

    public void clickShowTime() {
        click(byLnkShowTime);
    }

    public void clickTheater() {
        click(byLnkTheater);
    }

    public void clickNews() {
        click(byLnkNews);
    }

    public void clickApplication(){
        click(byApplication);
    }
}
