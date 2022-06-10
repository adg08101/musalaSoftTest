package core.musala.company.page;

import general.PageObject;
import general.Setup;
import org.openqa.selenium.By;

public class CompanyPage extends PageObject {
    private final String url = "https://www.musala.com/company/";
    private final By h1Locator = By.xpath("//h1[text()='WE ARE MUSALA SOFT']");

    public boolean verifyPage() {
        waitForElementAndSet(h1Locator);

        while (!isPageReady()) {
            print("Page still not loaded");
            Setup.waitTime(5);
            verifyPage();
        }

        print("Page now loaded");

        print(isPageReady() + "--" + getDriver().getCurrentUrl() + "--" + url);

        return getDriver().getCurrentUrl().equals(url);
    }
}
