package core.musala.contact;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactStepDefinition {
    ContactStep contactStep;

    public ContactStepDefinition() {
        contactStep = new ContactStep();
    }

    @Then("Fill all required fields except email")
    public void fillAllRequiredFieldsExceptEmail() {
        contactStep.fillFieldsNotEmail();
    }

    @Then("Under email field enter string with wrong email format")
    public void underEmailFieldEnterStringWithWrongEmailFormat() {
        contactStep.fillEmailWrongFormat();
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
