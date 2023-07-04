package example.testng;

import org.testng.annotations.Factory;

class FactorySample {

    @Factory
    Object[] sample() {
        return new Object[] {
                new HelloWorldSample(),
                new HelloWorldSample()
        };
    }

}
