package example;

import com.zebrunner.agent.core.registrar.Artifact;
import com.zebrunner.agent.core.registrar.Screenshot;
import example.utils.FileUtils;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class SessionSample {

    private static final Logger log = LoggerFactory.getLogger(SessionSample.class);

    private static final String SELENIUM_URL = "https://dkazak322:mgPmd2LYthWBBiZbmp5XU1Qm9iVSjg2tv845WOcmR4L4TJRtmh@hub.lambdatest.com/wd/hub";

    private static final String IMAGE_PATH = "src/test/resources/Circle-icons-computer.svg.png";

    private RemoteWebDriver driver;

    private static final Map<String, String> COMMON_CAPABILITIES = Map.of(
            "platformName", "MacOS Big sur",
            "browserName", "chrome",
            "browserVersion", "107.0"
    );

    // bs:options
    private static final Map<String, String> BROWSERSTACK_OPTIONS = Map.of(
            "os", "OS X",
            "osVersion", "Big Sur"
    );

    // lt:options
    private static final Map<String, String> LAMBDATEST_OPTIONS = Map.of(

    );

    // sauce:options
    private static final Map<String, String> SAUCELABS_OPTIONS = Map.of();

    // tb:options
    private static final Map<String, String> TESTING_BOT_OPTIONS = Map.of();

    @BeforeMethod
    void beforeMethod() {
        log.info("Before method");
    }

    @Test
    void sessionTest() throws Exception {
        String zebrunnerCapabilities = System.getenv("ZEBRUNNER_CAPABILITIES");
        log.info("zebrunnerCapabilities: {}", zebrunnerCapabilities);

        RemoteWebDriver driver = getDriver(SELENIUM_URL);
        this.doDriverWork(driver);
    }

    private RemoteWebDriver getDriver(String seleniumUrl) throws MalformedURLException {
        MutableCapabilities capabilities = new MutableCapabilities();
//        COMMON_CAPABILITIES.forEach(capabilities::setCapability);

//        capabilities.setCapability("bstack:options", BROWSERSTACK_OPTIONS);

        this.driver = new RemoteWebDriver(new URL(seleniumUrl), capabilities);

        this.driver.manage().window().maximize();
        this.driver.manage().deleteAllCookies();

        return driver;
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
