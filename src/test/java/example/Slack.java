package example;

import org.testng.annotations.Test;

public class Slack {

    @Test
    public void testSlackNotificationTest1() {
        System.out.println();
    }

    @Test
    public void testSlackNotificationTest2() {
        throw new RuntimeException("Hello, World!");
    }

}
