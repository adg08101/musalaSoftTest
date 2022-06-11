package core.musala.apply_for;

import io.cucumber.java.en.Then;

public class ApplyForStepDefinition {
    private final ApplyForStep applyForStep = new ApplyForStep();

    @Then("Prepare a few sets of negative data")
    public void prepareAFewSetsOfNegativeData() {
        applyForStep.prepareTestDataSet();
    }
}
