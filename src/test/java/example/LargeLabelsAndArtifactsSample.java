package example;

import com.zebrunner.agent.core.registrar.Artifact;
import com.zebrunner.agent.core.registrar.Label;
import net.bytebuddy.utility.RandomString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LargeLabelsAndArtifactsSample {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static final String artifactsPrefix = "/artifacts";

    private static final Map<String,String> xrayLabelToValue = new HashMap<>();
    private static final Map<String,String> zephyrLabelToValue = new HashMap<>();
    private static final Map<String,String> testRailLabelToValue = new HashMap<>();

    @BeforeSuite
    public static void setup() {
        testRailLabelToValue.put("com.zebrunner.app/tcm.testrail.sync.enabled", "true");
        testRailLabelToValue.put("com.zebrunner.app/tcm.testrail.include-all-cases", "true");
        testRailLabelToValue.put("com.zebrunner.app/tcm.testrail.project-id", "1");
        testRailLabelToValue.put("com.zebrunner.app/tcm.testrail.suite-id", "1");
        testRailLabelToValue.put("com.zebrunner.app/tcm.testrail.run-id", "1");
        testRailLabelToValue.put("com.zebrunner.app/tcm.testrail.run-name", "Test");
        testRailLabelToValue.put("com.zebrunner.app/tcm.testrail.milestone", "1");
        testRailLabelToValue.put("com.zebrunner.app/tcm.testrail.assignee", "Dima");
        testRailLabelToValue.put("com.zebrunner.app/tcm.testrail.case-id", "1");

        xrayLabelToValue.put("com.zebrunner.app/tcm.xray.sync.enabled", "true");
        xrayLabelToValue.put("com.zebrunner.app/tcm.xray.test-execution-key", "TEST");
        xrayLabelToValue.put("com.zebrunner.app/tcm.xray.test-key", "TEST");

        zephyrLabelToValue.put("com.zebrunner.app/tcm.zephyr.sync.enabled", "true");
        zephyrLabelToValue.put("com.zebrunner.app/tcm.zephyr.test-cycle-key", "TEST");
        zephyrLabelToValue.put("com.zebrunner.app/tcm.zephyr.jira-project-key", "TPR");
        zephyrLabelToValue.put("com.zebrunner.app/tcm.zephyr.test-case-key", "TC");
    }

    @Test
    public void testCreateUser() {
        xrayLabelToValue.forEach(Label::attachToTest);
        zephyrLabelToValue.forEach(Label::attachToTest);
        testRailLabelToValue.forEach(Label::attachToTest);

        Random generator = new Random(1);
        for (int i = 0; i < 500; i++) {
            Label.attachToTestRun(RandomString.make(1 + generator.nextInt(254)), RandomString.make(1 + generator.nextInt(254)));
//            Label.attachToTest(RandomString.make(1 + generator.nextInt(254)), RandomString.make(1 + generator.nextInt(254)));
//            Artifact.attachReferenceToTest(1 + RandomString.make(generator.nextInt(255)), 1 + RandomString.make(generator.nextInt(255)));
        }

        for (int i = 0; i < 100; i++) {
            String randomName = RandomString.make(1 + generator.nextInt(254));
            String randomRef = RandomString.make(1 + generator.nextInt(254));
            Artifact.attachReferenceToTestRun(randomName, artifactsPrefix + randomRef);
        }

        for (int i = 0; i < 100; i++) {
            String randomName = RandomString.make(1 + generator.nextInt(254));
            String randomRef = RandomString.make(1 + generator.nextInt(254));
            Artifact.attachReferenceToTestRun(randomName, randomRef);
        }
    }

}
