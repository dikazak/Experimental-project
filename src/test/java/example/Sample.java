package example;

import com.zebrunner.agent.core.registrar.Artifact;
import com.zebrunner.agent.core.registrar.Screenshot;
import com.zebrunner.agent.core.registrar.TestRail;
import com.zebrunner.agent.core.registrar.Xray;
import com.zebrunner.agent.core.registrar.Zephyr;
import example.utils.FileUtils;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Sample {

    private final static String SELENIUM_URL = "http://0994d4b523acb6f85961109513e8c38a:2b8aadff504ac09075375a97d66f80ae@hub.testingbot.com/wd/hub";

    private final static String IMAGE_PATH = "src/test/resources/Circle-icons-computer.svg.png";

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

    @BeforeSuite
    public void setup() {
        TestRail.setRunId("7");
        Zephyr.setJiraProjectKey("QA");
        Zephyr.setTestCycleKey("QA-R1");
        Xray.setExecutionKey("QA-2");
    }

    @Test
    public void sessionTest() throws Exception {
        TestRail.setCaseId("3");
        Xray.setTestKey("QA-1");
        Zephyr.setTestCaseKey("QA-T1");

        RemoteWebDriver driver = getDriver("Test Driver #1");
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
        } finally {
            driver.quit();
        }
    }

}
