package example;

import com.zebrunner.agent.core.annotation.Priority;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MultipleSessionsSample {

    private final static String SELENIUM_URL = "https://edovnar:Up23PW80wAJ8aMLI@engine.zebrunner.dev/wd/hub";

    public static RemoteWebDriver getDriver(String sessionName) throws MalformedURLException {
        ChromeOptions capabilities = new ChromeOptions();
        capabilities.addArguments("['start-maximized']");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        capabilities.setCapability("enableMetadata", true);
        capabilities.setCapability("enableLog", true);
        capabilities.setCapability("sessionName", sessionName);

        RemoteWebDriver driver = new RemoteWebDriver(new URL(SELENIUM_URL), capabilities);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        return driver;
    }

    @Test
    public void multipleSessionsTest() throws Exception {
        List<RemoteWebDriver> drivers = List.of(
                getDriver("Test Driver #1"),
                getDriver("Test Driver #2"),
                getDriver("Test Driver #3")
        );

        drivers.parallelStream()
               .forEach(driver -> {
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
               });

        drivers.forEach(RemoteWebDriver::quit);
    }

}
