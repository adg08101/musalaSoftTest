package general;

import core.musala.index.page.IndexPage;
import io.cucumber.java.en.Given;
import org.junit.Assert;

public class GeneralSteps extends PageObject {
    public GeneralSteps() {
        super();
    }

    @Given("The user is at baseUrl")
    public void the_user_is_at_base_url() {
        IndexPage indexPage = new IndexPage();
        Assert.assertTrue(indexPage.isIndexViewRendered());
    }

    @Given("The user scrolls down to {string}")
    public void the_user_scrolls_down_to(String anchor) {
        Assert.assertTrue(true);
    }
}
