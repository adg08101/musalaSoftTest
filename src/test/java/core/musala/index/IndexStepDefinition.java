package core.musala.index;

import io.cucumber.java.en.When;

import java.awt.*;

public class IndexStepDefinition {
    IndexStep indexStep;

    public IndexStepDefinition() throws AWTException {
        indexStep = new IndexStep();
    }

    @When("Click Company tab from the top")
    public void clickCompanyTabFromTheTop() {
        indexStep.clickCompanyTab();
    }

    @When("Click Careers tab from the top")
    public void clickCareersTabFromTheTop() {
        indexStep.clickCareersTab();
    }
}
