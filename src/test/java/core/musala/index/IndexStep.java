package core.musala.index;

import core.musala.index.page.IndexPage;

public class IndexStep {
    private final IndexPage indexPage;

    public IndexStep() {
        this.indexPage = new IndexPage();
    }

    public IndexPage getIndexPage() {
        return indexPage;
    }
}