package core.musala.index.page;

import general.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class IndexPage extends PageObject {
    private WebElement siteLogo;
    private String title = "Musala Soft";

    public IndexPage() {
        super();
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
