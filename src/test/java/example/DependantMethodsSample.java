package example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class DependantMethodsSample {

    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    // without dependency

    @Test
    public void test1() {
        log.debug("kek");
        log.trace("kek");
        log.error("kek");
        log.warn("kek");
        log.info("test1");
    }

    @Test
    public void test2() {
        log.info("test2");
    }

    @Test
    public void test3() {
        log.info("test3");
    }

    // ---------- LEVEL 1 ----------

    @Test(groups = "level1_group")
    public void level1_dependant_method_1() {
        log.info("level1_dependant_method_1");
    }

    @Test(groups = "level1_group")
    public void level1_dependant_method_2() {
        log.info("level1_dependant_method_2");
    }

    // ---------- LEVEL 2 ----------

    @Test(
            groups = "level2_group",
            dependsOnMethods = {"level1_dependant_method_1", "level1_dependant_method_2"},
            dependsOnGroups = "level1_group"
    )
    public void level2_dependant_method_1() {
        log.info("level1_dependant_method_2");
    }

    @Test(
            groups = "level2_group",
            dependsOnMethods = {"level1_dependant_method_1", "level1_dependant_method_2"},
            dependsOnGroups = "level1_group"
    )
    public void level2_dependant_method_2() {
        log.info("level1_dependant_method_2");
    }

    @Test(
            groups = "level2_group",
            dependsOnMethods = {"level1_dependant_method_1", "level1_dependant_method_2"},
            dependsOnGroups = "level1_group"
    )
    public void level2_dependant_method_3() {
        log.info("level1_dependant_method_2");
    }

    // ---------- LEVEL 3 (root) ----------

    @Test(
            dataProvider = "data",
            dependsOnMethods = {"level2_dependant_method_1", "level2_dependant_method_2", "level2_dependant_method_3"},
            dependsOnGroups = "level2_group"
    )
    public void level3_root(String param1, String param2) {
        throw new RuntimeException(param1 + param2);
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
