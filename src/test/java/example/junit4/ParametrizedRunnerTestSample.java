package example.junit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ParametrizedRunnerTestSample {

    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final Integer integer;
    private final String string;

    public ParametrizedRunnerTestSample(Integer integer, String string) {
        this.integer = integer;
        this.string = string;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> parameters() {
        return Arrays.asList(new Object[][]{
                {1, "January"},
                {2, "February"},
                {3, "December"}
        });
    }

    @Test
    public void parametrizedTest() {
        log.info("Params: 0:{}, 1:{}", integer, string);
    }

}
