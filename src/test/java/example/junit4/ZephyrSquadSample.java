package example.junit4;

import com.zebrunner.agent.core.registrar.Zephyr;
import org.junit.BeforeClass;
import org.junit.Test;

public class ZephyrSquadSample {

    @BeforeClass
    public static void setUp() {
        Zephyr.setJiraProjectKey("QACO");
        Zephyr.setTestCycleKey("Zebrunner");
    }

    @Test
    public void testSample() {
        Zephyr.setTestCaseKey("QACO-1");
        Zephyr.setTestCaseStatus("QACO-1", "BLOCKED");
    }

    @Test
    public void testSample_2() {
        Zephyr.setTestCaseKey("QACO-2");
        throw new RuntimeException("Unexpected error is occurred");
    }

}
