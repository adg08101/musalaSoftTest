package core.musala.index.page;

import general.PageObject;
import general.Property;
import general.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Locale;

public class IndexPage extends PageObject {
    private WebElement siteLogo;
    private WebElement scrollReceiver;
    private WebElement siteContactUs;
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
        for (int i = 0;i < 5; i++) {
            Setup.getJsExecutor().executeScript("scrollBy(0, 100);", getScrollReceiver());
            Setup.waitTime(5);
        }
        return true;
    }

    public WebElement getSiteContactUs() {
        return siteContactUs;
    }

    public void setSiteContactUs(WebElement siteContactUs) {
        this.siteContactUs = siteContactUs;
    }

    public WebElement getScrollReceiver() {
        return scrollReceiver;
    }

    public void setScrollReceiver(WebElement scrollReceiver) {
        this.scrollReceiver = scrollReceiver;
    }
}
