package core.musala.index.page;

import general.PageObject;
import general.Property;
import general.Setup;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Locale;

public class IndexPage extends PageObject {
    private WebElement siteLogo;
    private WebElement scrollReceiver;
    private By siteContactUs = By.xpath("//span[@data-alt='Contact us' and text()='Contact us']");
    private final By readyMessage = By.xpath("//span[@id='undefined' and text()='Have a long-term partner next to " +
            "you on the path of success']");
    private final By companyTab =
            By.xpath("//ul[@id='menu-main-nav-1']/descendant::" +
                    "a[@class='main-link' and text()='Company' and @href='https://www.musala.com/company/']");
    private final By careerTab =
            By.xpath("//ul[@id='menu-main-nav-1']/descendant::" +
                    "a[@class='main-link' and text()='Careers' and @href='https://www.musala.com/careers/']");
    private String view = "Musala Index";
    private String title = "Musala Soft";

    public IndexPage() {
        super();

        setView(this.view);
        setAppPrefix(getView().substring((Integer) Setup.getConfigProperties().getProperties().get(
                Property.INT_ZERO), getView().indexOf((String) Setup.getConfigProperties().getProperties().get(
                Property.CHAR_SPACE))).toUpperCase(Locale.ROOT));

        openURL(getAppPrefix());

        waitForElementAndSet(By.xpath("" +
                "//a[@class='brand' and contains(@title, 'Musala Soft')]/descendant::span[@class='logo']"));

        setSiteLogo(getElement());
        setScrollReceiver(getWebElement(By.xpath("//html")));
    }

    public WebElement getSiteLogo() {
        return siteLogo;
    }

    public void setSiteLogo(WebElement siteLogo) {
        this.siteLogo = siteLogo;
    }

    public boolean isIndexViewRendered() {
        return getSiteLogo() != null && getDriver().getTitle().equals(this.title);
    }

    public boolean scrollDownToElement(String element) throws InterruptedException {
        switch (element) {
            case "ContactUs":
                Assert.assertTrue(scrollDownToElementAndSet(siteContactUs, getScrollReceiver()));
                getElement().click();
                return true;
            default:
                return false;
        }
    }

    public WebElement getScrollReceiver() {
        return scrollReceiver;
    }

    public void setScrollReceiver(WebElement scrollReceiver) {
        this.scrollReceiver = scrollReceiver;
    }

    public boolean clickCompanyTab() {
        while (!isPageReady()) {
            Setup.waitTime(5);
            print("Page still not loaded");
            clickCompanyTab();
        }

        print("Page now loaded");

        waitForElementAndSet(readyMessage);

        waitForElementsToBeClickable(getCompanyTab());
        waitForElementAndSet(getCompanyTab());

        clickOnItem(getElement());

        // Work around as safety net
        getDriver().get(getElement().getAttribute("href"));

        return true;
    }

    public By getCompanyTab() {
        return companyTab;
    }

    public boolean clickCareersTab() {
        while (!isPageReady()) {
            Setup.waitTime(5);
            print("Page still not loaded");
            clickCareersTab();
        }

        print("Page now loaded");

        waitForElementAndSet(readyMessage);

        waitForElementsToBeClickable(careerTab);
        waitForElementAndSet(careerTab);

        clickOnItem(getElement());

        // Work around as safety net
        getDriver().get(getElement().getAttribute("href"));

        return true;
    }
}
