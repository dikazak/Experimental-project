package example.testng;

import com.zebrunner.agent.core.annotation.TestRailCaseId;
import com.zebrunner.agent.core.registrar.TestRail;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestRailSample {

    @BeforeClass
    static void setUp() {
        TestRail.setRunId("711");
        TestRail.enableRealTimeSync();
    }

    @Test
    void testSample() {
        TestRail.setTestCaseId("3551");
    }

    @Test
    @TestRailCaseId("3552")
    void testSample2() {
        throw new RuntimeException("Unexpected error is occurred");
    }

}
