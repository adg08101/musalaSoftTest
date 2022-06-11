package core.musala.contact;

import core.musala.contact.page.ContactPage;
import general.Property;
import general.Setup;
import org.junit.Assert;

import java.awt.*;

public class ContactStep {
    private ContactPage contactPage;

    public ContactStep() throws AWTException {
        contactPage = new ContactPage();
    }

    public void fillFieldsNotEmail() {
        Assert.assertTrue(contactPage.fillAllFieldsNotEmail());
    }

    public void fillEmailWrongFormat(String badEmail) {
        String email;

        switch (badEmail) {
            case "badEmailOne":
                email = (String) Setup.getPropertyFromKey(Property.BAD_EMAIL_ONE);
                break;
            case "badEmailTwo":
                email = (String) Setup.getPropertyFromKey(Property.BAD_EMAIL_TWO);
                break;
            case "badEmailThree":
                email = (String) Setup.getPropertyFromKey(Property.BAD_EMAIL_THREE);
                break;
            case "badEmailFour":
                email = (String) Setup.getPropertyFromKey(Property.BAD_EMAIL_FOUR);
                break;
            case "badEmailFive":
                email = (String) Setup.getPropertyFromKey(Property.BAD_EMAIL_FIVE);
                break;
            default:
                email = "test@test";
        }

        Assert.assertTrue(contactPage.fillEmailWrongFormat(email));
    }

    public void clickSendButton() {
        Assert.assertTrue(contactPage.clickSendButton());
    }

    public void verifyErrorMessage(String errorMessage) {
        Assert.assertTrue(contactPage.verifyErrorMessage(errorMessage));
    }
}
