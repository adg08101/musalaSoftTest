package core.musala.careers;

import io.cucumber.java.en.Then;

public class CareerStepDefinition {
    private CareerStep careerStep;

    public CareerStepDefinition() {
        careerStep = new CareerStep();
    }

    @Then("Click Check our open positions button")
    public void clickCheckOurOpenPositionsButton() {
        careerStep.checkOpenPositions();
    }
}
