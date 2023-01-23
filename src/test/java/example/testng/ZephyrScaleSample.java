package example.testng;

import com.zebrunner.agent.core.registrar.Zephyr;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ZephyrScaleSample {

    @BeforeClass
    static void setUp() {
//        Zephyr.setJiraProjectKey("QT");
//        Zephyr.setTestCycleKey("QT-R2");
    }

    @Test
    void testSample() {
        Zephyr.setTestCaseKey("QT-4");
//        throw new RuntimeException("Unexpected error is occurred");
    }

    @Test
    void testSample_2() {
        Zephyr.setTestCaseKey("QT-5");
        throw new RuntimeException("Unexpected error is occurred");
    }

}
