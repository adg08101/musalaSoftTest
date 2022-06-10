package core.musala.careers.page;

import general.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;

public class CareerPage extends PageObject {
    private final By pageH1Locator = By.xpath("//h1[text()='Careers']");
    private final String url = "https://www.musala.com/careers/";
    private final By checkOpenPositionsBtn = By.xpath("//span[text()='Check our open positions']/ancestor::button");

    private void verifyPage() {
        waitForElementAndSet(pageH1Locator);
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }

    public boolean clickOpenPositions() {
        verifyPage();
        waitForElementAndSet(checkOpenPositionsBtn);
        clickOnItem(getElement());
        return true;
    }
}
