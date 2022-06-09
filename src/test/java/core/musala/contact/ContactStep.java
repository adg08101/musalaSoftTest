package core.musala.contact;

import core.musala.contact.page.ContactPage;
import general.Property;
import general.Setup;
import org.junit.Assert;

public class ContactStep {
    private ContactPage contactPage;

    public ContactStep() {
        contactPage = new ContactPage();
    }

    public void fillFieldsNotEmail() {
        Assert.assertTrue(contactPage.fillAllFieldsNotEmail());
    }

    public void fillEmailWrongFormat() {
        String wrongEmailOne = (String) Setup.getPropertyFromKey(Property.BAD_EMAIL_ONE);
        Assert.assertTrue(contactPage.fillEmailWrongFormat(wrongEmailOne));
    }

    public void clickSendButton() {
        Assert.assertTrue(contactPage.clickSendButton());
    }
}
