package core.musala.index;

import core.musala.index.page.IndexPage;
import org.junit.Assert;

public class IndexStep {
    private final IndexPage indexPage;

    public IndexStep() {
        this.indexPage = new IndexPage();
    }

    public IndexPage getIndexPage() {
        return indexPage;
    }

    public void clickCompanyTab() {
        Assert.assertTrue(indexPage.clickCompanyTab());
    }
}