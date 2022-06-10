package core.musala.company;

import io.cucumber.java.en.Then;

public class CompanyStepDefinition {
    private CompanyStep companyStep;

    public CompanyStepDefinition() {
        companyStep = new CompanyStep();
    }

    @Then("Verify that the correct URL loads")
    public void verifyThatTheCorrectURLLoads() {
        companyStep.verifyPage();
    }
}
