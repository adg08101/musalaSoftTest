package core.musala.apply_for;

import core.musala.apply_for.page.ApplyForPage;
import org.junit.Assert;

public class ApplyForStep {
    private final ApplyForPage applyForPage = new ApplyForPage();

    public void prepareTestDataSet() {
        Assert.assertTrue(applyForPage.validateData());
    }
}
