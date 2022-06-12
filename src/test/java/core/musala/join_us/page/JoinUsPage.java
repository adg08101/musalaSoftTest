package core.musala.join_us.page;

import general.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;

import java.awt.*;

public class JoinUsPage extends PageObject {
    private final By heroLocator =
            By.xpath("//img[@src='https://www.musala.com/wp-content/uploads/2020/11/join_us_from_anywhere_header.jpg']");
    private final String url = "https://www.musala.com/careers/join-us/";
    private final By locationSelectorLocator = By.id("get_location");
    private final By scrollContainer = By.xpath("html");

    public JoinUsPage() throws AWTException {
    }

    public boolean verifyPage() {
        waitForElementAndSet(heroLocator);
        waitForElementVisibility(heroLocator);

        return getElement().isDisplayed() && getDriver().getCurrentUrl().equals(url);
    }

    public boolean selectLocation(String location) {
        waitForElementAndSet(locationSelectorLocator);
        clickOnItem(getElement());
        getElement().sendKeys(location.substring(0, 1));
        print(location);
        try {
            getElement().sendKeys(Keys.RETURN);
        } catch (StaleElementReferenceException e) {
            zoomInOrOut(false, 5);
        }

        verifyPage();
        printResult();

        return true;
    }

    private void printResult() {
        print("Give me some!!");

        print("Give me some positions offers!!");

        print("Follow this hint for tomorrow, to much rum...");

        // TODO Follow hint
        print("//article[contains(@class, 'card-jobsHot')]/descendant::p[@class='card-jobsHot__location'and text()='Sofia']");
    }
}
