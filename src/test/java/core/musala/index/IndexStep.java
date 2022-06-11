package core.musala.index;

import core.musala.index.page.IndexPage;
import org.junit.Assert;

import java.awt.*;

public class IndexStep {
    private final IndexPage indexPage;

    public IndexStep() throws AWTException {
        this.indexPage = new IndexPage();
    }

    public IndexPage getIndexPage() {
        return indexPage;
    }

    public void clickCompanyTab() {
        Assert.assertTrue(indexPage.clickCompanyTab());
    }

    public void clickCareersTab() {
        Assert.assertTrue(indexPage.clickCareersTab());
    }
}