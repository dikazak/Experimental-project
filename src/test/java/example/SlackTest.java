package example;

import org.testng.annotations.Test;

public class SlackTest {

    @Test
    public void passedTest() {
        System.out.println();
    }

    @Test
    public void failedTest() {
        throw new RuntimeException("Hello, World!");
    }

}
