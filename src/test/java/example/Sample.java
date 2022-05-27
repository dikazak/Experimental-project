package example;

import com.zebrunner.agent.core.registrar.TestRail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sample {

    private static final Logger log = LoggerFactory.getLogger("Sample");

    private static final String artifactsPrefix = "/artifacts";

    @BeforeSuite
    public void setup() {
        log.info("");
//        TestRail.setRunId("1");
//        TestRail.setRunId("7");
//        Zephyr.setJiraProjectKey("QA");
//        Zephyr.setTestCycleKey("QA-R1");
//        Xray.setExecutionKey("QA-2");
    }

    @Test
    public void test() {
//        Random generator = new Random(1);
//        for (int i = 0; i < 100; i++) {
//            String randomName = RandomString.make(1 + generator.nextInt(254));
//            String randomRef = RandomString.make(1 + generator.nextInt(254));
//            Artifact.attachReferenceToTestRun(randomName, artifactsPrefix + randomRef);
//        }
    }

    @Test
    public void failedTest() {
        String stacktrace = "org.openqa.selenium.WebDriverException: org.openqa.selenium.WebDriverException: An unknown server-side error occurred while processing the command. Original error: Cannot start the 'com.solvd.carinademoapplication' application. Visit https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/android/activity-startup.md for troubleshooting. Original error: Error executing adbExec. Original error: 'Command '/root/platform-tools/adb -P 5037 -s NE1GAM47A3105862 shell am start -W -n com.solvd.carinademoapplication/com.solvd.carinademoapplication.ActivitySplash -S -a android.intent.action.MAIN -c android.intent.category.LAUNCHER -f 0x10200000' timed out after 20000ms'. Try to increase the 20000ms adb execution timeout represented by 'adbExecTimeout' capability[[[--udid NE1GAM47A3105862 --name Nokia_3 --sessionId 5796436c-618a-4c89-8ecf-ede4dfb50bba]]]";
        throw new RuntimeException(stacktrace);
    }

    @Test
    public void inProgressTest() {

    }

    @Test
    public void queuedTest() {

    }

    @Test
    public void skippedTest() {

    }

    @Test
    public void abortedTest() {

    }

    @Test
    public void knownIssueTest() {

    }

}
