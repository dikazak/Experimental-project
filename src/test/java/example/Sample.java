package example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Sample {

    private static final Logger log = LoggerFactory.getLogger(Sample.class);

    @Test
    public void amazing() {
    }

    @Test
    public void kek() {
        throw new RuntimeException("Hello, World!");
//        assertEquals(2, 5);
    }

    @Test(dataProvider = "data")
    public void cool(String param1, String param2) {
    }

    @DataProvider
    public static Object[][] data() {
        return new Object[][]{
                new Object[]{"kek", "kek"},
                new Object[]{"kek1", "kek1"},
                new Object[]{"kek2", "kek2"}
        };
    }

}
