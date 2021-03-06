package core.musala.careers;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.awt.*;

public class CareerStepDefinition {
    private CareerStep careerStep;

    public CareerStepDefinition() throws AWTException {
        careerStep = new CareerStep();
    }

    @Then("Click Check our open positions button")
    public void clickCheckOurOpenPositionsButton() {
        careerStep.checkOpenPositions();
    }

    @And("Choose open position by {string}")
    public void chooseOpenPositionBy(String position) {
        careerStep.choosePosition(position);
    }
}
