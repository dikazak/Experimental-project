package example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class SimpleTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void helloWorld() {
        System.out.println("Hello, world!");
        System.getenv().forEach((key, value) -> LOGGER.debug(key + ":" + value));
        Assert.assertTrue(true);
    }

}
