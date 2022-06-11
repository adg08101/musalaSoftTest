package core.musala.facebook;

import core.musala.facebook.page.FacebookPage;
import org.junit.Assert;

import java.awt.*;

public class FacebookStep {
    private FacebookPage facebookPage;

    public FacebookStep() throws AWTException {
        facebookPage = new FacebookPage();
    }

    public void verifyPage() {
        Assert.assertTrue(facebookPage.verifyPage());
    }
}
