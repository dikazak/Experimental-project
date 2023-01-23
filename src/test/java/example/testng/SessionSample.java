package example.testng;

import com.zebrunner.agent.core.registrar.Artifact;
import com.zebrunner.agent.core.registrar.Screenshot;
import example.utils.FileUtils;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class SessionSample {


    private static final String SELENIUM_URL = "https://username:password@hub.<testing-platform>.com/wd/hub";

    private static final String IMAGE_PATH = "src/test/resources/Circle-icons-computer.png";

    private static final Map<String, String> COMMON_CAPABILITIES = Map.of();

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
    void sessionTest() throws Exception {
        RemoteWebDriver driver = getDriver();

        this.doDriverWork(driver);
    }

    private RemoteWebDriver getDriver() throws MalformedURLException {
        URL url = new URL(SELENIUM_URL);
        MutableCapabilities capabilities = new MutableCapabilities();

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
        } catch (Exception ignored) {
        }
    }

    @AfterTest
    public void finish() {
        this.driver.quit();
    }

}
