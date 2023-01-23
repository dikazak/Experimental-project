package example.testng;

import example.utils.FileUtils;
import org.testng.annotations.Test;

import com.zebrunner.agent.core.registrar.Screenshot;

public class ScreenshotSample {

    @Test
    void test() {
        byte[] screenshotBytes = FileUtils.fromFile("src/test/resources/Circle-icons-computer.png");

        Screenshot.upload(screenshotBytes, System.currentTimeMillis());
    }

}
