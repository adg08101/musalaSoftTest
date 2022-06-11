package core.musala.positions.experienced_automation_qa_engineer.page;

import general.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.awt.*;

public class ExperiencedAutomationQaEngineerPage extends PageObject {
    private final By headerLocator = By.xpath("//h1[text()='Automation QA Engineer']");

    public ExperiencedAutomationQaEngineerPage() throws AWTException {
        super();
        setUrlPath("https://www.musala.com/job/experienced-automation-qa-engineer/");
    }

    public boolean verifyPage() {
        waitForElementAndSet(headerLocator);

        getGeneralDescriptionSection();
        Assert.assertTrue(getElement().isDisplayed());

        getRequirementsSection();
        Assert.assertTrue(getElement().isDisplayed());

        getResponsibilitiesSection();
        Assert.assertTrue(getElement().isDisplayed());

        getWhatWeOfferSection();
        Assert.assertTrue(getElement().isDisplayed());

        return true;
    }

    public boolean verifyButton(String text) {
        waitForElementAndSet(By.xpath("//input[@type='button' and @value='" + text + "']"));
        return getElement().isDisplayed();
    }

    public boolean clickButton(String button) {
        print(button);
        print(isPageReady());

        waitForElementAndSet(By.xpath("//input[@type='button' and @value='" + button + "']"));

        scrollDownToElementAndSet(By.xpath(
                "//input[@type='button' and @value='" + button + "']"),
                getWebElement(By.xpath("//html")));

        clickOnItem(getElement());

        return true;
    }
}
