package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogOutPage extends CommonPage{
    private By byBtnLogOut;
    private By byBtnConfirmYes;

    public LogOutPage(WebDriver driver) {
        super(driver);
        this.byBtnLogOut = By.xpath("//a[@href='/']");
        this.byBtnConfirmYes = By.xpath("//button[text()='Đồng ý']");
    }

    public void clickBtnLogOut(){
        click(byBtnLogOut);
    }

    public void clickBtnConfirmYes(){
        click(byBtnConfirmYes);
    }

}
