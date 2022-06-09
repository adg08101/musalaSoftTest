package core.musala.contact.page;

import general.PageObject;
import org.openqa.selenium.By;

public class ContactPage extends PageObject {
    private final By nameLocator = By.xpath("//input[@name='your-name']");
    private final By emailLocator = By.xpath("//input[@name='your-email']");
    private final By mobileLocator = By.xpath("//input[@name='mobile-number']");
    private final By subjectLocator = By.xpath("//input[@name='your-subject']");
    private final By messageLocator = By.xpath("//textarea[@name='your-message']");
    private final By sendBtnLocator = By.xpath("//input[@type='submit']");
    private final By emailErrorMessage = By.xpath("//a[text()='The e-mail address entered is invalid.']");

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
}
