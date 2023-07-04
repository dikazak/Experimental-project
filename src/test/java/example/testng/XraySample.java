package example.testng;

import com.zebrunner.agent.core.registrar.Xray;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class XraySample {

    @BeforeClass
    static void setUp() {
//        Xray.setExecutionKey("QT-1");
    }

    @Test
    void testSample() {
        Xray.setTestKey("QT-2");
    }

    @Test
    void testSample2() {
        Xray.setTestKey("QT-10");
        throw new RuntimeException("Unexpected error is occurred");
    }

}
