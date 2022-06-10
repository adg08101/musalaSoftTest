package core.musala.facebook;

import io.cucumber.java.en.Then;

public class FacebookStepDefinition {
    private FacebookStep facebookStep;

    public FacebookStepDefinition() {
        facebookStep = new FacebookStep();
    }

    @Then("Verify that the correct URL and profile picture loads")
    public void verifyPage() {
        facebookStep.verifyPage();
    }
}
