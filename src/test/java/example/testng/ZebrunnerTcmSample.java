package example.testng;

import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.agent.core.registrar.TestCase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ZebrunnerTcmSample {

    @BeforeClass
    static void setUp() {
        TestCase.setTestRunId("1");
        TestCase.enableRealTimeSync();
    }

    @Test
    @TestCaseKey("DEF-1")
    void testSample() {
        throw new RuntimeException("Unexpected error is occurred");
    }

    @Test
    void testSample_2() {
        TestCase.setTestCaseKey("DEF-2");
        throw new RuntimeException("Unexpected error is occurred");
    }

}
