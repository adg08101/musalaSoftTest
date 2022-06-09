package general;

import core.musala.index.IndexStep;
import io.cucumber.java.en.Given;
import org.junit.Assert;

import java.util.Arrays;

public class GeneralSteps extends PageObject {
    private IndexStep indexStep;

    public GeneralSteps() {
        super();
        setIndexStep(new IndexStep());
    }

    @Given("The user is at baseUrl")
    public void the_user_is_at_base_url() {
        Assert.assertTrue(indexStep.getIndexPage().isIndexViewRendered());
        getDriver().manage().window().fullscreen();
    }

    @Given("The user scrolls down to {string}")
    public void the_user_scrolls_down_to(String anchor) throws InterruptedException {
        String[] indexAnchors = {
                "ContactUs"
        };

        if (Arrays.asList(indexAnchors).contains(anchor))
            Assert.assertTrue(indexStep.getIndexPage().scrollDownToElement(anchor));
    }

    public IndexStep getIndexPage() {
        return indexStep;
    }

    public void setIndexStep(IndexStep indexStep) {
        this.indexStep = indexStep;
    }
}
