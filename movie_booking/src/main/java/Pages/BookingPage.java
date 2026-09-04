package Pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingPage extends BasePage {

    private By byChooseSeat;
    private By byBooking;

    public BookingPage(WebDriver driver) {
        super(driver);
        this.byBooking = By.xpath("//button[span[text()='ĐẶT VÉ']]");
    }

    public void clickOnSeat(int numSeat){
        this.byChooseSeat = By.xpath("//button[span[text()='" + numSeat + "']]");
        click(byChooseSeat);
    }

    public void clickOnBooking(){
        click(byBooking);
    }

}
