package core.musala.company.page;

import general.PageObject;
import general.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.awt.*;

public class CompanyPage extends PageObject {
    private final String url = "https://www.musala.com/company/";
    private final By h1Locator = By.xpath("//h1[text()='WE ARE MUSALA SOFT']");
    private String stringSectionLocator = "//h2[text()='section']";
    private final WebElement scrollReceiver = getWebElement(By.xpath("//html"));
    private final WebElement cookiesBtn = getWebElement(By.xpath("" +
            "//a[@role='button' and @data-cli_action='accept_all']"));
    private final WebElement acceptCookiesBtn = getWebElement(By.xpath("//a[@id='wt-cli-accept-all-btn']"));
    private final String facebookUrl = "https://www.facebook.com/MusalaSoft?fref=ts";

    public CompanyPage() throws AWTException {
    }

    public boolean verifyPage() {
        waitForElementAndSet(h1Locator);

        while (!isPageReady()) {
            print("Page still not loaded");
            Setup.waitTime(5);
            verifyPage();
        }

        print("Page now loaded");

        return getDriver().getCurrentUrl().equals(url);
    }

    public WebElement verifySection(String section) {
        stringSectionLocator = stringSectionLocator.replace("section", section);
        By sectionLocator = By.xpath(stringSectionLocator);

        scrollDownToElementNoOffsetAndSet(sectionLocator, scrollReceiver);

        return getElement();
    }

    public boolean clickFacebook() {
        String facebookBtnLocator = "//span[contains(@class,'musala-icon-facebook')]/ancestor::a";
        scrollDownToElementNoOffsetAndSet(By.xpath(facebookBtnLocator), scrollReceiver);

        try {
            if (checkElementIsRendered(cookiesBtn))
                cookiesBtn.click();
                acceptCookiesBtn.click();
        } catch (StaleElementReferenceException e) {
            print("StaleElementReferenceException");
        }

        waitForElementAndSet(By.xpath(facebookBtnLocator));

        safetyNetClickOnItem(getElement());

        return getElement().getAttribute("href").equals(facebookUrl);
    }
}
