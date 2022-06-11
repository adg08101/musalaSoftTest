package core.musala.join_us;

import core.musala.join_us.page.JoinUsPage;
import org.junit.Assert;

import java.awt.*;

public class JoinUsStep {
    private JoinUsPage joinUsPage = new JoinUsPage();

    public JoinUsStep() throws AWTException {
    }

    public void verifyPage() {
        Assert.assertTrue(joinUsPage.verifyPage());
    }

    public void selectLocation(String location) {
        Assert.assertTrue(joinUsPage.selectLocation(location));
    }
}
