package example;

import com.zebrunner.agent.core.registrar.Artifact;
import com.zebrunner.agent.core.registrar.Screenshot;
import example.utils.FileUtils;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SessionSample {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

//    SAUCELABS
//    private static final String SELENIUM_URL = "https://oauth-dkazak-a97b0:2a9a119c-88ce-47c9-b512-8cb9e1d9b6eb@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

//  LAMBDATEST
//    private static final String username = "dkazak";
//    private static final String authkey = "lgwnpwCHRfGIAEbX8y1XNeMDAxcJVQN5vaMRliMpUm0rLZXu5h";
//    private static final String SELENIUM_URL = "https://" + username + ":" + authkey +"@hub.lambdatest.com/wd/hub";

//    BROWSERSTACK
//    private static final String USERNAME = "dmitrykazak_cwQHOV";
//    private static final String AUTOMATE_KEY = "azKEAczhu3tUPFVdmCfz";
//    private static final String SELENIUM_URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

//    TESTING BOT
    private static final String TESTING_BOT_SELENIUM_URL = "http://0994d4b523acb6f85961109513e8c38a:2b8aadff504ac09075375a97d66f80ae@hub.testingbot.com/wd/hub";

//    MCloud
//    private static final String SELENIUM_URL = "http://demo:demo@demo.zebrunner.farm/mcloud/wd/hub";

//    ESG
//    private static final String SELENIUM_URL = "https://dev:yEG37CX742zxOQnH@engine.zebrunner.org/wd/hub";

    //  FOR TESTING/DEBUGGING PROCESSES ONLY
    private static final String FAKE_SELENIUM_URL = "https://helloWorld.org";

    private final static String IMAGE_PATH = "src/test/resources/Circle-icons-computer.svg.png";

    public static RemoteWebDriver getDriver(String seleniumUrl, String sessionName) throws MalformedURLException {
        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        capabilities.setCapability("enableMetadata", true);
//        capabilities.setCapability("sessionName", sessionName);

//        capabilities.setCapability("name", "Login Form Example");
        capabilities.setCapability("build", "1.0");
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("version", "72");
        capabilities.setCapability("platform", "Windows 10");
//        capabilities.merge(chromeOptions);
//        Map<String, String> zebrunnerOptions = Map.of("enableLog", "true",
//                                                      "enableVideo", "false",
//                                                      "enableVNC", "true");
//
//        capabilities.setCapability("zebrunner:options", zebrunnerOptions);

        RemoteWebDriver driver = new RemoteWebDriver(new URL(seleniumUrl), capabilities);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        return driver;
    }

    @Test
    public void sessionTest() throws Exception {
        RemoteWebDriver fakeDriver = getDriver(FAKE_SELENIUM_URL,"Test Driver #2");
        this.doDriverWork(fakeDriver);
    }

    private void doDriverWork(RemoteWebDriver driver) throws IOException {
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
        } catch (Exception e) {
        }
    }

}
