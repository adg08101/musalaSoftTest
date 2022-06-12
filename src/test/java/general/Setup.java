package general;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;

public final class Setup {
    private static WebDriver driver;
    private static HashMap<String, Object> store;
    private static ChromeOptions options;
    private static FirefoxOptions firefoxOptions;
    private static Actions actions;
    private static ConfigProperties configProperties;
    private static WaitingObject waitingObject;
    private static JavascriptExecutor jsExecutor;
    private static Map<String, Object> timeouts;
    private static InputStream input;
    private static Properties properties;

    public static FirefoxOptions getFirefoxOptions() {
        return firefoxOptions;
    }

    public static void setFirefoxOptions(FirefoxOptions firefoxOptions) {
        Setup.firefoxOptions = firefoxOptions;
    }

    @Before
    public void InitSetup() {
        try {
            setConfigProperties(new ConfigProperties());

            initObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initObject() {
        setStore(new HashMap<>());
        loadDefaultProperties();

        String browser = (String) Setup.getPropertyFromKey(Property.BROWSER);

        switch (browser.toLowerCase(Locale.ROOT)) {
            case "chrome":
                applyChromeConfigurations();
                break;
            case "firefox":
                applyFirefoxConfigurations();
                break;
            default:
                System.out.println("Please check browser config");
                break;
        }

        waitingObject = new WaitingObject(getDriver());
        setActions(new Actions(getDriver()));
        setJsExecutor((JavascriptExecutor) getDriver());
        getJsExecutor().executeScript("console.log('System online.')");
        getDriver().manage().window().maximize();
    }

    private void loadDefaultProperties() {
        setInput(Setup.class.getResourceAsStream((String) getConfigProperties().
                getProperties().get(Property.DEFAULT_PROPERTIES_FILE_PATH)));

        setProperties(new Properties());

        try {
            getProperties().load(getInput());
        } catch (java.io.IOException ignored) { }

        setKeyValueStore((String) getConfigProperties().getProperties().get(
                Property.STRING_DEFAULT_PROPERTIES), getProperties());
    }

    private void applyChromeConfigurations() {
        System.setProperty((String) getConfigProperties().getProperties().get(Property.WEBDRIVER_CHROME_DRIVER),
                System.getenv((String) getConfigProperties().getProperties().get(Property.CHROME_DRIVER)));
        System.setProperty((String) getConfigProperties().getProperties().get(Property.
                WEBDRIVER_CHROME_SILENTOUTPUT), (String) getConfigProperties().getProperties().
                get(Property.STRING_TRUE));
        setOptions(new ChromeOptions());
        setTimeouts(new HashMap<>());
        getTimeouts().put((String) getConfigProperties().getProperties().get(Property.TIMEOUT_IMPLICIT_KEY),
                getConfigProperties().getProperties().get(Property.TIMEOUT_IMPLICIT_VALUE));
        getTimeouts().put((String) getConfigProperties().getProperties().get(Property.TIMEOUT_PAGELOAD_KEY),
                getConfigProperties().getProperties().get(Property.TIMEOUT_PAGELOAD_VALUE));
        getTimeouts().put((String) getConfigProperties().getProperties().get(Property.TIMEOUT_SCRIPT_KEY),
                getConfigProperties().getProperties().get(Property.TIMEOUT_SCRIPT_VALUE));
        getOptions().setCapability((String) getConfigProperties().getProperties().get(Property.STRING_TIMEOUTS),
                getTimeouts());
        getOptions().addArguments("enable-automation");
        // getOptions().addArguments("--headless");
        // getOptions().addArguments("--window-size=1920,1080");
        getOptions().addArguments("--no-sandbox");
        getOptions().addArguments("--disable-extensions");
        getOptions().addArguments("--dns-prefetch-disable");
        getOptions().addArguments("--disable-gpu");
        getOptions().addArguments("--start-maximized");
        getOptions().setPageLoadStrategy(PageLoadStrategy.NONE);
        setDriver(new ChromeDriver(getOptions()));
    }

    private void applyFirefoxConfigurations() {
        System.setProperty("webdriver.gecko.driver",
                System.getenv((String) getConfigProperties().getProperties().get(Property.FIREFOX_DRIVER)));
        System.setProperty((String) getConfigProperties().getProperties().get(Property.
                WEBDRIVER_CHROME_SILENTOUTPUT), (String) getConfigProperties().getProperties().
                get(Property.STRING_TRUE));
        setFirefoxOptions(new FirefoxOptions());
        setTimeouts(new HashMap<>());
        getTimeouts().put((String) getConfigProperties().getProperties().get(Property.TIMEOUT_IMPLICIT_KEY),
                getConfigProperties().getProperties().get(Property.TIMEOUT_IMPLICIT_VALUE));
        getTimeouts().put((String) getConfigProperties().getProperties().get(Property.TIMEOUT_PAGELOAD_KEY),
                getConfigProperties().getProperties().get(Property.TIMEOUT_PAGELOAD_VALUE));
        getTimeouts().put((String) getConfigProperties().getProperties().get(Property.TIMEOUT_SCRIPT_KEY),
                getConfigProperties().getProperties().get(Property.TIMEOUT_SCRIPT_VALUE));
        getFirefoxOptions().setCapability((String) getConfigProperties().getProperties().get(Property.STRING_TIMEOUTS),
                getTimeouts());
        getFirefoxOptions().setPageLoadStrategy(PageLoadStrategy.NONE);
        getFirefoxOptions().setLogLevel(Level.OFF);
        getFirefoxOptions().addArguments("--start-maximized");
        setDriver(new FirefoxDriver(getFirefoxOptions()));
        // getDriver().manage().deleteAllCookies();
    }

    public static Actions getActions() {
        return actions;
    }

    public static void setActions(Actions actions) {
        Setup.actions = actions;
    }

    public static void setStore(HashMap<String, Object> store) {
        Setup.store = store;
    }

    public static InputStream getInput() {
        return input;
    }

    public static void setInput(InputStream input) {
        Setup.input = input;
    }

    public static Properties getProperties() {
        return properties;
    }

    public static void setProperties(Properties properties) {
        Setup.properties = properties;
    }

    public static ChromeOptions getOptions() {
        return options;
    }

    public static void setOptions(ChromeOptions options) {
        Setup.options = options;
    }

    public static void setTimeouts(Map<String, Object> timeouts) {
        Setup.timeouts = timeouts;
    }

    public static void setDriver(WebDriver driver) {
        Setup.driver = driver;
    }

    public static Map<String, Object> getTimeouts() {
        return timeouts;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WaitingObject getWait() {
        return waitingObject;
    }

    public static HashMap<String, Object> getStore() {
        return store;
    }

    public static void setKeyValueStore(String key, Object value) {
        getStore().put(key, value);
    }

    public static void openUrl(String url) {
        getDriver().get(url);
    }

    public static void setJsExecutor(JavascriptExecutor jsExecutor) {
        Setup.jsExecutor = jsExecutor;
    }

    public static JavascriptExecutor getJsExecutor() {
        return jsExecutor;
    }

    public static ConfigProperties getConfigProperties() {
        return configProperties;
    }

    public static void setConfigProperties(ConfigProperties configProperties) {
        Setup.configProperties = configProperties;
    }

    public static Object getPropertyFromKey(Property key) {
        return getProperties().getProperty((String) Setup.getConfigProperties().getProperties().
                get(key));
    }

    public static void waitTime(int factor) {
        getWait().thread((Long) getConfigProperties().getProperties().get(
                Property.INT_SHORT_TIME) * factor);
    }

    @After
    public void close() {
        waitTime(50);
        getDriver().close();
    }
}
