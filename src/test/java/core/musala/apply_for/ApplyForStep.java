package core.musala.apply_for;

import core.musala.apply_for.page.ApplyForPage;
import org.junit.Assert;

import java.awt.*;

public class ApplyForStep {
    private final ApplyForPage applyForPage = new ApplyForPage();

    public ApplyForStep() throws AWTException {
    }

    public void prepareTestDataSet() {
        Assert.assertTrue(applyForPage.validateData());
    }

    public void uploadCVAndSend() {
        Assert.assertTrue(applyForPage.uploadCVAndSend());
    }

    public void verifyErrorMessages() {
        Assert.assertTrue(applyForPage.verifyErrorMessages());
    }
}
