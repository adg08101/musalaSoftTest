package core.musala.positions.experienced_automation_qa_engineer;

import core.musala.positions.experienced_automation_qa_engineer.page.ExperiencedAutomationQaEngineerPage;
import org.junit.Assert;

public class ExperiencedAutomationQaEngineerStep {
    private final ExperiencedAutomationQaEngineerPage experiencedAutomationQaEngineerPage =
            new ExperiencedAutomationQaEngineerPage();

    public void verifyPage() {
        Assert.assertTrue(experiencedAutomationQaEngineerPage.verifyPage());
    }

    public void verifyButton(String text) {
        Assert.assertTrue(experiencedAutomationQaEngineerPage.verifyButton(text));
    }

    public void clickButton(String button) {
        Assert.assertTrue(experiencedAutomationQaEngineerPage.clickButton(button));
    }
}
