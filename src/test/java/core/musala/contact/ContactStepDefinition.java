package core.musala.contact;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.awt.*;

public class ContactStepDefinition {
    ContactStep contactStep;

    public ContactStepDefinition() throws AWTException {
        contactStep = new ContactStep();
    }

    @Then("Fill all required fields except email")
    public void fillAllRequiredFieldsExceptEmail() {
        contactStep.fillFieldsNotEmail();
    }

    @Then("Under email field enter string with wrong {string} format")
    public void underEmailFieldEnterStringWithWrongFormat(String badEmail) {
        contactStep.fillEmailWrongFormat(badEmail);
    }

    @When("Click Send button")
    public void clickSendButton() {
        contactStep.clickSendButton();
    }

    @Then("Verify that error message {string} appears")
    public void verifyThatErrorMessageTheEMailAddressEnteredIsInvalidAppears(String errorMessage) {
        contactStep.verifyErrorMessage(errorMessage);
    }
}
