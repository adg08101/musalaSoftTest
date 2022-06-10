package core.musala.join_us;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class JoinUsStepDefinition {
    private JoinUsStep joinUsStep = new JoinUsStep();

    @And("Verify that Join Us page is opened")
    public void verifyThatJoinUsPageIsOpened() {
        joinUsStep.verifyPage();
    }

    @Then("From the dropdown Select location select {string}")
    public void fromTheDropdownSelectLocationSelect(String location) {
        joinUsStep.selectLocation(location);
    }
}
