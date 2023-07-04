package example.junit5;

import com.zebrunner.agent.core.registrar.Zephyr;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ZephyrScaleSample {

    @BeforeAll
    static void setUp() {
        Zephyr.setJiraProjectKey("QT");
        Zephyr.setTestCycleKey("QT-R4");
    }

    @Test
    void testSample() {
        Zephyr.setTestCaseKey("QT-T1");
    }

    @Test
    void testSample_2() {
        Zephyr.setTestCaseKey("QT-T2");
        throw new RuntimeException("Unexpected error is occurred");
    }

}
