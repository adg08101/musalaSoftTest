package core.musala.company;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.awt.*;

public class CompanyStepDefinition {
    private CompanyStep companyStep;

    public CompanyStepDefinition() throws AWTException {
        companyStep = new CompanyStep();
    }

    @Then("Verify that the correct URL loads")
    public void verifyThatTheCorrectURLLoads() {
        companyStep.verifyPage();
    }

    @And("Verify that there is {string} section")
    public void verifyThatThereIsSection(String section) {
        companyStep.checkForSection(section);
    }

    @Then("Click the Facebook link from the footer")
    public void clickTheFacebookLinkFromTheFooter() {
        companyStep.clickFacebookLink();
    }
}
