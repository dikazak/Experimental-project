package example.testng;

import com.zebrunner.agent.core.registrar.Zephyr;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ZephyrSquadSample {

    @BeforeClass
    static void setUp() {
        Zephyr.setJiraProjectKey("ZEB");
        Zephyr.setTestCycleKey("Demo");
    }

    @Test
    void testSample() {
        Zephyr.setTestCaseKey("ZEB-38");
    }

    @Test
    void testSample_2() {
        Zephyr.setTestCaseKey("ZEB-52");
        throw new RuntimeException("Unexpected error is occurred");
    }

}
