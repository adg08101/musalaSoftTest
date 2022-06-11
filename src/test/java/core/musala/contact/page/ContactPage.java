package core.musala.contact.page;

import general.PageObject;
import org.openqa.selenium.By;

import java.awt.*;

public class ContactPage extends PageObject {
    private final By subjectLocator = By.xpath("//input[@name='your-subject']");

    public ContactPage() throws AWTException {
    }

    public boolean fillAllFieldsNotEmail() {
        try {
            waitForElementAndSet(nameLocator);
            sendKeysToInput(getFaker().name().fullName(), nameLocator);
            waitForElementAndSet(mobileLocator);
            sendKeysToInput(getFaker().phoneNumber().phoneNumber(), mobileLocator);
            waitForElementAndSet(subjectLocator);
            sendKeysToInput(getFaker().superhero().name() + " " + getFaker().color().name(), subjectLocator);
            waitForElementAndSet(messageLocator);
            sendKeysToInput(getFaker().address().fullAddress(), messageLocator);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean fillEmailWrongFormat(String email) {
        waitForElementAndSet(nameLocator);
        getElement().clear();
        sendKeysToInput(email, emailLocator);
        return true;
    }

    public boolean clickSendButton() {
        waitForElementAndSet(sendBtnLocator);
        clickOnItem(getElement());
        return true;
    }

    public boolean verifyErrorMessage(String errorMessage) {
        waitForElementAndSet(errorsOnFormLocator);
        waitForElementAndSet(By.xpath(errorMessageLocator.replace("message", errorMessage)));
        return getElement().isDisplayed();
    }
}
