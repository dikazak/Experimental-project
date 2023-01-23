package example.junit4;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        HelloWorldSample.class,
        ParametrizedRunnerTestSample.class
})
public class SuiteRunnerSample {
}
