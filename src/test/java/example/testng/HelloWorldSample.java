package example.testng;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class HelloWorldSample {

    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    void test_1() {
        System.getenv().forEach((key, value) -> log.info(key + "=" + value));

        throw new SkipException("test_1 exception message");
    }

    @Test
    void test_2() {
    }

}
