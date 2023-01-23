package example.junit5;

import com.zebrunner.agent.core.registrar.Zephyr;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ZephyrSquadSample {

    @BeforeAll
    static void setUp() {
        Zephyr.setJiraProjectKey("QACO");
        Zephyr.setTestCycleKey("Zebrunner");
    }

    @Test
    void testSample() {
        Zephyr.setTestCaseKey("QACO-1");
        Zephyr.setTestCaseStatus("QACO-1", "BLOCKED");
    }

    @Test
    void testSample_2() {
        Zephyr.setTestCaseKey("QACO-2");
        throw new RuntimeException("Unexpected error is occurred");
    }

}
