package example;

import com.zebrunner.agent.core.registrar.Artifact;
import com.zebrunner.agent.core.registrar.Screenshot;
import example.utils.FileUtils;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SessionSample {

    private final static String SELENIUM_URL = "http://0994d4b523acb6f85961109513e8c38a:2b8aadff504ac09075375a97d66f80ae@hub.testingbot.com/wd/hub";

    private final static String IMAGE_PATH = "src/test/resources/Circle-icons-computer.svg.png";

    public static RemoteWebDriver getDriver(String sessionName) throws MalformedURLException {
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setCapability("enableVNC", true);
//        chromeOptions.setCapability("enableVideo", true);
//        chromeOptions.setCapability("enableMetadata", true);
//        chromeOptions.setCapability("enableLog", true);
//        chromeOptions.setCapability("sessionName", sessionName);

        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("provider", "mcloud");
//        capabilities.setCapability("enableVNC", true);
//        capabilities.setCapability("enableVideo", true);
//        capabilities.setCapability("enableMetadata", true);
        capabilities.setCapability("sessionName", sessionName);
        capabilities.setCapability("fallbackSessionId", "769d5672-8839-4708-8cd6-1519afd4bacc");
//        capabilities.merge(chromeOptions);
        Map<String, String> zebrunnerOptions = Map.of("enableLog", "true",
                                                      "enableVideo", "false",
                                                      "enableVNC", "true");

        capabilities.setCapability("zebrunner:options", zebrunnerOptions);

        RemoteWebDriver driver = new RemoteWebDriver(new URL(SELENIUM_URL), capabilities);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        return driver;
    }

    @Test
    public void sessionTest() throws Exception {
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
