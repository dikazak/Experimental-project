package example;

import com.zebrunner.agent.core.registrar.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class XrayTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final static String enableRealTimeSyncLabel = "sync.real-time";
    private final static String enableSyncLabel = "com.zebrunner.app/tcm.zephyr.sync.enabled";

    private final static String testKeyLabel = "com.zebrunner.app/tcm.xray.test-key";
    private final static String testExecutionKeyLabel = "com.zebrunner.app/tcm.xray.test-execution-key";

    @Test
    public void testCreateUser() {
        LOGGER.info("testCreateUser logs");
        Label.attachToTestRun(enableRealTimeSyncLabel, "false");
        Label.attachToTest(enableSyncLabel, "false");

        Label.attachToTest(testKeyLabel, "QAP-2");
        Label.attachToTestRun(testExecutionKeyLabel, "QAP-10");
    }

    @Test
    public void testCreateUserMissingSomeFields() {
        LOGGER.info("testCreateUserMissingSomeFields logs");
        Label.attachToTestRun(enableRealTimeSyncLabel, "false");
        Label.attachToTest(enableSyncLabel, "false");

        Label.attachToTest(testKeyLabel, "QAP-3");
        Label.attachToTestRun(testExecutionKeyLabel, "QAP-10");
    }

    @Test
    public void testGetUsers() {
        LOGGER.info("testGetUsers logs");
        Label.attachToTestRun(enableRealTimeSyncLabel, "false");
        Label.attachToTest(enableSyncLabel, "false");

        Label.attachToTest(testKeyLabel, "QAP-4");
        Label.attachToTestRun(testExecutionKeyLabel, "QAP-10");
    }

    @Test
    public void testDeleteUsers() {
        LOGGER.info("testGetUsers logs");
        Label.attachToTestRun(enableRealTimeSyncLabel, "false");
        Label.attachToTest(enableSyncLabel, "false");

        Label.attachToTest(testKeyLabel, "QAP-5");
        Label.attachToTestRun(testExecutionKeyLabel, "QAP-10");
    }

}
