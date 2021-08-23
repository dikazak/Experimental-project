package example;

import com.zebrunner.agent.core.registrar.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class Zephyr {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final static String testCaseKey = "com.zebrunner.app/tcm.zephyr.test-case-key";
    private final static String testCycleKey = "com.zebrunner.app/tcm.zephyr.test-cycle-key";

    @Test
    public void testCreateUser() {
        LOGGER.info("testCreateUser logs");
        Label.attachToTest(testCaseKey, "QAP-T1");
        Label.attachToTestRun(testCycleKey, "QAP-R1");
        throw new RuntimeException();
    }

    @Test
    public void testCreateUserMissingSomeFields() {
        LOGGER.info("testCreateUserMissingSomeFields logs");
        Label.attachToTest(testCaseKey, "QAP-T2");
        Label.attachToTestRun(testCycleKey, "QAP-R1");
    }

    @Test
    public void testGetUsers() {
        LOGGER.info("testGetUsers logs");
        Label.attachToTest(testCaseKey, "QAP-T3");
        Label.attachToTestRun(testCycleKey, "QAP-R1");
    }

    @Test
    public void testDeleteUsers() {
        LOGGER.info("testGetUsers logs");
        Label.attachToTest(testCaseKey, "QAP-T4");
        Label.attachToTestRun(testCycleKey, "QAP-R1");
    }

}
