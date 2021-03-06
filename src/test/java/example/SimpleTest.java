package example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class SimpleTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    
    @Test
    public void travis() {
        System.getenv()
              .forEach((key, value) -> LOGGER.warn(key + ":" + value));
    }

    @Test
    public void helloWorld() {
        LOGGER.warn("Hello, world!");
        LOGGER.debug(System.getenv("BUILD NUMBER"));
        Assert.assertTrue(true);
    }

    @Test
    public void hardWorkingTest() {
        for (int j = 0; j < 1_000_000_000; j++) {
            Math.pow(2.0, 5);
        }
        Assert.assertTrue(false);
    }

    @Test
    public void failedTest() {
        LOGGER.warn("Hello, world!");
        Assert.assertTrue(false);
    }

}
