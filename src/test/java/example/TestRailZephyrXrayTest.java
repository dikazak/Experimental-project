package example;

import com.zebrunner.agent.core.registrar.CurrentTestRun;
import com.zebrunner.agent.core.registrar.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class TestRailZephyrXrayTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final static String enableRealTimeSyncLabel = "sync.real-time";
    private final static String enableSyncLabel = "com.zebrunner.app/tcm.zephyr.sync.enabled";

    // XRAY
    private final static String testKeyLabel = "com.zebrunner.app/tcm.xray.test-key";
    private final static String testExecutionKeyLabel = "com.zebrunner.app/tcm.xray.test-execution-key";

    // ZEPHYR
    private final static String testCaseKeyLabel = "com.zebrunner.app/tcm.zephyr.test-case-key";
    private final static String testCycleKeyLabel = "com.zebrunner.app/tcm.zephyr.test-cycle-key";
    private static final String jiraProjectKeyLabel = "com.zebrunner.app/tcm.zephyr.jira-project-key";

    // TESTRAIL
    private static final String includeAllCasesLabel = "com.zebrunner.app/tcm.testrail.include-all-cases";
    private static final String suiteIdLabel = "com.zebrunner.app/tcm.testrail.suite-id";
    private static final String caseIdLabel = "com.zebrunner.app/tcm.testrail.case-id";

//    @Test
//    public void testLogin() {
//        //        ZEPHYR SCALE LABELS
//        Label.attachToTest(testCaseKeyLabel, "QAP-T1");
//        Label.attachToTestRun(testCycleKeyLabel, "QAP-R1");
//        Label.attachToTestRun(jiraProjectKeyLabel, "QAP");
//        throw new RuntimeException();
//    }

    @Test
    public void awesomeTestMethod() {
        LOGGER.info("testCreateUser logs");
//        Label.attachToTestRun(enableRealTimeSyncLabel, "false");
//        Label.attachToTest(enableSyncLabel, "false");

        CurrentTestRun.setPlatform("Hello, World");
        //        TESTRAIL
        Label.attachToTest(caseIdLabel, "2");
        Label.attachToTestRun(suiteIdLabel, "1");
        Label.attachToTestRun(includeAllCasesLabel, "false");

        //        ZEPHYR SQUAD LABELS
//        Label.attachToTest(testCaseKeyLabel, "DIM-2");
//        Label.attachToTestRun(testCycleKeyLabel, "TestCycle");

        //        ZEPHYR SCALE LABELS
        Label.attachToTest(testCaseKeyLabel, "QAP-T1");
        Label.attachToTestRun(testCycleKeyLabel, "QAP-R1");
        Label.attachToTestRun(jiraProjectKeyLabel, "QAP");

        //        XRAY
        Label.attachToTest(testKeyLabel, "QAP-3");
        Label.attachToTestRun(testExecutionKeyLabel, "QAP-10");
        throw new RuntimeException();
    }

    @Test
    public void awesomeTest2() {
    }

    @Test
    public void awesomeTest3() {
    }

//    @Test
//    public void testCreateUser2() {
//        LOGGER.info("testCreateUser logs");
//        Label.attachToTestRun(enableRealTimeSyncLabel, "false");
//        Label.attachToTest(enableSyncLabel, "false");
//
//        //        TESTRAIL
//        Label.attachToTest(caseIdLabel, "2");
//        Label.attachToTestRun(suiteIdLabel, "1");
//        Label.attachToTestRun(includeAllCasesLabel, "true");
//
//        //        ZEPHYR SQUAD LABELS
////        Label.attachToTest(testCaseKeyLabel, "DIM-2");
////        Label.attachToTestRun(testCycleKeyLabel, "TestCycle");
//
//        //        ZEPHYR SCALE LABELS
//        Label.attachToTest(testCaseKeyLabel, "QAP-T2");
//        Label.attachToTestRun(testCycleKeyLabel, "QAP-R1");
//        Label.attachToTestRun(jiraProjectKeyLabel, "QAP");
//
//        //        XRAY
//        Label.attachToTest(testKeyLabel, "QAP-3");
//        Label.attachToTestRun(testExecutionKeyLabel, "QAP-10");
//        throw new RuntimeException();
//    }

}
