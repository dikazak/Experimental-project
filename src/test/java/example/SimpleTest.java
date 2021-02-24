package example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleTest {

    @Test
    public void helloWorld() {
        System.out.println("Hello, world!");
        Assert.assertTrue(true);
    }

}
