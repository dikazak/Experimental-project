package example.junit5;

import com.zebrunner.agent.core.registrar.Xray;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class XraySample {

    @BeforeAll
    static void setUp() {
        Xray.setExecutionKey("QT-1");
    }

    @Test
    void testSample() {
        Xray.setTestKey("QT-2");
    }

    @Test
    void testSample_2() {
        Xray.setTestKey("QT-10");
        throw new RuntimeException("Unexpected error is occurred");
    }

    @Test
    void testSample_3() {
        Xray.setTestKey("QT-11");
    }

    @Test
    void testSample_4() {
        Xray.setTestKey("QT-18");
        throw new RuntimeException("Unexpected error is occurred");
    }

}
