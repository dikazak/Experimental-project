package example.junit4;

import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.agent.core.registrar.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;

public class ZebrunnerSample {

    @BeforeClass
    public static void setUp() {
        TestCase.enableRealTimeSync();
        TestCase.setTestRunId("1");
    }

    @Test
    @TestCaseKey("TEST-1")
    @TestCaseKey({"TEST-2", "TEST-3"})
    public void testSample() {
    }

    @Test
    public void testSample_2() {
        TestCase.setTestCaseKey("TEST-1525");
        TestCase.setTestCaseStatus("TEST-1525", "PASSED");
        throw new RuntimeException("Unexpected error is occurred");
    }

}
