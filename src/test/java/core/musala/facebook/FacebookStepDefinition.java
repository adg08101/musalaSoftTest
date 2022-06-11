package core.musala.facebook;

import io.cucumber.java.en.Then;

import java.awt.*;

public class FacebookStepDefinition {
    private FacebookStep facebookStep;

    public FacebookStepDefinition() throws AWTException {
        facebookStep = new FacebookStep();
    }

    @Then("Verify that the correct URL and profile picture loads")
    public void verifyPage() {
        facebookStep.verifyPage();
    }
}
