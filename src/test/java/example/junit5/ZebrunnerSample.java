package example.junit5;

import com.zebrunner.agent.core.registrar.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ZebrunnerSample {

    @BeforeAll
    static void setUp() {
        TestCase.enableRealTimeSync();
        TestCase.setTestRunId("1");
    }

    @Test
    void testSample() {
        TestCase.setTestCaseKey("TEST-1524");
    }

    @Test
    void testSample_2() {
        TestCase.setTestCaseKey("TEST-1525");
        TestCase.setTestCaseStatus("TEST-1525", "PASSED");
        throw new RuntimeException("Unexpected error is occurred");
    }

}
