package example;

import org.testng.annotations.Factory;

public class FactorySample {

    @Factory
    public Object[] sample() {
        return new Object[] {
                new DependantMethodsSample(), new DependantMethodsSample(), new DependantMethodsSample()
        };
    }

}
