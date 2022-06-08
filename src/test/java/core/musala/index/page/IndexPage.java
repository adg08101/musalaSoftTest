package core.musala.index.page;

import general.PageObject;
import general.Property;
import general.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Locale;

public class IndexPage extends PageObject {
    private WebElement siteLogo;
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
    }

    public WebElement getSiteLogo() {
        return siteLogo;
    }

    public void setSiteLogo(WebElement siteLogo) {
        this.siteLogo = siteLogo;
    }

    public boolean isIndexViewRendered() {
        return getSiteLogo() != null && getDriver().getTitle() == this.title;
    }
}
