package core.musala.apply_for.page;

import general.PageObject;
import general.Setup;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ApplyForPage extends PageObject {
    private final By cvLocator = By.name("uploadtextfield");
    private final By linkedinLocator = By.name("linkedin");
    private final By agreeLocator = By.name("adConsentChx");
    private final By closeBtnLocator = By.xpath("//button[text()='Close']");
    private final String fakeCV =
            "https://docs.google.com/document/d/1Q0Bugp_2NaLBiLwVAXN0GMpjLVhYLgLBKhgTQUkCkes/edit?usp=sharing";

    public ApplyForPage() throws AWTException {
    }

    public boolean validateData() {
        emptyFieldsTest();

        clickCloseBtn();

        wrongFormatFieldsTest();

        finalChecks();

        return true;
    }

    private void finalChecks() {
        Assert.assertTrue(waitForElementsToCount(
                By.xpath(errorMessageLocator.replace("message", "The field is required.")), 3));
        Assert.assertTrue(waitForElementsToCount(
                By.xpath(errorMessageLocator.replace("message",
                        "The e-mail address entered is invalid.")), 1));
        Assert.assertTrue(waitForElementsToCount(
                By.xpath(errorMessageLocator.replace("message",
                        "Please verify that you are not a robot.")), 1));
    }

    public void emptyFieldsTest() {
        waitForElementAndSet(agreeLocator);
        clickOnItem(agreeLocator);

        clickSendBtn();

        waitForElementAndSet(errorsOnFormLocator);

        Assert.assertTrue(waitForElementsToCount(
                By.xpath(errorMessageLocator.replace("message", "The field is required.")), 4));
    }

    public void uploadCv() {
        waitForElementAndSet(cvLocator);
        waitForElementsToBeClickable(cvLocator);
        getElement().click();

        // Static time wait strategy (Not good)
        Setup.waitTime(2);

        // Work around for Robot to upload file
        getRobot().keyPress(KeyEvent.VK_ESCAPE);
        getRobot().keyRelease(KeyEvent.VK_ESCAPE);

        // Static time wait strategy (Not good)
        Setup.waitTime(2);

        getElement().sendKeys(fakeCV);
    }

    public void wrongFormatFieldsTest() {
        waitForElementAndSet(emailLocator);
        sendKeysToInput(getFaker().phoneNumber().phoneNumber(), emailLocator);

        clickSendBtn();

        waitForElementAndSet(errorsOnFormLocator);

        // Keeps on adding nodes to the DOM
        Assert.assertTrue(waitForElementsToCount(By.xpath(
                errorMessageLocator.replace("message", "The field is required.")), 7));

        clickCloseBtn();

        Assert.assertTrue(waitForElementsToCount(By.xpath(errorMessageLocator.replace("message",
                "The e-mail address entered is invalid.")), 1));
    }

    private void clickSendBtn() {
        waitForElementAndSet(sendBtnLocator);
        waitForElementsToBeClickable(sendBtnLocator);
        getElement().click();
    }

    private void clickCloseBtn() {
        waitForElementAndSet(closeBtnLocator);
        waitForElementsToBeClickable(closeBtnLocator);
        getElement().click();
    }

    public boolean uploadCVAndSend() {
        uploadCv();

        clickSendBtn();

        return true;
    }

    public boolean verifyErrorMessages() {
        finalChecks();
        return true;
    }
}
