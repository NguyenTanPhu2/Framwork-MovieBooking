package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MovieDetails extends CommonPage {

    private By byClickOnTime;
    private By byClickBooking;

    public MovieDetails(WebDriver driver) {
        super(driver);
        this.byClickOnTime = By.xpath("//a[@href = '/purchase/45243']");
        this.byClickBooking=By.xpath("//a[text()='Mua vé']");
    }

    public void clickOnTimeFilm(){
//        click(byClickBooking);
        click(byClickOnTime);
    }

}
