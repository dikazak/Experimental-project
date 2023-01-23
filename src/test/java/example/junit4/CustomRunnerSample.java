package example.junit4;

import com.zebrunner.agent.core.annotation.Maintainer;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.agent.core.registrar.Artifact;
import com.zebrunner.agent.core.registrar.CurrentTest;
import com.zebrunner.agent.core.registrar.CurrentTestRun;
import com.zebrunner.agent.core.registrar.Label;
import com.zebrunner.agent.core.registrar.Screenshot;
import example.utils.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.invoke.MethodHandles;

@RunWith(CustomRunner.class)
public class CustomRunnerSample {

    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @BeforeClass
    public static void beforeClass() {
        CurrentTestRun.setBuild("1.0-SNAPSHOT");
        CurrentTestRun.setPlatform("API");
        CurrentTestRun.setLocale("English");
        Label.attachToTestRun("Custom run label", "Custom run label");
        log.info("beforeClass");
    }

    @Before
    public void beforeMethod() {
        Label.attachToTest("Custom test label", "custom test label");
        log.info("beforeMethod");
    }

    @Test
    public void helloWorld() {
        log.info("helloWorld");
    }

    @Test
    public void testWithException() {
        throw new RuntimeException();
    }

    @Test
    public void failedTest() {
        Assert.assertTrue(false);
    }

    @Test
    public void failedAssumptionTest() {
        Assume.assumeTrue(false);
    }

    @Test
    public void logger() {
        log.info("logger");
    }

    @Test
    public void screenshot() throws IOException {
        byte[] screenshotBytes = FileUtils.fromFile("src/test/resources/Circle-icons-computer.png");

        Screenshot.upload(screenshotBytes, System.currentTimeMillis());
    }

    @Test
    @Maintainer("admin")
    public void maintainer() {
        log.info("test with maintainer");
    }

    @Test
    @TestLabel(name = "feature", value = "labels")
    public void label() {
        log.info("test with label");
    }

    @Test
    public void revertRegistration() {
        CurrentTest.revertRegistration();
    }

    @Test
    public void attachAdditionalArtifact() throws IOException {
        byte[] iconBytes = FileUtils.fromFile("src/test/resources/Circle-icons-computer.png");

        Artifact.attachToTestRun("icon.png", iconBytes);

        Artifact.attachToTest("icon.png", iconBytes);

        Artifact.attachReferenceToTestRun("Zebrunner in Github", "https://github.com/zebrunner");
        Artifact.attachReferenceToTest("zebrunner.com", "https://zebrunner.com/");
    }

    @Test
    @Ignore("Ignored")
    public void disabledTest() {
        log.info("ignored test");
    }

    @After
    public void afterMethod() {
        log.info("afterMethod");
    }

    @AfterClass
    public static void afterClass() {
        log.info("afterClass");
    }

}
