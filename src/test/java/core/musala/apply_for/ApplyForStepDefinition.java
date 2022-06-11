package core.musala.apply_for;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.awt.*;

public class ApplyForStepDefinition {
    private final ApplyForStep applyForStep = new ApplyForStep();

    public ApplyForStepDefinition() throws AWTException {
    }

    @Then("Prepare a few sets of negative data")
    public void prepareAFewSetsOfNegativeData() {
        applyForStep.prepareTestDataSet();
    }

    @And("Upload a CV document and click Send")
    public void uploadACVDocumentAndClickSend() {
        applyForStep.uploadCVAndSend();
    }

    @Then("Verify shown error messages")
    public void verifyShownErrorMessages() {
        applyForStep.verifyErrorMessages();
    }
}
