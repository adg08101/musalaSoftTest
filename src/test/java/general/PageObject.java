package general;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class PageObject {
    private String urlPath;
    private WebDriverWait wait;
    private int waitTime;
    private Faker faker;
    private String user_name;
    private String user_password;
    private WebElement element;
    private List<WebElement> elements;
    private String view;
    private String userName;
    private String password;
    private LoginType loginType;
    private final By generalDescriptionSectionLocator =
            By.xpath("//h2[text()='General description']");
    private final By requirementsSectionLocator =
            By.xpath("//h2[text()='Requirements']");
    private final By responsibilitiesSectionLocator =
            By.xpath("//h2[text()='Responsibilities']");
    private final By whatWeOfferSectionLocator =
            By.xpath("//h2[text()='What we offer']");
    public final By nameLocator = By.xpath("//input[@name='your-name']");
    public final By emailLocator = By.xpath("//input[@name='your-email']");
    public final By mobileLocator = By.xpath("//input[@name='mobile-number']");
    public final By messageLocator = By.xpath("//textarea[@name='your-message']");
    public final By sendBtnLocator = By.xpath("//input[@type='submit']");
    public final By errorsOnFormLocator =
            By.xpath("//div[text()='One or more fields have an error. Please check and try again.']");
    public String errorMessageLocator = "//span[text()='message']";
    private Robot robot;

    public PageObject() throws AWTException {
        setFaker(new Faker());
        PageFactory.initElements(this.getDriver(), this);
        setWaitTime((Integer) Setup.getConfigProperties().getProperties().get(Property.TIMEOUT_IMPLICIT_VALUE));
        setWait(new WebDriverWait(this.getDriver(), getWaitTime()));
        setRobot(new Robot());
    }

    public boolean logoff(String[] logoffItems) {
        Setup.waitTime(3);
        try {
            for (String element : logoffItems)
                clickOnItem(By.xpath(element));
            return true;
        } catch (Exception e) {
            print(e.getMessage());
            return false;
        }
    }

    public void zoomInOrOut(boolean in, int times) {
        getRobot().keyPress(KeyEvent.VK_CONTROL);
        while (times > 0) {
            if (in)
                pressKey(KeyEvent.VK_ADD);
            else
                pressKey(KeyEvent.VK_MINUS);
            times--;
        }
        getRobot().keyRelease(KeyEvent.VK_CONTROL);
    }

    public void pressKey(int key) {
        getRobot().keyPress(key);
        getRobot().keyRelease(key);
    }

    public void waitForElementAndSet(By elementLocator) {
        getWait().until(ExpectedConditions.presenceOfElementLocated(elementLocator));
        setElement(getWebElement(elementLocator));
    }

    public boolean waitForElementsToCount(By elementLocator, int count) {
        getWait().until(ExpectedConditions.numberOfElementsToBe(elementLocator, count));
        return getWebElements(elementLocator).size() == count;
    }

    public void waitForElementVisibility(By elementLocator) {
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public  void waitForElementSize(By elementLocator) {
        getWait().until(ExpectedConditions.attributeToBeNotEmpty(
                getDriver().findElement(elementLocator),
                "height"
        ));
        getWait().until(ExpectedConditions.attributeToBeNotEmpty(
                getDriver().findElement(elementLocator),
                "width"
        ));
    }

    public void waitForElementsToBeClickable(By elementLocator) {
        getWait().until(ExpectedConditions.elementToBeClickable(elementLocator));
    }

    public void clickOnItem(By elementLocator) {
        waitForElementAndSet(elementLocator);
        waitForElementsToBeClickable(elementLocator);
        Setup.getActions().click(getElement()).build().perform();
    }

    public void clickOnItem(WebElement element) {
        try {
            Setup.getActions().click(element).build().perform();
        } catch (WebDriverException e) {
            // Work around for this by scrolling
            getDriver().manage().window().fullscreen();
            checkElementIsRendered(element);
            Setup.waitTime(5);
            clickOnItem(element);
        }
    }

    public void safetyNetClickOnItem(WebElement element) {
        try {
            Setup.getActions().click(element).build().perform();
        } catch (WebDriverException e) {
            getDriver().manage().window().fullscreen();
            checkElementIsRendered(element);
            Setup.waitTime(3);
            getDriver().get(getElement().getAttribute("href"));
        }
    }

    public void sendKeysToInput(Object key, By elementLocator) {
        try {
            waitForElementAndSet(elementLocator);
            Setup.getActions().moveToElement(getElement()).build().perform();

            if (key instanceof Keys)
                Setup.getActions().sendKeys(getElement(), (Keys) key).build().perform();
            else {
                getElement().clear();
                Setup.getActions().sendKeys(getElement(), (String) key).build().perform();
            }
        } catch (Exception e) {
            try {
                Setup.getActions().sendKeys(getUser_password()).build().perform();
                Setup.getActions().sendKeys(Keys.RETURN).build().perform();
                print(e.getMessage());
            } catch (Exception i) { print(i.getMessage()); }
        }
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAppPrefix() {
        return System.getProperties().getProperty((String) Setup.getConfigProperties().getProperties().
                get(Property.STR_APP_PREFIX));
    }

    public void setAppPrefix(String appPrefix) {
        System.setProperty((String) Setup.getConfigProperties().getProperties().get(Property.
                STR_APP_PREFIX), appPrefix);
    }

    public void print(Object string) {
        System.out.println(string);
    }

    void setFaker(Faker faker) {
        this.faker = faker;
    }

    public WebDriver getDriver() {
        return Setup.getDriver();
    }

    public void openURL(String app) {
        setUrlPath((String) Setup.getPropertyFromKey(Property.valueOf(app + "_URL")));
        Setup.openUrl(getUrlPath());
        print(getUrlPath());
        print(getFaker().number().randomNumber());
    }

    public WebElement getWebElement(By by) {
        return this.getDriver().findElement(by);
    }

    public List<WebElement> getWebElements(By by) {
        return this.getDriver().findElements(by);
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void setWait(WebDriverWait wait) {
        this.wait = wait;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public WebElement getElement() {
        return element;
    }

    public void setElement(WebElement element) {
        this.element = element;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public Faker getFaker() {
        return faker;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public List<WebElement> getElements() {
        return elements;
    }

    public void setElements(List<WebElement> elements) {
        this.elements = elements;
    }

    public boolean checkElementIsRendered (WebElement element) {
        return element.isDisplayed();
    }

    public boolean scrollDownToElementAndSet(By element, WebElement scrollReceiver) {
        while (!isPageReady()) {
            Setup.waitTime(5);
            print("Page still not loaded");
            scrollDownToElementAndSet(element, scrollReceiver);
        }

        print("Page now loaded");

        try {
            waitForElementAndSet(element);

            Setup.getJsExecutor().executeScript("scrollTo(0, " +
                    (getElement().getLocation().getY() - getDriver().manage().window().getSize().height / 2) + ");",
                    scrollReceiver);

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean scrollDownToElementNoOffsetAndSet(By element, WebElement scrollReceiver) {
        while (!isPageReady()) {
            Setup.waitTime(5);
            print("Page still not loaded");
            scrollDownToElementNoOffsetAndSet(element, scrollReceiver);
        }

        print("Page now loaded");

        try {
            waitForElementAndSet(element);

            print(getDriver().manage().window().getSize().height / 2);
            print(getElement().getLocation().getY());
            print(getElement().getLocation().getY() - getDriver().manage().window().getSize().height / 2);

            Setup.getJsExecutor().executeScript("scrollTo(0, " + getElement().getLocation().getY() + ");",
                    scrollReceiver);

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean isPageReady() {
        return Setup.getJsExecutor().executeScript("return document.readyState;").equals("complete");
    }

    public WebElement getGeneralDescriptionSection() {
        waitForElementAndSet(generalDescriptionSectionLocator);
        return getElement();
    }

    public WebElement getRequirementsSection() {
        waitForElementAndSet(requirementsSectionLocator);
        return getElement();
    }

    public WebElement getResponsibilitiesSection() {
        waitForElementAndSet(responsibilitiesSectionLocator);
        return getElement();
    }

    public WebElement getWhatWeOfferSection() {
        waitForElementAndSet(whatWeOfferSectionLocator);
        return getElement();
    }

    public void consoleLog(String message) {
        Setup.getJsExecutor().executeScript("console.log('" + message +"');");
    }

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }
}
