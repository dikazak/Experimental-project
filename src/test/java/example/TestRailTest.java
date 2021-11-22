package example;

import com.zebrunner.agent.core.registrar.Label;
import com.zebrunner.agent.core.registrar.TestRail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class TestRailTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final static String enableRealTimeSyncLabel = "sync.real-time";
    private static final String enableSyncLabel = "com.zebrunner.app/tcm.testrail.sync.enabled";

    private static final String runIdLabel = "com.zebrunner.app/tcm.testrail.run-id";
    private static final String includeAllCasesLabel = "com.zebrunner.app/tcm.testrail.include-all-cases";
    private static final String suiteIdLabel = "com.zebrunner.app/tcm.testrail.suite-id";
    private static final String caseIdLabel = "com.zebrunner.app/tcm.testrail.case-id";

    @BeforeSuite
    public void setup() {
        TestRail.setRunId("1");
    }

    @Test
    public void testCreateUser() {
        TestRail.setCaseId("1");
        // meaningful assertions
    }

    @Test
    public void failedTest() {
        Label.attachToTest("LabelKey1", "LabelValue1");
        Label.attachToTest("LabelKey2", "LabelValue2");
        TestRail.setCaseId("1");
        // meaningful assertions
        String nullString = null;
        nullString.toString();
    }

}
