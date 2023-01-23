package example.junit4;

import com.zebrunner.agent.core.registrar.Zephyr;
import org.junit.BeforeClass;
import org.junit.Test;

public class ZephyrScaleSample {

    @BeforeClass
    public static void setUp() {
        Zephyr.setJiraProjectKey("QT");
        Zephyr.setTestCycleKey("QT-R4");
    }

    @Test
    public void testSample() {
        Zephyr.setTestCaseKey("QT-T1");
    }

    @Test
    public void testSample_2() {
        Zephyr.setTestCaseKey("QT-T2");
        throw new RuntimeException("Unexpected error is occurred");
    }

}
