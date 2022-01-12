package example;

import com.zebrunner.agent.core.registrar.CurrentTestRun;
import com.zebrunner.agent.core.registrar.Label;
import com.zebrunner.agent.core.registrar.TestRail;
import com.zebrunner.agent.core.registrar.Xray;
import com.zebrunner.agent.core.registrar.Zephyr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class TestRailZephyrXraySample {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @BeforeSuite
    public void setup() {
        TestRail.includeAllTestCasesInNewRun();
        TestRail.setRunId("1");
        TestRail.setAssignee("Dima");
        TestRail.setRunName("TestRun");
        TestRail.setMilestone("Milestone");

        Zephyr.setTestCycleKey("DIM-1");
        Zephyr.setJiraProjectKey("DIM");

        Xray.setExecutionKey("QAP-2");
    }

    @Test
    public void awesomeTestMethod() {
        LOGGER.info("testCreateUser logs");
        //        TESTRAIL
        TestRail.setCaseId("1");

        CurrentTestRun.setPlatform("Hello, World");

        Label.attachToTest("simpleLabel1", "simpleLabel1");
        Label.attachToTest("simpleLabel2", "simpleLabel2");

        //        ZEPHYR SQUAD LABELS
        Zephyr.setTestCaseKey("DIM-2");

        //        ZEPHYR SCALE LABELS
        Zephyr.setTestCaseKey("QAP-T1");
        Zephyr.setTestCaseKey("QAP-T2");
        Zephyr.setTestCaseKey("QAP-T3");
        Zephyr.setTestCaseKey("QAP-T4");

        //        XRAY
        Xray.setTestKey("QAP-3");
        throw new RuntimeException();
    }

}
