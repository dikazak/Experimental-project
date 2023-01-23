package example.testng;

import org.testng.annotations.Factory;

class FactorySample {

    @Factory
    Object[] factory_1() {
        return new Object[] {
                new HelloWorldSample(),
                new HelloWorldSample()
        };
    }

    @Factory
    Object[] factory_2() {
        return new Object[] {
                new HelloWorldSample()
        };
    }

}
