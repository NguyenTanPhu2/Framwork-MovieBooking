package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BannerPage extends CommonPage {

private By byBannerImages;

    public BannerPage(WebDriver driver) {
        super(driver);
        this.byBannerImages = By.xpath("//img[@alt='Img alt']");
    }

    public boolean isAltTextDisplayed(){
        return isElementDisplayed(byBannerImages);
    }

    public boolean isAltTextDisplayedAfterRefresh() {
        return isElementDisplayed(byBannerImages);
    }

}
