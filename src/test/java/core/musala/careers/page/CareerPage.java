package core.musala.careers.page;

import general.PageObject;
import general.Setup;
import org.junit.Assert;
import org.openqa.selenium.By;

public class CareerPage extends PageObject {
    private final By pageH1Locator = By.xpath("//h1[text()='Careers']");
    private final String url = "https://www.musala.com/careers/";
    private final By checkOpenPositionsBtn = By.xpath("//span[text()='Check our open positions']/ancestor::button");
    private String positionsLabel = "//h2[text()='position']";

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

    public boolean choosePosition(String position) {
        positionsLabel = positionsLabel.replace("position", position);
        By positionLocator = By.xpath("//h2[text()='Automation QA Engineer']");

        waitForElementAndSet(positionLocator);
        scrollDownToElementNoOffsetAndSet(positionLocator,
                getWebElement(By.xpath("//html")));

        getElement().click();

        Setup.waitTime(10);

        return true;
    }
}
