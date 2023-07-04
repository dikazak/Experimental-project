package example.junit4;

import com.zebrunner.agent.core.registrar.Artifact;
import com.zebrunner.agent.core.registrar.Screenshot;
import example.utils.FileUtils;
import org.junit.Test;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class SessionSample {

    private static final Logger log = LoggerFactory.getLogger(SessionSample.class);

//    private static final String SELENIUM_URL = "https://dkazaktest:FsvKisRFwOl1@engine.zebrunner.dev/wd/hub";
    private static final String SELENIUM_URL = "https://zebrunnerdevelop_3mS9Wv:HpXc3y5GqSvxdx9jFBot@hub-cloud.browserstack.com/wd/hub";

    private static final String IMAGE_PATH = "src/test/resources/Circle-icons-computer.png";

    private static final Map<String, Object> COMMON_CAPABILITIES = Map.of(
            "enableLog", true,
            "enableVideo", true,
            "enableVNC", true
//            "provider", "BROWSERSTACK"
    );

    // bs:options
    private static final Map<String, String> BROWSERSTACK_OPTIONS = Map.of();

    // lt:options
    private static final Map<String, String> LAMBDATEST_OPTIONS = Map.of();

    // sauce:options
    private static final Map<String, String> SAUCELABS_OPTIONS = Map.of();

    // tb:options
    private static final Map<String, String> TESTING_BOT_OPTIONS = Map.of();

    private RemoteWebDriver driver;

    @Test
    public void sessionTest() throws Exception {
        RemoteWebDriver driver = getDriver();

        this.doDriverWork(driver);

        driver.quit();
    }

    private RemoteWebDriver getDriver() throws MalformedURLException {
        URL url = new URL(SELENIUM_URL);
        MutableCapabilities capabilities = new MutableCapabilities();

        COMMON_CAPABILITIES.forEach(capabilities::setCapability);

        return new RemoteWebDriver(url, capabilities);
    }

    private void doDriverWork(RemoteWebDriver driver) {
        try {
            driver.get("https://www.google.com");
            Actions actions = new Actions(driver);

            Screenshot.upload(FileUtils.fromFile(IMAGE_PATH), System.currentTimeMillis());

            Artifact.attachToTest("testImage", FileUtils.fromFile(IMAGE_PATH));
            Artifact.attachToTestRun("testRunImage", FileUtils.fromFile(IMAGE_PATH));

            int i = 0;
            while (i < 10) {
                actions.moveByOffset(100, 100);
                actions.moveByOffset(200, 100);
                actions.moveByOffset(200, 200);
                actions.moveByOffset(100, 200);
                actions.moveByOffset(100, 100);
                i++;
            }
            Thread.sleep(20 * 1000);
        } catch (Exception ignored) {
        }
    }

}
