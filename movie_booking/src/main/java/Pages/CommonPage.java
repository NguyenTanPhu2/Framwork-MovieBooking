package Pages;

import Pages.components.TopNavigation;
import base.BasePage;
import org.openqa.selenium.WebDriver;

public class CommonPage extends BasePage {

    private TopNavigation topNavigation;

    public CommonPage(WebDriver driver) {
        super(driver);
        this.topNavigation = new TopNavigation(driver);
    }

    //de goi navigate
    public TopNavigation getTopNavigation(){
        return this.topNavigation;
    }
}
