package core.musala.index;

import io.cucumber.java.en.When;

public class IndexStepDefinition {
    IndexStep indexStep;

    public IndexStepDefinition() {
        indexStep = new IndexStep();
    }

    @When("Click Company tab from the top")
    public void clickCompanyTabFromTheTop() {
        indexStep.clickCompanyTab();
    }
}
