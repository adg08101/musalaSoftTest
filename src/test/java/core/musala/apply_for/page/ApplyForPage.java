package core.musala.apply_for.page;

import general.PageObject;
import general.Setup;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ApplyForPage extends PageObject {
    private final By cvLocator = By.name("uploadtextfield");
    private final By linkedinLocator = By.name("linkedin");
    private final By agreeLocator = By.name("adConsentChx");
    private final By closeBtnLocator = By.xpath("//button[text()='Close']");

    public boolean validateData() {
        emptyFieldsTest();

        waitForElementAndSet(closeBtnLocator);
        waitForElementsToBeClickable(closeBtnLocator);
        getElement().click();

        wrongFormatFieldsTest();

        uploadCv();

        return true;
    }

    public void emptyFieldsTest() {
        waitForElementAndSet(agreeLocator);
        clickOnItem(agreeLocator);

        waitForElementAndSet(sendBtnLocator);
        waitForElementsToBeClickable(sendBtnLocator);
        getElement().click();

        waitForElementAndSet(errorsOnFormLocator);

        errorMessageLocator = errorMessageLocator.replace("message", "The field is required.");

        Assert.assertTrue(waitForElementsToCount(By.xpath(errorMessageLocator), 4));
    }

    public void uploadCv() {
        waitForElementAndSet(cvLocator);
        waitForElementsToBeClickable(cvLocator);
        getElement().click();

        Setup.waitTime(2);

        Setup.getActions().sendKeys(Keys.ESCAPE);

        Setup.waitTime(2);

        getElement().sendKeys("fakeFile.pdf");

        Setup.waitTime(5);
    }

    public void wrongFormatFieldsTest() {
        waitForElementAndSet(emailLocator);
        sendKeysToInput(getFaker().phoneNumber().phoneNumber(), emailLocator);

        waitForElementAndSet(sendBtnLocator);
        waitForElementsToBeClickable(sendBtnLocator);
        getElement().click();

        waitForElementAndSet(errorsOnFormLocator);

        // Keeps on adding nodes to the DOM
        Assert.assertTrue(waitForElementsToCount(By.xpath(errorMessageLocator), 7));

        errorMessageLocator = errorMessageLocator.replace("The field is required.",
                "The e-mail address entered is invalid.");

        waitForElementAndSet(closeBtnLocator);
        waitForElementsToBeClickable(closeBtnLocator);
        getElement().click();

        Assert.assertTrue(waitForElementsToCount(By.xpath(errorMessageLocator), 1));
    }
}
