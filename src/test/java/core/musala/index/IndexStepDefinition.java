package core.musala.index;

import io.cucumber.java.en.When;

public class IndexStepDefinition {
    IndexStep indexStep;

    public IndexStepDefinition() {
        indexStep = new IndexStep();
    }

    @When("Click Company tap from the top")
    public void clickCompanyTapFromTheTop() {
        indexStep.clickCompanyTab();
    }
}
