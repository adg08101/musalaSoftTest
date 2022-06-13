package core.musala.facebook.page;

import general.PageObject;
import org.openqa.selenium.By;

import java.awt.*;

public class FacebookPage extends PageObject {
    private final By facebookImageLocator =
            By.xpath("//img[@data-imgperflogname='profileCoverPhoto' and @src]");
    private final String url = "https://www.facebook.com/MusalaSoft?fref=ts";

    public FacebookPage() throws AWTException {
    }

    public boolean verifyPage() {
        waitForElementAndSet(facebookImageLocator);

        return getElement().isDisplayed() && getDriver().getCurrentUrl().equals(url);
    }
}
