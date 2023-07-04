package example.junit5;

import com.zebrunner.agent.core.annotation.Maintainer;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.agent.core.registrar.Artifact;
import com.zebrunner.agent.core.registrar.CurrentTest;
import com.zebrunner.agent.core.registrar.CurrentTestRun;
import com.zebrunner.agent.core.registrar.Screenshot;
import example.utils.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class HelloWorldSample {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @BeforeAll
    static void beforeAll() {
        CurrentTestRun.setLocale("English");
        CurrentTestRun.setBuild("1.0-SNAPSHOT");
        CurrentTestRun.setPlatform("API");
        System.out.println();
    }

    @BeforeEach
    void beforeEach() {
        System.out.println();
    }

    @Test
    void helloWorld() {
        System.out.println();
    }

    @Test
    void helloWorld2() {
        System.out.println();
    }

    @MethodSource("numberToMonth")
    @ParameterizedTest(name = "parametrizedTest({0}, {1})")
    void parametrizedTest(Integer integer, String string) {
        System.out.println(integer + " " + string);
    }

    private static Stream<Arguments> numberToMonth() {
        return Stream.of(
                arguments(1, "January"),
                arguments(2, "February"),
                arguments(12, "December")
        );
    }

    @RepeatedTest(value = 5, name = "Repeated test {currentRepetition}/{totalRepetitions}")
    void repeatedTest() {
        System.out.println();
    }

    @Test
    void logger() {
        LOGGER.info("helloWorld");
    }

    @Test
    void screenshot() throws IOException {
        byte[] screenshotBytes = FileUtils.fromFile("src/test/resources/Circle-icons-computer.png");

        Screenshot.upload(screenshotBytes, System.currentTimeMillis());
    }

    @Test
    @Maintainer("admin")
    void maintainer() {
    }

    @Test
    @TestLabel(name = "feature", value = "labels")
    void label() {
    }

    @Test
    void revertRegistration() {
        CurrentTest.revertRegistration();
    }

    @Test
    void attachAdditionalArtifact() throws IOException {
        byte[] iconBytes = FileUtils.fromFile("src/test/resources/Circle-icons-computer.png");

        Artifact.attachToTestRun("icon.png", iconBytes);

        Artifact.attachToTest("icon.png", iconBytes);

        Artifact.attachReferenceToTestRun("Zebrunner in Github", "https://github.com/zebrunner");
        Artifact.attachReferenceToTest("zebrunner.com", "https://zebrunner.com/");
    }

    @Test
    @Disabled("Disabled")
    void disabledTest() {
        System.out.println();
    }

    @TestFactory
    Collection<DynamicTest> dynamicTestsFromCollection() {
        return Arrays.asList(
                DynamicTest.dynamicTest("1st dynamic test", () -> {
                }),
                DynamicTest.dynamicTest("2nd dynamic test", () -> {
                }),
                DynamicTest.dynamicTest("3d dynamic test", () -> {
                })
        );
    }

    @TestFactory
    DynamicNode dynamicNodeSingleTest() {
        return DynamicTest.dynamicTest("Single dynamic test", () -> {
        });
    }

    @TestFactory
    DynamicNode dynamicNodeSingleContainer() {
        return DynamicContainer.dynamicContainer(
                "Dynamic container",
                Stream.of(1, 2, 3, 4)
                      .map(
                              testNumber -> DynamicTest.dynamicTest("[" + testNumber + "] container-dynamicTest", () -> {
                              })
                      ));
    }

    @AfterEach
    void afterEach() {
        System.out.println();
    }

    @AfterAll
    static void afterAll() {
        System.out.println();
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class NestedClass {

        @BeforeEach
        void nested_beforeEach() {
            System.out.println();
        }

        @Test
        void nested_helloWorld() {
            System.out.println();
        }

        @Test
        void nested_helloWorld2() {
            System.out.println();
        }

        @MethodSource("numberToMonth")
        @ParameterizedTest(name = "nested_parametrizedTest({0}, {1})")
        void nested_parametrizedTest(Integer integer, String string) {
            System.out.println(integer + " " + string);
        }

        Stream<Arguments> numberToMonth() {
            return Stream.of(
                    arguments(1, "January"),
                    arguments(2, "February"),
                    arguments(12, "December")
            );
        }

        @RepeatedTest(value = 5, name = "Repeated test {currentRepetition}/{totalRepetitions}")
        void nested_repeatedTest() {
            System.out.println();
        }

        @Test
        void nested_logger() {
            LOGGER.info("helloWorld");
        }

        @Test
        void nested_screenshot() throws IOException {
            byte[] screenshotBytes = FileUtils.fromFile("src/test/resources/Circle-icons-computer.png");

            Screenshot.upload(screenshotBytes, System.currentTimeMillis());
        }

        @Test
        @Maintainer("admin")
        void nested_maintainer() {
        }

        @Test
        @TestLabel(name = "feature", value = "labels")
        void nested_label() {
        }

        @Test
        void nested_revertRegistration() {
            CurrentTest.revertRegistration();
        }

        @Test
        void nested_attachAdditionalArtifact() throws IOException {
            byte[] iconBytes = FileUtils.fromFile("src/test/resources/Circle-icons-computer.png");

            Artifact.attachToTestRun("icon.png", iconBytes);

            Artifact.attachToTest("icon.png", iconBytes);

            Artifact.attachReferenceToTestRun("Zebrunner in Github", "https://github.com/zebrunner");
            Artifact.attachReferenceToTest("zebrunner.com", "https://zebrunner.com/");
        }

        @Test
        @Disabled("Disabled")
        void nested_disabledTest() {
            System.out.println();
        }

        @TestFactory
        Collection<DynamicTest> nested_dynamicTestsFromCollection() {
            return Arrays.asList(
                    DynamicTest.dynamicTest("nested 1st dynamic test", () -> {
                    }),
                    DynamicTest.dynamicTest("nested 2nd dynamic test", () -> {
                    }),
                    DynamicTest.dynamicTest("nested 3d dynamic test", () -> {
                    })
            );
        }

        @TestFactory
        DynamicNode nested_dynamicNodeSingleTest() {
            return DynamicTest.dynamicTest("Nested single dynamic test", () -> {
            });
        }

        @TestFactory
        DynamicNode nested_dynamicNodeSingleContainer() {
            return DynamicContainer.dynamicContainer(
                    "Dynamic container",
                    Stream.of(1, 2, 3, 4)
                          .map(
                                  testNumber -> DynamicTest.dynamicTest("Nested [" + testNumber + "] container-dynamicTest", () -> {
                                  })
                          ));
        }

        @AfterEach
        void nested_afterEach() {
            System.out.println();
        }

    }

}
