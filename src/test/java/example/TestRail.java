package example;

import com.zebrunner.agent.core.registrar.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class TestRail {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final static String enableRealTimeSyncLabel = "sync.real-time";
    private static final String enableSyncLabel = "com.zebrunner.app/tcm.testrail.sync.enabled";

    private static final String includeAllCasesLabel = "com.zebrunner.app/tcm.testrail.include-all-cases";
    private static final String suiteIdLabel = "com.zebrunner.app/tcm.testrail.suite-id";
    private static final String caseIdLabel = "com.zebrunner.app/tcm.testrail.case-id";

    @Test
    public void testCreateUser() {
        LOGGER.info("testCreateUser logs");
        Label.attachToTest(enableSyncLabel, "false");
        Label.attachToTestRun(enableRealTimeSyncLabel, "false");

        Label.attachToTest(caseIdLabel, "1");
        Label.attachToTestRun(suiteIdLabel, "1");
        Label.attachToTestRun(includeAllCasesLabel, "true");
        throw new RuntimeException();
    }

}
