package core.musala.join_us.page;

import core.parser.Parser;
import core.parser.positions.Position;
import core.parser.positions.Positions;
import general.PageObject;
import general.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

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

        return true;
    }

    public boolean getPositions(String location) {
        waitForElementsAndSet(By.xpath("//article[contains(@class, " +
                "'card-jobsHot')]/descendant::p[@class='card-jobsHot__location'and " +
                        "contains(text(), '" + location + "') or text()='Anywhere']/ancestor::a"));

        for (WebElement position: getElements())
            Parser.Parse(position);

        // Safety net to wait for elements processing
        // Mostly FireFox takes longer to process
        Setup.waitTime(10);

        return true;
    }

    public boolean printPositions() {
        String location = "";

        for (Position position: Positions.getPositions()
             ) {
            if (!position.getLocation().equals(location)) {
                consoleLog(position.getLocation());
                location = position.getLocation();
            }

            consoleLog("Position: " + position.getPosition());
            consoleLog("More info: " + position.getInfo());
        }

        openConsole();

        Setup.waitTime(20);

        return true;
    }
}
