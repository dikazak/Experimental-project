package example;

import com.zebrunner.agent.core.registrar.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class Zephyr {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final static String enableRealTimeSyncLabel = "sync.real-time";
    private final static String enableSyncLabel = "com.zebrunner.app/tcm.zephyr.sync.enabled";
    private final static String testCaseKeyLabel = "com.zebrunner.app/tcm.zephyr.test-case-key";
    private final static String testCycleKeyLabel = "com.zebrunner.app/tcm.zephyr.test-cycle-key";
    private static final String jiraProjectKeyLabel = "com.zebrunner.app/tcm.zephyr.jira-project-key";

    @Test
    public void testCreateUser() {
        LOGGER.info("testCreateUser logs");
        Label.attachToTestRun(enableRealTimeSyncLabel, "false");
        Label.attachToTest(enableSyncLabel, "false");

        //        ZEPHYR SQUAD LABELS
//        Label.attachToTest(testCaseKeyLabel, "DIM-2");
//        Label.attachToTestRun(testCycleKeyLabel, "TestCycle");

        //        ZEPHYR SCALE LABELS
//        Label.attachToTest(testCaseKeyLabel, "QAP-T5");
//        Label.attachToTestRun(testCycleKeyLabel, "QAP-R1");
//        Label.attachToTestRun(jiraProjectKeyLabel, "QAP");
    }

//    @Test
//    public void testCreateUserMissingSomeFields() {
//        LOGGER.info("testCreateUserMissingSomeFields logs");
//        Label.attachToTest(testCaseKey, "QAP-T2");
//        Label.attachToTestRun(testCycleKey, "QAP-R1");
//    }
//
//    @Test
//    public void testGetUsers() {
//        LOGGER.info("testGetUsers logs");
//        Label.attachToTest(testCaseKey, "QAP-T3");
//        Label.attachToTestRun(testCycleKey, "QAP-R1");
//    }
//
//    @Test
//    public void testDeleteUsers() {
//        LOGGER.info("testGetUsers logs");
//        Label.attachToTest(testCaseKey, "QAP-T4");
//        Label.attachToTestRun(testCycleKey, "QAP-R1");
//    }

}
