package core.musala.facebook;

import core.musala.facebook.page.FacebookPage;
import org.junit.Assert;

public class FacebookStep {
    private FacebookPage facebookPage;

    public FacebookStep() {
        facebookPage = new FacebookPage();
    }

    public void verifyPage() {
        Assert.assertTrue(facebookPage.verifyPage());
    }
}
