package example;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestingBotTest {

    public static final String KEY = "0994d4b523acb6f85961109513e8c38a";
    public static final String SECRET = "2b8aadff504ac09075375a97d66f80ae";
    private final static String SELENIUM_URL = String.format("http://%s:%s@hub.testingbot.com/wd/hub", KEY, SECRET);

    public RemoteWebDriver getDriver(String sessionName) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platform", "CATALINA");
        capabilities.setCapability("version", 95);
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("sessionName", sessionName);

        RemoteWebDriver driver = new RemoteWebDriver(new URL(SELENIUM_URL), capabilities);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    @Test
    public void awesomeMethod() throws MalformedURLException {
        RemoteWebDriver driver = getDriver("Testing bot session");
        driver.get("https://www.google.com");
        Actions actions = new Actions(driver);

        int i = 0;
        while (i < 10) {
            actions.moveByOffset(100, 100);
            actions.moveByOffset(200, 100);
            actions.moveByOffset(200, 200);
            actions.moveByOffset(100, 200);
            actions.moveByOffset(100, 100);
            i++;
        }
    }

}
