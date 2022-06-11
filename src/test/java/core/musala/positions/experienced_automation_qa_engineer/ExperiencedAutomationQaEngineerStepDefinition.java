package core.musala.positions.experienced_automation_qa_engineer;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.awt.*;

public class ExperiencedAutomationQaEngineerStepDefinition {
    private final ExperiencedAutomationQaEngineerStep experiencedAutomationQaEngineerStep =
            new ExperiencedAutomationQaEngineerStep();

    public ExperiencedAutomationQaEngineerStepDefinition() throws AWTException {}

    @Then("Verify that main sections are shown")
    public void verifyThatMainSectionsAreShown() {
        experiencedAutomationQaEngineerStep.verifyPage();
    }

    @And("Verify that {string} button is present")
    public void verifyThatButtonIsPresent(String text) {
        experiencedAutomationQaEngineerStep.verifyButton(text);
    }

    @Then("Click {string} button")
    public void clickApplyButton(String button) {
        experiencedAutomationQaEngineerStep.clickButton(button);
    }
}
