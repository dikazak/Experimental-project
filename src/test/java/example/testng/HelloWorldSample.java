package example.testng;

import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.agent.core.registrar.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class HelloWorldSample {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @BeforeSuite
    void beforeSuite() {
        TestCase.setTestRunId("3");
        System.out.println();
    }

    @BeforeTest
    void beforeTest() {
        System.out.println();
    }

    @BeforeClass
    static void beforeClass() {
        System.out.println();
    }

    @BeforeGroups
    static void beforeGroups() {
        System.out.println();
    }

    @BeforeMethod
    static void beforeMethod() {
        System.out.println();
    }

    @Test(dataProvider = "data")
    void parametrizedTest(String string1, String string2) {
        System.out.println();
    }

    @Test(dependsOnMethods = "parametrizedTest")
    void dependantTest() {
        System.out.println();
        throw new RuntimeException();
    }

    @DataProvider
    public static Object[][] data() {
        return new Object[][]{
                new Object[]{"string11", "string12"},
                new Object[]{"string21", "string22"},
                new Object[]{"string31", "string32"}
        };
    }

    @Test
    @TestCaseKey("DEF-1")
    void helloWorld() {
        LOGGER.info("helloWorld");
    }

    @Test
    @TestCaseKey("DEF-3")
    void helloWorld2() {
        System.out.println();
//        throw new RuntimeException();
    }

    @Test
    @Ignore
    void skippedTest() {
        System.out.println();
    }

    @AfterMethod
    static void afterMethod() {
        System.out.println();
    }

    @AfterGroups
    static void afterGroups() {
        System.out.println();
    }

    @AfterClass
    static void afterClass() {
        System.out.println();
    }

    @AfterTest
    void afterTest() {
        System.out.println();
    }

    @AfterSuite
    static void afterSuite() {
        System.out.println();
    }

}
