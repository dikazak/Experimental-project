package example.junit4;

import com.zebrunner.agent.core.registrar.Xray;
import org.junit.BeforeClass;
import org.junit.Test;

public class XraySample {

    @BeforeClass
    public static void setUp() {
        Xray.setExecutionKey("QT-1");
    }

    @Test
    public void testSample() {
        Xray.setTestKey("QT-2");
    }

    @Test
    public void testSample_2() {
        Xray.setTestKey("QT-10");
        throw new RuntimeException("Unexpected error is occurred");
    }

    @Test
    public void testSample_3() {
        Xray.setTestKey("QT-11");
    }

    @Test
    public void testSample_4() {
        Xray.setTestKey("QT-18");
        throw new RuntimeException("Unexpected error is occurred");
    }

}
