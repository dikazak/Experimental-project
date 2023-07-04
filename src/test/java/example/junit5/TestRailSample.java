package example.junit5;

import com.zebrunner.agent.core.annotation.TestRailCaseId;
import com.zebrunner.agent.core.registrar.TestRail;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestRailSample {

    @BeforeAll
    static void setUp() {
        TestRail.setSuiteId("321");
        TestRail.setRunName("Best run ever");
        TestRail.setAssignee("Deve Loper");
    }

    @Test
    @TestRailCaseId("10000")
    @TestRailCaseId({"10001", "10002"})
    void awesomeTest1() {
        TestRail.setTestCaseStatus("10001", TestRail.SystemTestCaseStatus.PASSED);
        // some code here
    }

    @Test
    void awesomeTest2() {
        // some code here
        TestRail.setTestCaseId("20000");
        // meaningful assertions
    }

}
